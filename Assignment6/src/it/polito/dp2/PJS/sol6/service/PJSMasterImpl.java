package it.polito.dp2.PJS.sol6.service;

import it.polito.dp2.PJS.lab6.tests.gen.jaxws.PJSDispatch;
import it.polito.dp2.PJS.lab6.tests.gen.jaxws.PJSDispatchService;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.Hosts.Host;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.JobGroups.JobGroup;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.Jobs.Job;
import it.polito.dp2.PJS.sol6.server.xjc.ClusterStatus;
import it.polito.dp2.PJS.sol6.server.xjc.JobStatus;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;

@WebService(name = "PJSMaster", serviceName = "PJSMasterService", wsdlLocation = "wsdl/PJSMaster/PJSMaster.wsdl")
public class PJSMasterImpl implements PJSMaster {

	private Cluster cluster;
	private List<Host> hosts = Collections.synchronizedList(new LinkedList<Host>());
	private Map<Host, PJSDispatch> ports = Collections.synchronizedMap(new HashMap<Host, PJSDispatch>());

	private int jobsCounter = 1;
	
	public PJSMasterImpl(Cluster cluster, Map<Host, URI> executionHosts) {
		this.cluster = cluster;

		// build hosts set
		hosts.addAll(cluster.getHosts().getHost());
		
		// build ports map
		for (Host executionHost : cluster.getHosts().getHost()) {
			URI executionHostURI = executionHosts.get(executionHost);
			if (executionHostURI != null) {
				try {
					URL executionHostWSDL = new URL(executionHostURI.toString() + "/PJSDispatchService");
					QName executionHostQName = new QName("http://pad.polito.it/PJSDispatch", "PJSDispatchService");
					
					PJSDispatchService executionHostService = new PJSDispatchService(executionHostWSDL, executionHostQName);
					
					PJSDispatch executionHostPort = executionHostService.getPJSDispatchPort();
					
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
	public synchronized int submit(String submissionHost, String cmd, String stdin, String jobGroup) {
		System.out.println("Submitting\nSubmission host: " + submissionHost + "\nCommand: " + cmd + "\nStdIn: " + stdin);
		
		//TODO handle jobGroup...
		if (submissionHost == null || cmd == null || stdin == null)
			return -1;
		
		// sort hosts
		Collections.sort(hosts, new Comparator<Host>() {

			@Override
			public int compare(Host o1, Host o2) {
				return o1.getLoad() - o2.getLoad();
			}
		});
		
		for (Host executionHost : hosts) {
			System.out.println("Trying with execution host " + executionHost.getName() + " (" + executionHost.getLoad() + ")...");
			switch (executionHost.getStatus()) {
			case OK:
				PJSDispatch executionHostPort = ports.get(executionHost);
				try {
					BigInteger jobsBigCounter = new BigInteger("" + jobsCounter);
					//FIXME: implement callback function
					String callbackURI = "http://localhost:8182/PJSMaster";
					executionHostPort.dispatch(jobsBigCounter, cmd, stdin, callbackURI);
					
					// job dispatched
					// add load on host
					executionHost.setLoad(executionHost.getLoad() + 1);
					
					// add new job in cluster
					Job dispatchedJob = new Job();
					dispatchedJob.setJobID("" + jobsCounter);
					dispatchedJob.setState(JobStatus.RUNNING);
					dispatchedJob.setExecutionHost(executionHost.getName());
					dispatchedJob.setSubmissionHost(submissionHost);
					dispatchedJob.setSubmissionTime(System.currentTimeMillis());
					cluster.getJobs().getJob().add(dispatchedJob);
					
					jobsCounter++;
					return (jobsCounter - 1);
				} catch (Exception e) {
					System.err.println(executionHost.getName() + " is busy... Trying with other hosts...");
				}
				break;
			}
		}
		System.err.println("No hosts available...");
		return -1;
	}
	
	@Override
	@WebMethod
	@Oneway
	public void endJob(BigInteger jobID, int exitCode, String stdOut) {
		//TODO
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
