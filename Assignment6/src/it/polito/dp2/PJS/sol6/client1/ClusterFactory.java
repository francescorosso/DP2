package it.polito.dp2.PJS.sol6.client1;

import it.polito.dp2.PJS.Cluster;
import it.polito.dp2.PJS.ClusterException;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ClusterFactory extends it.polito.dp2.PJS.ClusterFactory {

	private static Cluster cluster = null;
	
	@Override
	public Cluster newCluster() throws ClusterException {
		if (cluster == null) {
			URL masterHostWSDL = Thread.currentThread().getContextClassLoader().getResource("wsdl/PJSMaster/PJSMaster.wsdl");
			URI masterHostURI = null;
			if (System.getProperty("it.polito.dp2.PJS.sol6.URL1") != null) {
				try {
					masterHostURI = new URI(System.getProperty("it.polito.dp2.PJS.sol6.URL1"));
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
			}
			
			cluster = new ClusterImpl(masterHostWSDL, masterHostURI);
		}
		return cluster;
	}
}
