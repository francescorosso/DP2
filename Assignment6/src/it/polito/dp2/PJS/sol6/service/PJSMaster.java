package it.polito.dp2.PJS.sol6.service;

import it.polito.dp2.PJS.sol6.server.xjc.Cluster.Hosts.Host;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.JobGroups.JobGroup;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.Jobs.Job;
import it.polito.dp2.PJS.sol6.server.xjc.ClusterStatus;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface PJSMaster {

	@WebMethod
	public String getClusterName();
	
	@WebMethod
	public ClusterStatus getClusterStatus();
	
	@WebMethod
	public Host getMasterHost();
	
	@WebMethod
	public String[] getHostNames();

	@WebMethod
	public Host[] getHosts(String[] hostnames);

	@WebMethod
	public JobGroup[] getJobGroups();
	
	@WebMethod
	public Job[] getJobs();
	
	@WebMethod
	public int submit(String submissionHost, String cmd, String stdin) throws NoFreeExecutionHost;

	@WebMethod
	@Oneway
	public void suspendJob(int jobID);
	
	@WebMethod
	@Oneway
	public void resumeJob(int jobID);
	
	@WebMethod
	@Oneway
	public void killJob(int jobID);
	
	@WebMethod
	@Oneway
	public void suspendJobGroup(int jobGroupID);
	
	@WebMethod
	@Oneway
	public void resumeJobGroup(int jobGroupID);
	
	@WebMethod
	@Oneway
	public void killJobGroup(int jobGroupID);
}
