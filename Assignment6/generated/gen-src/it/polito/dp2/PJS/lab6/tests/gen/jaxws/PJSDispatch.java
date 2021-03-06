
package it.polito.dp2.PJS.lab6.tests.gen.jaxws;

import java.math.BigInteger;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PJSDispatch", targetNamespace = "http://pad.polito.it/PJS")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PJSDispatch {


    /**
     * Dispatches a job to the execution host
     *       				 If the job cannot be dispatched a fault is returned:
     * 					 -TooManyJobs if the maximum number of jobs has been reached for this host
     * 					 -AlreadyDispatchedJob if the a job with the same id has already been dispatched to this host
     * 					 If the service is temporarily unavailable the ServiceUnavailable fault is returned
     *       
     * 
     * @param stdin
     * @param jobId
     * @param callbackAddr
     * @param cmdline
     * @throws ServiceUnavailable_Exception
     * @throws AlreadyDispatchedJob_Exception
     * @throws TooManyJobs_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "dispatch", targetNamespace = "http://pad.polito.it/PJS", className = "it.polito.dp2.PJS.lab6.tests.gen.jaxws.Dispatch")
    @ResponseWrapper(localName = "dispatchResponse", targetNamespace = "http://pad.polito.it/PJS", className = "it.polito.dp2.PJS.lab6.tests.gen.jaxws.DispatchResponse")
    public void dispatch(
        @WebParam(name = "jobId", targetNamespace = "")
        BigInteger jobId,
        @WebParam(name = "cmdline", targetNamespace = "")
        String cmdline,
        @WebParam(name = "stdin", targetNamespace = "")
        String stdin,
        @WebParam(name = "callbackAddr", targetNamespace = "")
        String callbackAddr)
        throws AlreadyDispatchedJob_Exception, ServiceUnavailable_Exception, TooManyJobs_Exception
    ;

    /**
     * Resumes the execution of a suspended job
     *       				 If the job was not suspended the operation has no effect
     * 					 If the service is temporarily unavailable the ServiceUnavailable fault is returned
     *       
     * 
     * @param jobId
     * @throws ServiceUnavailable_Exception
     * @throws UnknownJob_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "resume", targetNamespace = "http://pad.polito.it/PJS", className = "it.polito.dp2.PJS.lab6.tests.gen.jaxws.Resume")
    @ResponseWrapper(localName = "resumeResponse", targetNamespace = "http://pad.polito.it/PJS", className = "it.polito.dp2.PJS.lab6.tests.gen.jaxws.ResumeResponse")
    public void resume(
        @WebParam(name = "jobId", targetNamespace = "")
        BigInteger jobId)
        throws ServiceUnavailable_Exception, UnknownJob_Exception
    ;

    /**
     * Suspends the execution of a job
     * 					 If the service is temporarily unavailable the ServiceUnavailable fault is returned
     * 	  
     * 
     * @param jobId
     * @throws ServiceUnavailable_Exception
     * @throws UnknownJob_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "suspend", targetNamespace = "http://pad.polito.it/PJS", className = "it.polito.dp2.PJS.lab6.tests.gen.jaxws.Suspend")
    @ResponseWrapper(localName = "suspendResponse", targetNamespace = "http://pad.polito.it/PJS", className = "it.polito.dp2.PJS.lab6.tests.gen.jaxws.SuspendResponse")
    public void suspend(
        @WebParam(name = "jobId", targetNamespace = "")
        BigInteger jobId)
        throws ServiceUnavailable_Exception, UnknownJob_Exception
    ;

    /**
     * Kills one or more jobs on the host
     * 					 If the service is temporarily unavailable the ServiceUnavailable fault is returned
     *       
     * 
     * @param jobId
     * @throws ServiceUnavailable_Exception
     * @throws UnknownJob_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "kill", targetNamespace = "http://pad.polito.it/PJS", className = "it.polito.dp2.PJS.lab6.tests.gen.jaxws.Kill")
    @ResponseWrapper(localName = "killResponse", targetNamespace = "http://pad.polito.it/PJS", className = "it.polito.dp2.PJS.lab6.tests.gen.jaxws.KillResponse")
    public void kill(
        @WebParam(name = "jobId", targetNamespace = "")
        List<BigInteger> jobId)
        throws ServiceUnavailable_Exception, UnknownJob_Exception
    ;

}
