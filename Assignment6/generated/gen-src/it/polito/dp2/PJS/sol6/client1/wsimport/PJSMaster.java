
package it.polito.dp2.PJS.sol6.client1.wsimport;

import java.math.BigInteger;
import java.util.List;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.0
 * 
 */
@WebService(name = "PJSMaster", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/")
public interface PJSMaster {


    /**
     * Returns all available hosts
     * 
     * @param arg0
     * @return
     *     returns java.util.List<it.polito.dp2.PJS.sol6.client1.wsimport.GetHostsResponse.Return>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHosts", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetHosts")
    @ResponseWrapper(localName = "getHostsResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetHostsResponse")
    public List<it.polito.dp2.PJS.sol6.client1.wsimport.GetHostsResponse.Return> getHosts(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0);

    /**
     * Returns all available jobGroups
     * 
     * @return
     *     returns java.util.List<it.polito.dp2.PJS.sol6.client1.wsimport.GetJobGroupsResponse.Return>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getJobGroups", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetJobGroups")
    @ResponseWrapper(localName = "getJobGroupsResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetJobGroupsResponse")
    public List<it.polito.dp2.PJS.sol6.client1.wsimport.GetJobGroupsResponse.Return> getJobGroups();

    /**
     * Returns all available jobs
     * 
     * @return
     *     returns java.util.List<it.polito.dp2.PJS.sol6.client1.wsimport.GetJobsResponse.Return>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getJobs", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetJobs")
    @ResponseWrapper(localName = "getJobsResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetJobsResponse")
    public List<it.polito.dp2.PJS.sol6.client1.wsimport.GetJobsResponse.Return> getJobs();

    /**
     * Returns the master host
     * 
     * @return
     *     returns it.polito.dp2.PJS.sol6.client1.wsimport.GetMasterHostResponse.Return
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMasterHost", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetMasterHost")
    @ResponseWrapper(localName = "getMasterHostResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetMasterHostResponse")
    public it.polito.dp2.PJS.sol6.client1.wsimport.GetMasterHostResponse.Return getMasterHost();

    /**
     * Returns the cluster name
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getClusterName", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetClusterName")
    @ResponseWrapper(localName = "getClusterNameResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetClusterNameResponse")
    public String getClusterName();

    /**
     * Returns the cluster status
     * 
     * @return
     *     returns it.polito.dp2.PJS.sol6.client1.wsimport.ClusterStatus
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getClusterStatus", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetClusterStatus")
    @ResponseWrapper(localName = "getClusterStatusResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetClusterStatusResponse")
    public ClusterStatus getClusterStatus();

    /**
     * Returns names of all available hosts
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHostNames", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetHostNames")
    @ResponseWrapper(localName = "getHostNamesResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.GetHostNamesResponse")
    public List<String> getHostNames();

    /**
     * Submit a new job
     * 
     * @param cmd
     * @param submissionHostName
     * @param jobGroup
     * @param sdtIn
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "submit", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.Submit")
    @ResponseWrapper(localName = "submitResponse", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.SubmitResponse")
    public int submit(
        @WebParam(name = "submissionHostName", targetNamespace = "")
        String submissionHostName,
        @WebParam(name = "cmd", targetNamespace = "")
        String cmd,
        @WebParam(name = "sdtIn", targetNamespace = "")
        String sdtIn,
        @WebParam(name = "jobGroup", targetNamespace = "")
        String jobGroup);

    /**
     * Callback function: PJSDispatch declares a job
     * 				terminated
     * 			
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "endJob", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.EndJob")
    public void endJob(
        @WebParam(name = "arg0", targetNamespace = "")
        BigInteger arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * Suspend a job
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "suspendJob", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.SuspendJob")
    public void suspendJob(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * Resume a job
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "resumeJob", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.ResumeJob")
    public void resumeJob(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * Kill a job
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "killJob", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.KillJob")
    public void killJob(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * Suspend an entire jobGroup
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "suspendJobGroup", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.SuspendJobGroup")
    public void suspendJobGroup(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * Resume an entire jobGroup
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "resumeJobGroup", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.ResumeJobGroup")
    public void resumeJobGroup(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * Kill an entire jobGroup
     * 
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "killJobGroup", targetNamespace = "http://service.sol6.PJS.dp2.polito.it/", className = "it.polito.dp2.PJS.sol6.client1.wsimport.KillJobGroup")
    public void killJobGroup(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
