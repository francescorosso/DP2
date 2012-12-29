package it.polito.dp2.PJS.sol6.client1;

import it.polito.dp2.PJS.sol6.client1.wsimport.NoFreeExecutionHost_Exception;
import it.polito.dp2.PJS.sol6.client1.wsimport.PJSMaster;
import it.polito.dp2.PJS.sol6.client1.wsimport.PJSMasterService;

import java.net.MalformedURLException;
import java.net.URL;

public class TestPJSMaster {

	public static void main(String[] args) throws MalformedURLException, NoFreeExecutionHost_Exception {
		
		PJSMasterService service = new PJSMasterService(new URL("http://localhost:8182/PJSMaster?wsdl"));
		PJSMaster port = service.getPJSMasterPort();
		
		try {
			Object output = port.submit("cat", "pippo");
	//		Object output = port.getClusterName();
	//		Object output = port.getHostNames();
			
			System.out.println(output);
		} catch (NoFreeExecutionHost_Exception e) {
			e.printStackTrace();
		}
	}
	
}
