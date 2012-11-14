package it.polito.dp2.PJS.sol4;

import it.polito.dp2.PJS.sol4.jaxb.Cluster;
import it.polito.dp2.PJS.sol4.jaxb.Cluster.Hosts.Host;
import it.polito.dp2.PJS.sol4.jaxb.Cluster.JobGroups.JobGroup;
import it.polito.dp2.PJS.sol4.jaxb.Cluster.Jobs.Job;

import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ClusterImpl implements it.polito.dp2.PJS.Cluster {

	private String name;
	private ClusterStatus status;
	private it.polito.dp2.PJS.Host masterHost;
	
	private Set<it.polito.dp2.PJS.Host> hosts;
	private Set<it.polito.dp2.PJS.JobGroup> jobGroups;
	private Set<it.polito.dp2.PJS.Job> jobs;
	
	ClusterImpl(Cluster jaxb) throws InvalidParameterException {
		
		try {
			this.hosts = this.parseHosts(jaxb);
			this.jobGroups = this.parseJobGroups(jaxb);
			this.jobs = this.parseJobs(jaxb);
			
			String name = jaxb.getName();
			if (name != null && !name.equals(""))
				this.name = name;
			else
				throw new InvalidParameterException("Invalid 'name'...");
			
			String status = jaxb.getStatus();
			this.status = ClusterStatus.valueOf(status);
			
			String masterHostName = jaxb.getMasterHost();
			this.masterHost = this.getHost(masterHostName);
			
			if (this.masterHost == null && !this.status.equals(ClusterStatus.UNAVAIL))
				throw new InvalidParameterException("Invalid 'masterHost'...");
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidParameterException(e.getMessage());
		}
	}
	
	private Set<it.polito.dp2.PJS.Host> parseHosts(Cluster jaxb) {
		//extract all hosts
		Set<it.polito.dp2.PJS.Host> hosts = new HashSet<it.polito.dp2.PJS.Host>();
		
		if (jaxb.getHosts() != null) {
			List<Host> hostsList = jaxb.getHosts().getHost();
			for (Host hostElement : hostsList) {
				String name = hostElement.getName();
				String type = hostElement.getType();
				String status = hostElement.getStatus();
				int physicalMemory = hostElement.getMemory(); 
				int load = hostElement.getLoad();
				
				try {
					it.polito.dp2.PJS.Host host = new HostImpl(name, type, status, physicalMemory, load);
					hosts.add(host);
				} catch (InvalidParameterException e) {
					System.out.println("Host is not parsable, skipping...");
				}
			}
		}
		
		return hosts;
	}
	
	private Set<it.polito.dp2.PJS.JobGroup> parseJobGroups(Cluster jaxb) {
		//extract all jobGroups
		Set<it.polito.dp2.PJS.JobGroup> jobGroups = new HashSet<it.polito.dp2.PJS.JobGroup>();
		
		if (jaxb.getJobGroups() != null) {
			List<JobGroup> jobGroupsList = jaxb.getJobGroups().getJobGroup();
			for (JobGroup jobGroupElement : jobGroupsList) {
				String name = jobGroupElement.getName();
				String description = jobGroupElement.getDescription();
				
				try {
					it.polito.dp2.PJS.JobGroup jobGroup = new JobGroupImpl(name, description);
					jobGroups.add(jobGroup);
				} catch (InvalidParameterException e) {
					System.out.println("JobGroup is not parsable, skipping...");
				}
			}
		}
		
		return jobGroups;
	}
	
	private Set<it.polito.dp2.PJS.Job> parseJobs(Cluster jaxb) {
		//extract all jobs
		Set<it.polito.dp2.PJS.Job> jobs = new HashSet<it.polito.dp2.PJS.Job>();
		
		if (jaxb.getJobs() != null) {
			List<Job> jobsList = jaxb.getJobs().getJob();
			for (Job jobElement : jobsList) {
				String jobID = jobElement.getJobID();
				String state = jobElement.getState();
				String submissionHost = jobElement.getSubmissionHost();
				long submissionTime = jobElement.getSubmissionTime();
				String jobGroup = jobElement.getJobGroup();
				String executionHost = jobElement.getExecutionHost();
				
				it.polito.dp2.PJS.Job job = new JobImpl(jobID, state, submissionHost, submissionTime, jobGroup, executionHost);
				jobs.add(job);
			}
		}
		
		return jobs;
	}
	
	private it.polito.dp2.PJS.Host getHost(String name) {
		for (it.polito.dp2.PJS.Host host : this.hosts)
			if (host.getName().equals(name))
				return host;
		return null;
	}
	
	private it.polito.dp2.PJS.JobGroup getJobGroup(String name) {
		for (it.polito.dp2.PJS.JobGroup jobGroup : this.jobGroups)
			if (jobGroup.getName().equals(name))
				return jobGroup;
		return null;
	}
	
	@Override
	public it.polito.dp2.PJS.JobGroup getDefaultJobGroup() {
		for (it.polito.dp2.PJS.JobGroup jobGroup : this.jobGroups) {
			if (jobGroup.getName().equals("default")) {
				return jobGroup;
			}
		}
		return new JobGroupImpl("default", null);
	}

	@Override
	public Set<it.polito.dp2.PJS.Host> getHosts() {
		return this.hosts;
	}

	@Override
	public Set<it.polito.dp2.PJS.JobGroup> getJobGroups() {
		return this.jobGroups;
	}

	@Override
	public Set<it.polito.dp2.PJS.Job> getJobs(boolean hist) {
		if (hist) {
			return this.jobs;
		} else {
			Set<it.polito.dp2.PJS.Job> jobs = new HashSet<it.polito.dp2.PJS.Job>();
			
			for (it.polito.dp2.PJS.Job job : this.jobs) {
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
	public it.polito.dp2.PJS.Host getMasterHost() {
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
	public Set<it.polito.dp2.PJS.Host> getServers() {
		Set<it.polito.dp2.PJS.Host> servers = new HashSet<it.polito.dp2.PJS.Host>();
		for (it.polito.dp2.PJS.Host host : this.hosts)
			if (host.isServer())
				servers.add(host);
		return servers;
	}

	@Override
	public ClusterStatus getStatus() {
		return this.status;
	}

	class HostImpl implements it.polito.dp2.PJS.Host {
		
		private String name;
		private boolean isServer;
		private boolean isMaster;
		private HostStatus status;
		private int physicalMemory;
		private int load;
		
		HostImpl(String name, String type, String status, int physicalMemory, int load) throws InvalidParameterException {

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
				
				this.physicalMemory = physicalMemory;

				this.load = load;
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
	
	class JobGroupImpl implements it.polito.dp2.PJS.JobGroup {

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
		public Set<it.polito.dp2.PJS.Job> getJobs() {
			Set<it.polito.dp2.PJS.Job> jobs = new HashSet<it.polito.dp2.PJS.Job>();
			for (it.polito.dp2.PJS.Job job : ClusterImpl.this.jobs) {
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
	
	class JobImpl implements it.polito.dp2.PJS.Job {
		
		private int jobID;
		private JobState state;
		private it.polito.dp2.PJS.Host submissionHost;
		private long submissionTime;
		private it.polito.dp2.PJS.JobGroup jobGroup;
		private it.polito.dp2.PJS.Host executionHost;
		
		JobImpl(String jobID, String state, String submissionHost, long submissionTime, String jobGroup, String executionHost) throws InvalidParameterException {
			try {
				this.jobID = Integer.parseInt(jobID.substring(1));
				
				this.state = JobState.valueOf(state);
				
				this.submissionHost = ClusterImpl.this.getHost(submissionHost);
				
				this.submissionTime = submissionTime;
				
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
		public it.polito.dp2.PJS.Host getExecutionHost() {
			return executionHost;
		}

		@Override
		public int getID() {
			return this.jobID;
		}

		@Override
		public it.polito.dp2.PJS.JobGroup getJobGroup() {
			return this.jobGroup;
		}

		@Override
		public JobState getState() {
			return this.state;
		}

		@Override
		public it.polito.dp2.PJS.Host getSubmissionHost() {
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
