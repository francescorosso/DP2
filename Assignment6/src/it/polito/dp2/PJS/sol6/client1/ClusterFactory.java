package it.polito.dp2.PJS.sol6.client1;

import it.polito.dp2.PJS.Cluster;
import it.polito.dp2.PJS.ClusterException;
import it.polito.dp2.PJS.sol6.client1.wsimport.PJSMaster;
import it.polito.dp2.PJS.sol6.client1.wsimport.PJSMasterService;

import java.net.URL;

public class ClusterFactory extends it.polito.dp2.PJS.ClusterFactory {

	private static Cluster cluster = null;
	
	@Override
	public Cluster newCluster() throws ClusterException {

		if (cluster == null) {
			
			PJSMaster port = null;
			try {
				URL masterServiceWSDL = Thread.currentThread().getContextClassLoader().getResource("wsdl/PJSMaster/PJSMaster.wsdl");
				port = new PJSMasterService(masterServiceWSDL).getPJSMasterPort();
			} catch (Exception e) {
//				e.printStackTrace();
			}
			
			cluster = new ClusterImpl(port);
		}
		return cluster;
	}
}
