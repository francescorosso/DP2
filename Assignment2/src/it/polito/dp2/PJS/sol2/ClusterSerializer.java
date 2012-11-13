package it.polito.dp2.PJS.sol2;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import it.polito.dp2.PJS.Cluster;
import it.polito.dp2.PJS.Cluster.ClusterStatus;
import it.polito.dp2.PJS.ClusterFactory;
import it.polito.dp2.PJS.Host;
import it.polito.dp2.PJS.Job;
import it.polito.dp2.PJS.Job.JobState;
import it.polito.dp2.PJS.JobGroup;

public class ClusterSerializer {

	private Cluster cluster;
	
	private ClusterSerializer() throws Exception {
		cluster = ClusterFactory.newInstance().newCluster();
	}
	
	private void addInfo(Element clusterElement) {
		//set name attribute
		clusterElement.setAttribute("name", cluster.getName());
		
		//set status attribute
		clusterElement.setAttribute("status", cluster.getStatus().toString());
		
		//set masterHost
		if (cluster.getStatus().equals(ClusterStatus.OK))
			clusterElement.setAttribute("masterHost", cluster.getMasterHost().getName());
	}
	
	private void addHosts(Element hostsElement) {
		//iterate through all hosts
		for (Host host : cluster.getHosts()) {
			Element hostElement = hostsElement.getOwnerDocument().createElement("host");
			hostsElement.appendChild(hostElement);
			
			hostElement.setAttribute("name", host.getName());
			hostElement.setAttribute("status", host.getStatus().toString());
			hostElement.setAttribute("load", Integer.toString(host.getLoad()));
			hostElement.setAttribute("memory", Integer.toString(host.getPhysicalMemory()));
			
			if (host.isMaster())
				hostElement.setAttribute("type", "MASTER");
			else if (host.isServer())
				hostElement.setAttribute("type", "SERVER");
			else
				hostElement.setAttribute("type", "CLIENT");
		}
	}
	
	private void addJobGroups(Element jobGroupsElement) {
		boolean isDefaultPresent = false;
		
		//iterate through all jobGroups
		for (JobGroup jobGroup : cluster.getJobGroups()) {
			addJobGroup(jobGroupsElement, jobGroup.getName(), jobGroup.getDescription());
			
			//check if default jobGroup already present
			if (jobGroup.getName().equals("default"))
				isDefaultPresent = true;
		}
		
		if (!isDefaultPresent) {
			addJobGroup(jobGroupsElement, "default", null);
		}
	}
	
	private void addJobGroup(Element jobGroupsElement, String name, String description) {
		Element jobGroupElement = jobGroupsElement.getOwnerDocument().createElement("jobGroup");
		jobGroupsElement.appendChild(jobGroupElement);
		jobGroupElement.setAttribute("name", name);
		if (description != null)
			jobGroupElement.setAttribute("description", description);
	}
	
	private void addJobs(Element jobsElement) {
		//iterate through all jobs
		for (Job job : cluster.getJobs(true)) {
			Element jobElement = jobsElement.getOwnerDocument().createElement("job");
			jobsElement.appendChild(jobElement);
			
			jobElement.setAttribute("jobID", "_" + job.getID());
			jobElement.setAttribute("state", job.getState().toString());
			jobElement.setAttribute("submissionHost", job.getSubmissionHost().getName());
			jobElement.setAttribute("submissionTime", Long.toString(job.getSubmissionTime().getTimeInMillis()));
			jobElement.setAttribute("jobGroup", job.getJobGroup().getName());
			if (!job.getState().equals(JobState.PENDING))
				jobElement.setAttribute("executionHost", job.getExecutionHost().getName());
		}
	}
	
	private void serializeCluster(File outputFile) throws Exception {
		try {
			Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
			//create root element
			Element clusterElement = dom.createElement("cluster");
			dom.appendChild(clusterElement);
			
			//populate with general infos
			addInfo(clusterElement);
			
			//create hosts element
			Element hostsElement = dom.createElement("hosts");
			clusterElement.appendChild(hostsElement);
			
			//populate hosts element
			addHosts(hostsElement);
			
			//create jobGroups element
			Element jobGroupsElement = dom.createElement("jobGroups");
			clusterElement.appendChild(jobGroupsElement);
			
			//populate jobGroups element
			addJobGroups(jobGroupsElement);
			
			//create jobs element
			Element jobsElement = dom.createElement("jobs");
			clusterElement.appendChild(jobsElement);
			
			//populate jobs element
			addJobs(jobsElement);
			
			//print to file
			Transformer t = TransformerFactory.newInstance().newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "cluster.dtd");
			t.transform(new DOMSource(dom), new StreamResult(outputFile));

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to create and serialize cluster to specified file...");
		}
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
