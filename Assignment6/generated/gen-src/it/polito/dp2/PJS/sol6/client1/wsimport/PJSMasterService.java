
package it.polito.dp2.PJS.sol6.client1.wsimport;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;


/**
 * Service ports (in our case only one...)
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.0
 * 
 */
@WebServiceClient(name = "PJSMasterService", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", wsdlLocation = "file:/home/francesco/workdir/development/DP2/Assignment6/wsdl/PJSMaster/PJSMaster.wsdl")
public class PJSMasterService
    extends Service
{

    private final static URL PJSMASTERSERVICE_WSDL_LOCATION;
    private final static WebServiceException PJSMASTERSERVICE_EXCEPTION;
    private final static QName PJSMASTERSERVICE_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "PJSMasterService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/home/francesco/workdir/development/DP2/Assignment6/wsdl/PJSMaster/PJSMaster.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PJSMASTERSERVICE_WSDL_LOCATION = url;
        PJSMASTERSERVICE_EXCEPTION = e;
    }

    public PJSMasterService() {
        super(__getWsdlLocation(), PJSMASTERSERVICE_QNAME);
    }

    public PJSMasterService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns PJSMaster
     */
    @WebEndpoint(name = "PJSMasterPort")
    public PJSMaster getPJSMasterPort() {
        return super.getPort(new QName("http://service.sol6.PJS.dp2.polito.it/", "PJSMasterPort"), PJSMaster.class);
    }

    private static URL __getWsdlLocation() {
        if (PJSMASTERSERVICE_EXCEPTION!= null) {
            throw PJSMASTERSERVICE_EXCEPTION;
        }
        return PJSMASTERSERVICE_WSDL_LOCATION;
    }

}
