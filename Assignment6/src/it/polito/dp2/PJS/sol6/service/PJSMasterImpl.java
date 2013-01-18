package it.polito.dp2.PJS.sol6.service;

import it.polito.dp2.PJS.lab6.tests.gen.jaxws.PJSDispatch;
import it.polito.dp2.PJS.lab6.tests.gen.jaxws.PJSDispatchService;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.Hosts.Host;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.JobGroups.JobGroup;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.Jobs.Job;
import it.polito.dp2.PJS.sol6.server.xjc.ClusterStatus;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "PJSMaster", serviceName = "PJSMasterService", wsdlLocation = "wsdl/PJSMaster/PJSMaster.wsdl")
public class PJSMasterImpl implements PJSMaster {

	private Cluster cluster;
	private Map<Host, PJSDispatch> ports = new HashMap<Host, PJSDispatch>();

	private int jobsCounter = 1;
	
	public PJSMasterImpl(Cluster cluster, Map<Host, URI> executionHosts) {
		this.cluster = cluster;
		
		// build ports map
		for (Host executionHost : cluster.getHosts().getHost()) {
			URI executionHostURI = executionHosts.get(executionHost);
			if (executionHostURI != null) {
				try {
					URL executionHostWSDL = new URL(executionHostURI.toString() + "/PJSDispatchService");
					URL staticExecutionHostWSDL = Thread.currentThread().getContextClassLoader().getResource("wsdl/PJSDispatch/PJSDispatchService.wsdl");
					QName executionHostQName = new QName("http://pad.polito.it/PJSDispatch", "PJSDispatchService");
					
					PJSDispatchService executionHostService = new PJSDispatchService(staticExecutionHostWSDL, executionHostQName);
					
					PJSDispatch executionHostPort = executionHostService.getPJSDispatchPort();
//					((BindingProvider) executionHostPort).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, executionHostURI.toString());
					
					ports.put(executionHost, executionHostPort);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	@WebMethod
	public String getClusterName() {
		return cluster.getName();
	};
	
	@Override
	@WebMethod
	public ClusterStatus getClusterStatus() {
		return cluster.getStatus();
	};
	
	@Override
	@WebMethod
	public Host getMasterHost() {
		return this.getHosts(new String[]{cluster.getMasterHost()})[0];
	};
	
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
	@ResponseWrapper(className = "it.polito.dp2.PJS.sol6.server.xjc.")
	public Host[] getHosts(String[] hostnames) {
		return cluster.getHosts().getHost().toArray(new Host[0]);
	}


	@Override
	@WebMethod
	public JobGroup[] getJobGroups() {
		return cluster.getJobGroups().getJobGroup().toArray(new JobGroup[0]);
	};
	
	@Override
	@WebMethod
	public Job[] getJobs() {
		return cluster.getJobs().getJob().toArray(new Job[0]);
	};
	
	
	@Override
	@WebMethod
	public int submit(String submissionHost, String cmd, String stdin) throws NoFreeExecutionHost {
		for (Host executionHost : cluster.getHosts().getHost()) {
			PJSDispatch executionHostPort = ports.get(executionHost);
			
			try {
				BigInteger jobsBigCounter = new BigInteger("" + jobsCounter);
				String callbackURI = "http://localhost:8182/PJSMaster";
				executionHostPort.dispatch(jobsBigCounter, cmd, stdin, callbackURI);
				
				// job dispatched
				//FIXME
				Job dispatchedJob = new Job();
				dispatchedJob.setJobID("" + jobsCounter);
				dispatchedJob.setExecutionHost(executionHost.getName());
				dispatchedJob.setSubmissionHost(submissionHost);
				dispatchedJob.setSubmissionTime(System.currentTimeMillis());
				cluster.getJobs().getJob().add(dispatchedJob);
				
				jobsCounter++;
				return (jobsCounter - 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//throw new NoFreeExecutionHost("Unable to find a suitable executionHost...");
		return 1;
	}

	@Override
	@WebMethod
	@Oneway
	public void suspendJob(int jobID) {
		//TODO
	}

	@Override
	@WebMethod
	@Oneway
	public void resumeJob(int jobID) {
		//TODO
	}

	@Override
	@WebMethod
	@Oneway
	public void killJob(int jobID) {
		//TODO
	}

	@Override
	@WebMethod
	@Oneway
	public void suspendJobGroup(int jobGroupID) {
		//TODO
	}

	@Override
	@WebMethod
	@Oneway
	public void resumeJobGroup(int jobGroupID) {
		//TODO
	}

	@Override
	@WebMethod
	@Oneway
	public void killJobGroup(int jobGroupID) {
		//TODO
	}
}
