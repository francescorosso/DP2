
package it.polito.dp2.PJS.lab6.tests.gen.jaxws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "UnknownJob", targetNamespace = "http://pad.polito.it/PJS")
public class UnknownJob_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private UnknownJob faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public UnknownJob_Exception(String message, UnknownJob faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public UnknownJob_Exception(String message, UnknownJob faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: it.polito.dp2.PJS.lab6.tests.gen.jaxws.UnknownJob
     */
    public UnknownJob getFaultInfo() {
        return faultInfo;
    }

}
