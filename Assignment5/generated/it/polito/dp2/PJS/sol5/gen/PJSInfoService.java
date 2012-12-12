
package it.polito.dp2.PJS.sol5.gen;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PJSInfoService", targetNamespace = "http://pad.polito.it/PJSInfo", wsdlLocation = "http://localhost:8181/PJSInfoService?wsdl")
public class PJSInfoService
    extends Service
{

    private final static URL PJSINFOSERVICE_WSDL_LOCATION;
    private final static WebServiceException PJSINFOSERVICE_EXCEPTION;
    private final static QName PJSINFOSERVICE_QNAME = new QName("http://pad.polito.it/PJSInfo", "PJSInfoService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8181/PJSInfoService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PJSINFOSERVICE_WSDL_LOCATION = url;
        PJSINFOSERVICE_EXCEPTION = e;
    }

    public PJSInfoService() {
        super(__getWsdlLocation(), PJSINFOSERVICE_QNAME);
    }

    public PJSInfoService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PJSINFOSERVICE_QNAME, features);
    }

    public PJSInfoService(URL wsdlLocation) {
        super(wsdlLocation, PJSINFOSERVICE_QNAME);
    }

    public PJSInfoService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PJSINFOSERVICE_QNAME, features);
    }

    public PJSInfoService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PJSInfoService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PJSInfo
     */
    @WebEndpoint(name = "PJSInfoServiceSOAPPort")
    public PJSInfo getPJSInfoServiceSOAPPort() {
        return super.getPort(new QName("http://pad.polito.it/PJSInfo", "PJSInfoServiceSOAPPort"), PJSInfo.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PJSInfo
     */
    @WebEndpoint(name = "PJSInfoServiceSOAPPort")
    public PJSInfo getPJSInfoServiceSOAPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://pad.polito.it/PJSInfo", "PJSInfoServiceSOAPPort"), PJSInfo.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PJSINFOSERVICE_EXCEPTION!= null) {
            throw PJSINFOSERVICE_EXCEPTION;
        }
        return PJSINFOSERVICE_WSDL_LOCATION;
    }

}