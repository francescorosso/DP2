package it.polito.dp2.PJS.sol6.service;

import it.polito.dp2.PJS.lab6.tests.gen.jaxb.Hosts;
import it.polito.dp2.PJS.lab6.tests.gen.jaxb.THost;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.Hosts.Host;
import it.polito.dp2.PJS.sol6.server.xjc.Cluster.JobGroups.JobGroup;
import it.polito.dp2.PJS.sol6.server.xjc.ClusterStatus;
import it.polito.dp2.PJS.sol6.server.xjc.HostStatus;
import it.polito.dp2.PJS.sol6.server.xjc.HostType;
import it.polito.dp2.PJS.sol6.server.xjc.ObjectFactory;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.Endpoint;

public class StartMasterHostServer {

	public static void main(String[] args) {

		Map<Host, URI> executionHosts = new HashMap<Host, URI>();
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("xml/execHosts.xml");
			JAXBContext context = JAXBContext.newInstance("it.polito.dp2.PJS.lab6.tests.gen.jaxb");
			Hosts hosts = (Hosts) context.createUnmarshaller().unmarshal(is);
			
			for (THost host : hosts.getHost()) {
				Host executionHost = new Host();
				executionHost.setName(host.getName());
				switch (host.getType()) {
				case MASTER:
					executionHost.setType(HostType.MASTER);
					break;
				case SERVER:
					executionHost.setType(HostType.SERVER);
					break;
				case CLIENT:
				default:
					executionHost.setType(HostType.CLIENT);
					break;
				}
				
				switch (host.getStatus()) {
				case OK:
				default:
					executionHost.setStatus(HostStatus.OK);
					break;
				case CLOSED:
					executionHost.setStatus(HostStatus.CLOSED);
					break;
				case UNAVAIL:
					executionHost.setStatus(HostStatus.UNAVAIL);
					break;
				case UNLICENSED:
					executionHost.setStatus(HostStatus.UNLICENSED);
					break;
				}
				executionHost.setLoad(host.getLoad().intValue());
				executionHost.setMemory(host.getMemory().intValue());
				
				URI executionHostURI = new URI(host.getUri());
				
				executionHosts.put(executionHost, executionHostURI);
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		Cluster cluster = new Cluster();
		
		cluster.setHosts(new ObjectFactory().createClusterHosts());
		cluster.getHosts().getHost().addAll(executionHosts.keySet());
		
		cluster.setJobGroups(new ObjectFactory().createClusterJobGroups());
		JobGroup defaultJobGroup = new JobGroup();
		defaultJobGroup.setName("default");
		defaultJobGroup.setDescription("Default Job Group");
		cluster.getJobGroups().getJobGroup().add(defaultJobGroup);
		
		cluster.setJobs(new ObjectFactory().createClusterJobs());
		
		cluster.setName("PJS");
		cluster.setStatus(ClusterStatus.UNAVAIL);
		for (Host host : cluster.getHosts().getHost()) {
			if (host.getType().equals(HostType.MASTER)) {
				cluster.setStatus(ClusterStatus.OK);
				cluster.setMasterHost(host.getName());
				break;
			}
		}
		
//		new ServicePublisher("http://localhost:8085/", new PJSDispatchImpl()).start();
//		new ServicePublisher("http://localhost:8086/", new PJSDispatchImpl()).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new ServicePublisher("http://localhost:8182/PJSMaster", new PJSMasterImpl(cluster, executionHosts)).start();
	}
	
	static class ServicePublisher extends Thread {
		
		private String address;
		private Object implementor;
		
		public ServicePublisher(String address, Object implementor) {
			this.address = address;
			this.implementor = implementor;
		}
		
		@Override
		public void run() {
			Endpoint endpoint = Endpoint.create(implementor);
			endpoint.setExecutor(Executors.newFixedThreadPool(10));
			endpoint.publish(address);
		}
	}
}