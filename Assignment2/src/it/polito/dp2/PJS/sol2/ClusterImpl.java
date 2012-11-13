package it.polito.dp2.PJS.sol2;

import it.polito.dp2.PJS.Host;
import it.polito.dp2.PJS.Job;
import it.polito.dp2.PJS.JobGroup;

import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class ClusterImpl implements it.polito.dp2.PJS.Cluster {

	private String name;
	private ClusterStatus status;
	private Host masterHost;
	
	private Set<Host> hosts;
	private Set<JobGroup> jobGroups;
	private Set<Job> jobs;
	
	ClusterImpl(Document dom) throws InvalidParameterException {
		
		try {
			this.hosts = this.parseHosts(dom);
			this.jobGroups = this.parseJobGroups(dom);
			this.jobs = this.parseJobs(dom);
			
			String name = dom.getDocumentElement().getAttribute("name");
			if (name != null && !name.equals(""))
				this.name = name;
			else
				throw new InvalidParameterException("Invalid 'name'...");
			
			String status = dom.getDocumentElement().getAttribute("status");
			this.status = ClusterStatus.valueOf(status);
			
			String masterHostName = dom.getDocumentElement().getAttribute("masterHost");
			this.masterHost = this.getHost(masterHostName);
			
			if (this.masterHost == null && !this.status.equals(ClusterStatus.UNAVAIL))
				throw new InvalidParameterException("Invalid 'masterHost'...");
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidParameterException(e.getMessage());
		}
	}
	
	private Set<Host> parseHosts(Document dom) {
		//extract all hosts
		Set<Host> hosts = new HashSet<Host>();
		
		NodeList hostsList = dom.getElementsByTagNameNS(dom.getNamespaceURI(), "host");
		for (int i = 0; i < hostsList.getLength(); i++) {
			Node hostNode = hostsList.item(i);
			if (hostNode instanceof Element) {
				Element hostElement = (Element) hostNode;
				String name = hostElement.getAttribute("name");
				String type = hostElement.getAttribute("type");
				String status = hostElement.getAttribute("status");
				String physicalMemory = hostElement.getAttribute("memory"); 
				String load = hostElement.getAttribute("load");
				
				try {
					Host host = new HostImpl(name, type, status, physicalMemory, load);
					hosts.add(host);
				} catch (InvalidParameterException e) {
					System.out.println("Host at index " + i + " is not parsable, skipping...");
				}
			}
		}
		
		return hosts;
	}
	
	private Set<JobGroup> parseJobGroups(Document dom) {
		//extract all jobGroups
		Set<JobGroup> jobGroups = new HashSet<JobGroup>();
		
		NodeList jobGroupsList = dom.getElementsByTagNameNS(dom.getNamespaceURI(), "jobGroup");
		for (int i = 0; i < jobGroupsList.getLength(); i++) {
			Node jobGroupNode = jobGroupsList.item(i);
			if (jobGroupNode instanceof Element) {
				Element jobGroupElement = (Element) jobGroupNode;
				String name = jobGroupElement.getAttribute("name");
				String description = jobGroupElement.getAttribute("description");
				
				try {
					JobGroup jobGroup = new JobGroupImpl(name, description);
					jobGroups.add(jobGroup);
				} catch (InvalidParameterException e) {
					System.out.println("JobGroup at index " + i + " is not parsable, skipping...");
				}
			}
		}
		
		return jobGroups;
	}
	
	private Set<Job> parseJobs(Document dom) {
		//extract all jobs
		Set<Job> jobs = new HashSet<Job>();
		
		NodeList jobsList = dom.getElementsByTagNameNS(dom.getNamespaceURI(), "job");
		for (int i = 0; i < jobsList.getLength(); i++) {
			Node jobNode = jobsList.item(i);
			if (jobNode instanceof Element) {
				Element jobElement = (Element) jobNode;
				String jobID = jobElement.getAttribute("jobID");
				String state = jobElement.getAttribute("state");
				String submissionHost = jobElement.getAttribute("submissionHost");
				String submissionTime = jobElement.getAttribute("submissionTime");
				String jobGroup = jobElement.getAttribute("jobGroup");
				String executionHost = jobElement.getAttribute("executionHost");
				
				Job job = new JobImpl(jobID, state, submissionHost, submissionTime, jobGroup, executionHost);
				jobs.add(job);
			}
		}
		
		return jobs;
	}
	
	private Host getHost(String name) {
		for (Host host : this.hosts)
			if (host.getName().equals(name))
				return host;
		return null;
	}
	
	private JobGroup getJobGroup(String name) {
		for (JobGroup jobGroup : this.jobGroups)
			if (jobGroup.getName().equals(name))
				return jobGroup;
		return null;
	}
	
	@Override
	public JobGroup getDefaultJobGroup() {
		for (JobGroup jobGroup : this.jobGroups) {
			if (jobGroup.getName().equals("default")) {
				return jobGroup;
			}
		}
		return new JobGroupImpl("default", null);
	}

	@Override
	public Set<Host> getHosts() {
		return this.hosts;
	}

	@Override
	public Set<JobGroup> getJobGroups() {
		return this.jobGroups;
	}

	@Override
	public Set<Job> getJobs(boolean hist) {
		if (hist) {
			return this.jobs;
		} else {
			Set<Job> jobs = new HashSet<Job>();
			
			for (Job job : this.jobs) {
				switch (job.getState()) {
				case DONE:
				case EXIT:
					continue;
				case PENDING:
				case RUNNING:
				case SUSPENDED:
				default:
					jobs.add(job);
				}
			}
			return jobs;
		}
	}

	@Override
	public Host getMasterHost() {
		return this.masterHost;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getNumberOfHosts() {
		return hosts.size();
	}

	@Override
	public int getNumberOfServers() {
		return this.getServers().size();
	}

	@Override
	public Set<Host> getServers() {
		Set<Host> servers = new HashSet<Host>();
		for (Host host : this.hosts)
			if (host.isServer())
				servers.add(host);
		return servers;
	}

	@Override
	public ClusterStatus getStatus() {
		return this.status;
	}

	class HostImpl implements Host {
		
		private String name;
		private boolean isServer;
		private boolean isMaster;
		private HostStatus status;
		private int physicalMemory;
		private int load;
		
		HostImpl(String name, String type, String status, String physicalMemory, String load) throws InvalidParameterException {

			try {
				this.name = name;
				
				if (type.equals("MASTER")) {
					this.isServer = true;
					this.isMaster = true;
				} else if (type.equals("SERVER")) {
					this.isServer = true;
					this.isMaster = false;
				} else {
					this.isServer = false;
					this.isMaster = false;
				}
				
				this.status = HostStatus.valueOf(status);
				
				if (physicalMemory != null)
					this.physicalMemory = Integer.parseInt(physicalMemory);
				else
					this.physicalMemory = -1;
				
				if (load != null) 
					this.load = Integer.parseInt(load);
				else
					this.load = 0;
			} catch (Exception e) {
				e.printStackTrace();
				throw new InvalidParameterException(e.getMessage());
			}
		}

		@Override
		public int getLoad() {
			return this.load;
		}

		@Override
		public String getName() {
			return this.name;
		}

		@Override
		public int getPhysicalMemory() {
			return this.physicalMemory;
		}

		@Override
		public HostStatus getStatus() {
			return this.status;
		}

		@Override
		public boolean isMaster() {
			return this.isMaster;
		}

		@Override
		public boolean isServer() {
			return this.isServer;
		}

	}
	
	class JobGroupImpl implements JobGroup {

		private String name;
		private String description;
		
		JobGroupImpl(String name, String description) throws InvalidParameterException {
			if (name != null)
				this.name = name;
			else
				throw new InvalidParameterException("Empty jobGroup title...");
			this.description = description;
		}
		
		@Override
		public String getDescription() {
			return this.description;
		}

		@Override
		public Set<Job> getJobs() {
			Set<Job> jobs = new HashSet<Job>();
			for (Job job : ClusterImpl.this.jobs) {
				if (job.getJobGroup().getName().equals(this.name)) {
					jobs.add(job);
				}
			}
			return jobs;
		}

		@Override
		public String getName() {
			return this.name;
		}

	}
	
	class JobImpl implements Job {
		
		private int jobID;
		private JobState state;
		private Host submissionHost;
		private long submissionTime;
		private JobGroup jobGroup;
		private Host executionHost;
		
		JobImpl(String jobID, String state, String submissionHost, String submissionTime, String jobGroup, String executionHost) throws InvalidParameterException {
			try {
				this.jobID = Integer.parseInt(jobID.substring(1));
				
				this.state = JobState.valueOf(state);
				
				this.submissionHost = ClusterImpl.this.getHost(submissionHost);
				
				this.submissionTime = Long.valueOf(submissionTime);
				
				if (jobGroup != null)
					this.jobGroup = ClusterImpl.this.getJobGroup(jobGroup);
				else
					this.jobGroup = ClusterImpl.this.getDefaultJobGroup();
				
				if (executionHost != null)
					this.executionHost = ClusterImpl.this.getHost(executionHost);
				else
					this.executionHost = null;
			} catch (Exception e) {
				e.printStackTrace();
				throw new InvalidParameterException(e.getMessage());
			}
		}

		@Override
		public Host getExecutionHost() {
			return executionHost;
		}

		@Override
		public int getID() {
			return this.jobID;
		}

		@Override
		public JobGroup getJobGroup() {
			return this.jobGroup;
		}

		@Override
		public JobState getState() {
			return this.state;
		}

		@Override
		public Host getSubmissionHost() {
			return this.submissionHost;
		}

		@Override
		public Calendar getSubmissionTime() {
			Calendar submissionTime = GregorianCalendar.getInstance();
			submissionTime.setTimeInMillis(this.submissionTime);
			return submissionTime;
		}
		
	}
}
