package it.polito.dp2.PJS.sol4;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import it.polito.dp2.PJS.sol4.jaxb.Cluster;
import it.polito.dp2.PJS.sol4.jaxb.Cluster.Hosts;
import it.polito.dp2.PJS.sol4.jaxb.Cluster.Hosts.Host;
import it.polito.dp2.PJS.sol4.jaxb.Cluster.JobGroups;
import it.polito.dp2.PJS.sol4.jaxb.Cluster.JobGroups.JobGroup;
import it.polito.dp2.PJS.sol4.jaxb.Cluster.Jobs;
import it.polito.dp2.PJS.sol4.jaxb.Cluster.Jobs.Job;

public class ClusterSerializer {

	private it.polito.dp2.PJS.Cluster cluster;
	
	private ClusterSerializer() throws Exception {
		cluster = it.polito.dp2.PJS.ClusterFactory.newInstance().newCluster();
	}
	
	private void addInfo(Cluster jaxb) {
		//set name attribute
		jaxb.setName(cluster.getName());
		
		//set status attribute
		jaxb.setStatus(cluster.getStatus().toString());
		
		//set masterHost
		if (cluster.getStatus().equals(it.polito.dp2.PJS.Cluster.ClusterStatus.OK))
			jaxb.setMasterHost(cluster.getMasterHost().getName());
	}
	
	private void addHosts(Hosts hostsElement) {
		
		
		//iterate through all hosts
		for (it.polito.dp2.PJS.Host host : cluster.getHosts()) {
			Host hostElement = new Host();
			hostsElement.getHost().add(hostElement);
			
			hostElement.setName(host.getName());
			hostElement.setStatus(host.getStatus().toString());
			hostElement.setLoad(host.getLoad());
			hostElement.setMemory(host.getPhysicalMemory());
			
			if (host.isMaster())
				hostElement.setType("MASTER");
			else if (host.isServer())
				hostElement.setType("SERVER");
			else
				hostElement.setType("CLIENT");
		}
	}
	
	private void addJobGroups(JobGroups jobGroupsElement) {
		boolean isDefaultPresent = false;
		
		//iterate through all jobGroups
		for (it.polito.dp2.PJS.JobGroup jobGroup : cluster.getJobGroups()) {
			JobGroup jobGroupElement = new JobGroup();
			jobGroupsElement.getJobGroup().add(jobGroupElement);
			
			jobGroupElement.setName(jobGroup.getName());
			jobGroupElement.setDescription(jobGroup.getDescription());
			
			//check if default jobGroup already present
			if (jobGroup.getName().equals("default"))
				isDefaultPresent = true;
		}
		
		if (!isDefaultPresent) {
			JobGroup jobGroupElement = new JobGroup();
			jobGroupsElement.getJobGroup().add(jobGroupElement);
			
			jobGroupElement.setName("default");
			jobGroupElement.setDescription("Default jobGroup");
		}
	}
	
	private void addJobs(Jobs jobsElement) {
		//iterate through all jobs
		for (it.polito.dp2.PJS.Job job : cluster.getJobs(true)) {
			Job jobElement = new Job();
			jobsElement.getJob().add(jobElement);
			
			jobElement.setJobID("_" + job.getID());
			jobElement.setState(job.getState().toString());
			jobElement.setSubmissionHost(job.getSubmissionHost().getName());
			jobElement.setSubmissionTime(job.getSubmissionTime().getTimeInMillis());
			jobElement.setJobGroup(job.getJobGroup().getName());
			if (!job.getState().equals(it.polito.dp2.PJS.Job.JobState.PENDING))
				jobElement.setExecutionHost(job.getExecutionHost().getName());
		}
	}

	private void serializeCluster(File outputFile) throws Exception {
		Cluster jaxb = new Cluster();

		//populate with general infos
		addInfo(jaxb);
		
		//create hosts element
		Hosts hostsElement = new Hosts();
		jaxb.setHosts(hostsElement);
		
		//populate hosts element
		addHosts(hostsElement);
		
		//create jobGroups element
		JobGroups jobGroupsElement = new JobGroups();
		jaxb.setJobGroups(jobGroupsElement);
		
		//populate jobGroups element
		addJobGroups(jobGroupsElement);
		
		//create jobs element
		Jobs jobsElement = new Jobs();
		jaxb.setJobs(jobsElement);
		
		//populate jobs element
		addJobs(jobsElement);
		
		//print to file
		JAXBContext context = JAXBContext.newInstance(it.polito.dp2.PJS.sol4.jaxb.Cluster.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "PJSInfo.xsd");
		marshaller.marshal(jaxb, outputFile);
	}
	
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Output file not provided...");
			System.exit(1);
		}
		
		try {
			ClusterSerializer cs = new ClusterSerializer();
			cs.serializeCluster(new File(args[0]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
