
package it.polito.dp2.PJS.sol6.client1.wsimport;

import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PJSMaster", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PJSMaster {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     * @throws NoFreeExecutionHost_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "submit", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.Submit")
    @ResponseWrapper(localName = "submitResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.SubmitResponse")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/submitRequest", output = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/submitResponse", fault = {
        @FaultAction(className = NoFreeExecutionHost_Exception.class, value = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/submit/Fault/NoFreeExecutionHost")
    })
    public int submit(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2)
        throws NoFreeExecutionHost_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<it.polito.dp2.PJS.sol6.client1.wsimport.GetHostsResponse.Return>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHosts", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetHosts")
    @ResponseWrapper(localName = "getHostsResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetHostsResponse")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getHostsRequest", output = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getHostsResponse")
    public List<it.polito.dp2.PJS.sol6.client1.wsimport.GetHostsResponse.Return> getHosts(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0);

    /**
     * 
     * @return
     *     returns java.util.List<it.polito.dp2.PJS.sol6.client1.wsimport.GetJobGroupsResponse.Return>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getJobGroups", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetJobGroups")
    @ResponseWrapper(localName = "getJobGroupsResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetJobGroupsResponse")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getJobGroupsRequest", output = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getJobGroupsResponse")
    public List<it.polito.dp2.PJS.sol6.client1.wsimport.GetJobGroupsResponse.Return> getJobGroups();

    /**
     * 
     * @return
     *     returns java.util.List<it.polito.dp2.PJS.sol6.client1.wsimport.GetJobsResponse.Return>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getJobs", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetJobs")
    @ResponseWrapper(localName = "getJobsResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetJobsResponse")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getJobsRequest", output = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getJobsResponse")
    public List<it.polito.dp2.PJS.sol6.client1.wsimport.GetJobsResponse.Return> getJobs();

    /**
     * 
     * @return
     *     returns it.polito.dp2.PJS.sol6.client1.wsimport.GetMasterHostResponse.Return
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMasterHost", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetMasterHost")
    @ResponseWrapper(localName = "getMasterHostResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetMasterHostResponse")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getMasterHostRequest", output = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getMasterHostResponse")
    public it.polito.dp2.PJS.sol6.client1.wsimport.GetMasterHostResponse.Return getMasterHost();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getClusterName", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetClusterName")
    @ResponseWrapper(localName = "getClusterNameResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetClusterNameResponse")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getClusterNameRequest", output = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getClusterNameResponse")
    public String getClusterName();

    /**
     * 
     * @return
     *     returns it.polito.dp2.PJS.sol6.client1.wsimport.ClusterStatus
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getClusterStatus", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetClusterStatus")
    @ResponseWrapper(localName = "getClusterStatusResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetClusterStatusResponse")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getClusterStatusRequest", output = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getClusterStatusResponse")
    public ClusterStatus getClusterStatus();

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHostNames", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetHostNames")
    @ResponseWrapper(localName = "getHostNamesResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetHostNamesResponse")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getHostNamesRequest", output = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/getHostNamesResponse")
    public List<String> getHostNames();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "suspendJob", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.SuspendJob")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/suspendJob")
    public void suspendJob(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "resumeJob", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.ResumeJob")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/resumeJob")
    public void resumeJob(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "killJob", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.KillJob")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/killJob")
    public void killJob(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "suspendJobGroup", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.SuspendJobGroup")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/suspendJobGroup")
    public void suspendJobGroup(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "resumeJobGroup", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.ResumeJobGroup")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/resumeJobGroup")
    public void resumeJobGroup(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "killJobGroup", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.KillJobGroup")
    @Action(input = "http://service.sol6.PJS.dp2.polito.it/PJSMaster/killJobGroup")
    public void killJobGroup(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}