package it.polito.dp2.PJS.sol6.client2;

import it.polito.dp2.PJS.lab6.Submit;
import it.polito.dp2.PJS.sol6.client1.wsimport.PJSMaster;
import it.polito.dp2.PJS.sol6.client1.wsimport.PJSMasterService;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

public class Client2 implements Submit {

	@Override
	public int submit(String host, String cmdline, String stdin) {
		
		String masterHostURL = System.getProperty("it.polito.dp2.PJS.sol6.URL2");
		
		URL masterHostWSDL = Thread.currentThread().getContextClassLoader().getResource("PJSMaster/PJSMaster.wsdl");
		
		QName qname = new QName("http://service.sol6.PJS.dp2.polito.it/", "PJSMasterService"); 
		PJSMasterService service = new PJSMasterService(masterHostWSDL, qname);
		PJSMaster port = service.getPJSMasterPort();
		if (masterHostURL != null) {
			try {
				URI masterHostURI = new URI(masterHostURL);
				((BindingProvider) port).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, masterHostURI.toString());
			} catch (URISyntaxException e) {
				System.out.println("Invalid PJSMasterService URL. Check system property it.polito.dp2.PJS.sol6.URL2...");
			}
		}
		
		int jobNumber = port.submit(host, cmdline, stdin, "default");
		return jobNumber;
	}
}
