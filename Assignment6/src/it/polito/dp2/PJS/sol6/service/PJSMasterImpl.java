package it.polito.dp2.PJS.sol6.service;

import it.polito.dp2.PJS.lab6.tests.gen.jaxws.PJSDispatch;
import it.polito.dp2.PJS.lab6.tests.gen.jaxws.PJSDispatchService;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.Hosts;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.Hosts.Host;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.Jobs.Job;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

@WebService(name = "PJSMaster", serviceName = "PJSMasterService")
public class PJSMasterImpl implements PJSMaster {

	private Cluster cluster;
	private Map<Host, PJSDispatch> services = new HashMap<Host, PJSDispatch>();

	private int jobsCounter = 0;
	
	public PJSMasterImpl(Cluster cluster, Map<Host, URI> executionHosts) {
		this.cluster = cluster;
		
		// build ports map
		for (Host executionHost : cluster.getHosts().getHost()) {
			URI executionHostURI = executionHosts.get(executionHost);
			if (executionHostURI != null) {
				try {
					URL executionHostWSDL = executionHostURI.toURL();
					URL staticExecutionHostWSDL = Thread.currentThread().getContextClassLoader().getResource("wsdl/PJSDispatch/PJSDispatchService.wsdl");
					QName executionHostQName = new QName("http://pad.polito.it/PJSDispatch", "PJSDispatchService");
					
					PJSDispatchService executionHostService = new PJSDispatchService(staticExecutionHostWSDL, executionHostQName);
					
					PJSDispatch executionHostPort = executionHostService.getPJSDispatchPort();
					((BindingProvider) executionHostPort).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, executionHostURI.toString());
					
					services.put(executionHost, executionHostPort);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	@WebMethod
	public String[] getHostNames() {
		List<String> hostNames = new ArrayList<String>();
		for(Host host : cluster.getHosts().getHost()) {
			hostNames.add(host.getName());
		}
		return hostNames.toArray(new String[0]);
	}
	
	@Override
	@WebMethod
	public Hosts getHosts() {
		return cluster.getHosts();
	}
	
	@Override
	@WebMethod
	public BigInteger submit(String cmd, String args) throws NoFreeExecutionHost {
		for (Host executionHost : cluster.getHosts().getHost()) {
			PJSDispatch executionHostPort = services.get(executionHost);
			
			try {
				BigInteger jobsBigCounter = new BigInteger("" + jobsCounter);
				String callbackURI = "http://localhost:8182/PJSMaster";
				executionHostPort.dispatch(jobsBigCounter, cmd, args, callbackURI);
				
				// job dispatched
				//FIXME
				Job dispatchedJob = new Job();
				dispatchedJob.setJobID("" + jobsCounter);
				dispatchedJob.setExecutionHost(executionHost.getName());
				dispatchedJob.setSubmissionTime(System.currentTimeMillis());
				cluster.getJobs().getJob().add(dispatchedJob);
				
				jobsCounter++;
				return jobsBigCounter;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new NoFreeExecutionHost("Unable to find a suitable executionHost...");
	}
}
