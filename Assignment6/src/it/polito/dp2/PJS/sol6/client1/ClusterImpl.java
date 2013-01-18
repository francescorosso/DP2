package it.polito.dp2.PJS.sol6.client1;

import it.polito.dp2.PJS.Cluster;
import it.polito.dp2.PJS.Host;
import it.polito.dp2.PJS.Job;
import it.polito.dp2.PJS.JobGroup;
import it.polito.dp2.PJS.sol6.client1.wsimport.GetHostsResponse;
import it.polito.dp2.PJS.sol6.client1.wsimport.GetJobGroupsResponse;
import it.polito.dp2.PJS.sol6.client1.wsimport.GetJobsResponse;
import it.polito.dp2.PJS.sol6.client1.wsimport.GetMasterHostResponse;
import it.polito.dp2.PJS.sol6.client1.wsimport.PJSMaster;
import it.polito.dp2.PJS.sol6.client1.wsimport.PJSMasterService;

import java.net.URI;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.ws.BindingProvider;

class ClusterImpl implements Cluster {

	private URL masterHostWSDL;
	private URI masterHostURI;
	
	private String name;
	private ClusterStatus status;
	private it.polito.dp2.PJS.Host masterHost;
	
	private Set<Host> hosts;
	private Set<JobGroup> jobGroups;
	private Set<Job> jobs;
	
	ClusterImpl(URL masterHostWSDL, URI masterHostURI) {
		this.masterHostWSDL = masterHostWSDL;
		this.masterHostURI = masterHostURI;
		
		this.update();
	}
	
	private void update() {
		PJSMasterService masterHostService = new PJSMasterService(masterHostWSDL);
		PJSMaster masterHostPort = masterHostService.getPJSMasterPort();
		if (masterHostURI != null)
			((BindingProvider) masterHostPort).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, masterHostURI.toString());
		
		this.updateClusterInfo(masterHostPort);
		this.updateHosts(masterHostPort);
		this.updateJobGroups(masterHostPort);
		this.updateJobs(masterHostPort);
	}
	
	private void updateClusterInfo(PJSMaster masterHostPort) {
		try {
			this.name = masterHostPort.getClusterName();
			this.status = ClusterStatus.valueOf(masterHostPort.getClusterStatus().toString());
			
			GetMasterHostResponse.Return hostElement = masterHostPort.getMasterHost();
			String name = hostElement.getName();
			String type = hostElement.getType().toString();
			String status = hostElement.getStatus().toString();
			int physicalMemory = hostElement.getMemory().intValue();
			int load = hostElement.getLoad().intValue();
			Host host = new HostImpl(name, type, status, physicalMemory, load);

			this.masterHost = host;
		} catch (InvalidParameterException e) {
			System.err.println("Host is not parsable, skipping...");
		}
	}
	
	private void updateHosts(PJSMaster masterHostPort) {
		//extract all hosts
		Set<Host> hosts = new HashSet<Host>();
		
		try {
			if (masterHostPort != null && masterHostPort.getHostNames() != null) {
				List<String> hostNames = masterHostPort.getHostNames();
				if (!hostNames.isEmpty()) {
					List<GetHostsResponse.Return> response = masterHostPort.getHosts(hostNames);
					if (response != null) {
						for (GetHostsResponse.Return hostElement : response) {
							String name = hostElement.getName();
							String type = hostElement.getType().toString();
							String status = hostElement.getStatus().toString();
							int physicalMemory = hostElement.getMemory().intValue();
							int load = hostElement.getLoad().intValue();
							
							try {
								Host host = new HostImpl(name, type, status, physicalMemory, load);
								hosts.add(host);
							} catch (InvalidParameterException e) {
								System.err.println("Host is not parsable, skipping...");
							}
						}
					}
				}
			}
			this.hosts = hosts;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void updateJobGroups(PJSMaster masterHostPort) {
		//extract all jobGroups
		Set<JobGroup> jobGroups = new HashSet<JobGroup>();
		
		try {
			if (masterHostPort != null) {
				List<GetJobGroupsResponse.Return> response = masterHostPort.getJobGroups();
				if (response != null) {
					for (GetJobGroupsResponse.Return jobGroupElement : response) {
						String name = jobGroupElement.getName();
						String description = jobGroupElement.getDescription();
						
						try {
							JobGroup jobGroup = new JobGroupImpl(name, description);
							jobGroups.add(jobGroup);
						} catch (InvalidParameterException e) {
							System.err.println("JobGroup not parsable, skipping...");
						}
					}
				}
			}
			this.jobGroups = jobGroups;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void updateJobs(PJSMaster masterHostPort) {
		//extract all jobs
		Set<Job> jobs = new HashSet<Job>();
		try {
			if (masterHostPort != null) {
				List<GetJobsResponse.Return> response = masterHostPort.getJobs();
				if (response != null) {
					for (GetJobsResponse.Return jobElement : response) {
						String jobID = jobElement.getJobID();
						String state = jobElement.getState().toString();
						String submissionHost = jobElement.getSubmissionHost();
						long submissionTime = jobElement.getSubmissionTime();
						String jobGroup = jobElement.getJobGroup();
						String executionHost = jobElement.getExecutionHost();
						
						if (!jobID.startsWith("_"))
							jobID = "_" + jobID;
						
						try {
							Job job = new JobImpl(jobID, state, submissionHost, submissionTime, jobGroup, executionHost);
							jobs.add(job);
						} catch (InvalidParameterException e) {
							System.err.println("Job not parsable, skipping...");
						}
					}
				}
			}
			this.jobs = jobs;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Host getHost(String name) {
		this.update();
		for (Host host : this.hosts)
			if (host.getName().equals(name))
				return host;
		return null;
	}
	
	private JobGroup getJobGroup(String name) {
		this.update();
		for (JobGroup jobGroup : this.jobGroups)
			if (jobGroup.getName().equals(name))
				return jobGroup;
		return null;
	}
	
	@Override
	public JobGroup getDefaultJobGroup() {
		this.update();
		for (JobGroup jobGroup : this.jobGroups) {
			if (jobGroup.getName().equals("default")) {
				return jobGroup;
			}
		}
		return new JobGroupImpl("default", null);
	}

	@Override
	public Set<Host> getHosts() {
		this.update();
		return this.hosts;
	}

	@Override
	public Set<JobGroup> getJobGroups() {
		this.update();
		return this.jobGroups;
	}

	@Override
	public Set<Job> getJobs(boolean hist) {
		this.update();
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
		this.update();
		return hosts.size();
	}

	@Override
	public int getNumberOfServers() {
		this.update();
		return this.getServers().size();
	}

	@Override
	public Set<Host> getServers() {
		this.update();
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
		private String submissionHost;
		private long submissionTime;
		private String jobGroup;
		private String executionHost;
		
		JobImpl(String jobID, String state, String submissionHost, long submissionTime, String jobGroup, String executionHost) throws InvalidParameterException {
			try {
				this.jobID = Integer.parseInt(jobID.substring(1));
				
				this.state = JobState.valueOf(state);
				
				this.submissionHost = submissionHost;
				
				this.submissionTime = submissionTime;
				
				if (jobGroup != null)
					this.jobGroup = jobGroup;
				else
					this.jobGroup = "default";
				
				if (executionHost != null)
					this.executionHost = executionHost;
				else
					this.executionHost = null;
			} catch (Exception e) {
				e.printStackTrace();
				throw new InvalidParameterException(e.getMessage());
			}
		}

		@Override
		public it.polito.dp2.PJS.Host getExecutionHost() {
			return ClusterImpl.this.getHost(executionHost);
		}

		@Override
		public int getID() {
			return this.jobID;
		}

		@Override
		public JobGroup getJobGroup() {
			return ClusterImpl.this.getJobGroup(jobGroup);
		}

		@Override
		public JobState getState() {
			return this.state;
		}

		@Override
		public Host getSubmissionHost() {
			return ClusterImpl.this.getHost(submissionHost);
		}

		@Override
		public Calendar getSubmissionTime() {
			Calendar submissionTime = GregorianCalendar.getInstance();
			submissionTime.setTimeInMillis(this.submissionTime);
			return submissionTime;
		}
		
	}
}
