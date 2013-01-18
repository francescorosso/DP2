
package it.polito.dp2.PJS.sol6.client1.wsimport;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polito.dp2.PJS.sol6.client1.wsimport package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetJobsResponse_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getJobsResponse");
    private final static QName _ResumeJobGroup_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "resumeJobGroup");
    private final static QName _GetJobs_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getJobs");
    private final static QName _GetClusterStatus_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getClusterStatus");
    private final static QName _GetMasterHost_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getMasterHost");
    private final static QName _GetJobGroupsResponse_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getJobGroupsResponse");
    private final static QName _GetHostNamesResponse_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getHostNamesResponse");
    private final static QName _GetClusterNameResponse_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getClusterNameResponse");
    private final static QName _GetHostNames_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getHostNames");
    private final static QName _GetHostsResponse_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getHostsResponse");
    private final static QName _SubmitResponse_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "submitResponse");
    private final static QName _GetJobGroups_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getJobGroups");
    private final static QName _GetMasterHostResponse_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getMasterHostResponse");
    private final static QName _KillJob_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "killJob");
    private final static QName _GetClusterName_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getClusterName");
    private final static QName _KillJobGroup_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "killJobGroup");
    private final static QName _ResumeJob_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "resumeJob");
    private final static QName _SuspendJob_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "suspendJob");
    private final static QName _GetHosts_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getHosts");
    private final static QName _NoFreeExecutionHost_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "NoFreeExecutionHost");
    private final static QName _Submit_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "submit");
    private final static QName _SuspendJobGroup_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "suspendJobGroup");
    private final static QName _GetClusterStatusResponse_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getClusterStatusResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polito.dp2.PJS.sol6.client1.wsimport
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Cluster }
     * 
     */
    public Cluster createCluster() {
        return new Cluster();
    }

    /**
     * Create an instance of {@link Cluster.Jobs }
     * 
     */
    public Cluster.Jobs createClusterJobs() {
        return new Cluster.Jobs();
    }

    /**
     * Create an instance of {@link Cluster.JobGroups }
     * 
     */
    public Cluster.JobGroups createClusterJobGroups() {
        return new Cluster.JobGroups();
    }

    /**
     * Create an instance of {@link Cluster.Hosts }
     * 
     */
    public Cluster.Hosts createClusterHosts() {
        return new Cluster.Hosts();
    }

    /**
     * Create an instance of {@link GetMasterHostResponse }
     * 
     */
    public GetMasterHostResponse createGetMasterHostResponse() {
        return new GetMasterHostResponse();
    }

    /**
     * Create an instance of {@link GetHostsResponse }
     * 
     */
    public GetHostsResponse createGetHostsResponse() {
        return new GetHostsResponse();
    }

    /**
     * Create an instance of {@link GetJobGroupsResponse }
     * 
     */
    public GetJobGroupsResponse createGetJobGroupsResponse() {
        return new GetJobGroupsResponse();
    }

    /**
     * Create an instance of {@link GetJobsResponse }
     * 
     */
    public GetJobsResponse createGetJobsResponse() {
        return new GetJobsResponse();
    }

    /**
     * Create an instance of {@link ResumeJob }
     * 
     */
    public ResumeJob createResumeJob() {
        return new ResumeJob();
    }

    /**
     * Create an instance of {@link KillJobGroup }
     * 
     */
    public KillJobGroup createKillJobGroup() {
        return new KillJobGroup();
    }

    /**
     * Create an instance of {@link Submit }
     * 
     */
    public Submit createSubmit() {
        return new Submit();
    }

    /**
     * Create an instance of {@link NoFreeExecutionHost }
     * 
     */
    public NoFreeExecutionHost createNoFreeExecutionHost() {
        return new NoFreeExecutionHost();
    }

    /**
     * Create an instance of {@link SuspendJob }
     * 
     */
    public SuspendJob createSuspendJob() {
        return new SuspendJob();
    }

    /**
     * Create an instance of {@link GetHosts }
     * 
     */
    public GetHosts createGetHosts() {
        return new GetHosts();
    }

    /**
     * Create an instance of {@link SuspendJobGroup }
     * 
     */
    public SuspendJobGroup createSuspendJobGroup() {
        return new SuspendJobGroup();
    }

    /**
     * Create an instance of {@link GetClusterStatusResponse }
     * 
     */
    public GetClusterStatusResponse createGetClusterStatusResponse() {
        return new GetClusterStatusResponse();
    }

    /**
     * Create an instance of {@link ResumeJobGroup }
     * 
     */
    public ResumeJobGroup createResumeJobGroup() {
        return new ResumeJobGroup();
    }

    /**
     * Create an instance of {@link GetJobs }
     * 
     */
    public GetJobs createGetJobs() {
        return new GetJobs();
    }

    /**
     * Create an instance of {@link GetClusterNameResponse }
     * 
     */
    public GetClusterNameResponse createGetClusterNameResponse() {
        return new GetClusterNameResponse();
    }

    /**
     * Create an instance of {@link GetHostNamesResponse }
     * 
     */
    public GetHostNamesResponse createGetHostNamesResponse() {
        return new GetHostNamesResponse();
    }

    /**
     * Create an instance of {@link GetMasterHost }
     * 
     */
    public GetMasterHost createGetMasterHost() {
        return new GetMasterHost();
    }

    /**
     * Create an instance of {@link GetClusterStatus }
     * 
     */
    public GetClusterStatus createGetClusterStatus() {
        return new GetClusterStatus();
    }

    /**
     * Create an instance of {@link GetJobGroups }
     * 
     */
    public GetJobGroups createGetJobGroups() {
        return new GetJobGroups();
    }

    /**
     * Create an instance of {@link SubmitResponse }
     * 
     */
    public SubmitResponse createSubmitResponse() {
        return new SubmitResponse();
    }

    /**
     * Create an instance of {@link GetHostNames }
     * 
     */
    public GetHostNames createGetHostNames() {
        return new GetHostNames();
    }

    /**
     * Create an instance of {@link GetClusterName }
     * 
     */
    public GetClusterName createGetClusterName() {
        return new GetClusterName();
    }

    /**
     * Create an instance of {@link KillJob }
     * 
     */
    public KillJob createKillJob() {
        return new KillJob();
    }

    /**
     * Create an instance of {@link Cluster.Jobs.Job }
     * 
     */
    public Cluster.Jobs.Job createClusterJobsJob() {
        return new Cluster.Jobs.Job();
    }

    /**
     * Create an instance of {@link Cluster.JobGroups.JobGroup }
     * 
     */
    public Cluster.JobGroups.JobGroup createClusterJobGroupsJobGroup() {
        return new Cluster.JobGroups.JobGroup();
    }

    /**
     * Create an instance of {@link Cluster.Hosts.Host }
     * 
     */
    public Cluster.Hosts.Host createClusterHostsHost() {
        return new Cluster.Hosts.Host();
    }

    /**
     * Create an instance of {@link GetMasterHostResponse.Return }
     * 
     */
    public GetMasterHostResponse.Return createGetMasterHostResponseReturn() {
        return new GetMasterHostResponse.Return();
    }

    /**
     * Create an instance of {@link GetHostsResponse.Return }
     * 
     */
    public GetHostsResponse.Return createGetHostsResponseReturn() {
        return new GetHostsResponse.Return();
    }

    /**
     * Create an instance of {@link GetJobGroupsResponse.Return }
     * 
     */
    public GetJobGroupsResponse.Return createGetJobGroupsResponseReturn() {
        return new GetJobGroupsResponse.Return();
    }

    /**
     * Create an instance of {@link GetJobsResponse.Return }
     * 
     */
    public GetJobsResponse.Return createGetJobsResponseReturn() {
        return new GetJobsResponse.Return();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJobsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getJobsResponse")
    public JAXBElement<GetJobsResponse> createGetJobsResponse(GetJobsResponse value) {
        return new JAXBElement<GetJobsResponse>(_GetJobsResponse_QNAME, GetJobsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResumeJobGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "resumeJobGroup")
    public JAXBElement<ResumeJobGroup> createResumeJobGroup(ResumeJobGroup value) {
        return new JAXBElement<ResumeJobGroup>(_ResumeJobGroup_QNAME, ResumeJobGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJobs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getJobs")
    public JAXBElement<GetJobs> createGetJobs(GetJobs value) {
        return new JAXBElement<GetJobs>(_GetJobs_QNAME, GetJobs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClusterStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getClusterStatus")
    public JAXBElement<GetClusterStatus> createGetClusterStatus(GetClusterStatus value) {
        return new JAXBElement<GetClusterStatus>(_GetClusterStatus_QNAME, GetClusterStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMasterHost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getMasterHost")
    public JAXBElement<GetMasterHost> createGetMasterHost(GetMasterHost value) {
        return new JAXBElement<GetMasterHost>(_GetMasterHost_QNAME, GetMasterHost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJobGroupsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getJobGroupsResponse")
    public JAXBElement<GetJobGroupsResponse> createGetJobGroupsResponse(GetJobGroupsResponse value) {
        return new JAXBElement<GetJobGroupsResponse>(_GetJobGroupsResponse_QNAME, GetJobGroupsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostNamesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getHostNamesResponse")
    public JAXBElement<GetHostNamesResponse> createGetHostNamesResponse(GetHostNamesResponse value) {
        return new JAXBElement<GetHostNamesResponse>(_GetHostNamesResponse_QNAME, GetHostNamesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClusterNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getClusterNameResponse")
    public JAXBElement<GetClusterNameResponse> createGetClusterNameResponse(GetClusterNameResponse value) {
        return new JAXBElement<GetClusterNameResponse>(_GetClusterNameResponse_QNAME, GetClusterNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostNames }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getHostNames")
    public JAXBElement<GetHostNames> createGetHostNames(GetHostNames value) {
        return new JAXBElement<GetHostNames>(_GetHostNames_QNAME, GetHostNames.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getHostsResponse")
    public JAXBElement<GetHostsResponse> createGetHostsResponse(GetHostsResponse value) {
        return new JAXBElement<GetHostsResponse>(_GetHostsResponse_QNAME, GetHostsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "submitResponse")
    public JAXBElement<SubmitResponse> createSubmitResponse(SubmitResponse value) {
        return new JAXBElement<SubmitResponse>(_SubmitResponse_QNAME, SubmitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetJobGroups }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getJobGroups")
    public JAXBElement<GetJobGroups> createGetJobGroups(GetJobGroups value) {
        return new JAXBElement<GetJobGroups>(_GetJobGroups_QNAME, GetJobGroups.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMasterHostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getMasterHostResponse")
    public JAXBElement<GetMasterHostResponse> createGetMasterHostResponse(GetMasterHostResponse value) {
        return new JAXBElement<GetMasterHostResponse>(_GetMasterHostResponse_QNAME, GetMasterHostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KillJob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "killJob")
    public JAXBElement<KillJob> createKillJob(KillJob value) {
        return new JAXBElement<KillJob>(_KillJob_QNAME, KillJob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClusterName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getClusterName")
    public JAXBElement<GetClusterName> createGetClusterName(GetClusterName value) {
        return new JAXBElement<GetClusterName>(_GetClusterName_QNAME, GetClusterName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KillJobGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "killJobGroup")
    public JAXBElement<KillJobGroup> createKillJobGroup(KillJobGroup value) {
        return new JAXBElement<KillJobGroup>(_KillJobGroup_QNAME, KillJobGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResumeJob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "resumeJob")
    public JAXBElement<ResumeJob> createResumeJob(ResumeJob value) {
        return new JAXBElement<ResumeJob>(_ResumeJob_QNAME, ResumeJob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuspendJob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "suspendJob")
    public JAXBElement<SuspendJob> createSuspendJob(SuspendJob value) {
        return new JAXBElement<SuspendJob>(_SuspendJob_QNAME, SuspendJob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHosts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getHosts")
    public JAXBElement<GetHosts> createGetHosts(GetHosts value) {
        return new JAXBElement<GetHosts>(_GetHosts_QNAME, GetHosts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoFreeExecutionHost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "NoFreeExecutionHost")
    public JAXBElement<NoFreeExecutionHost> createNoFreeExecutionHost(NoFreeExecutionHost value) {
        return new JAXBElement<NoFreeExecutionHost>(_NoFreeExecutionHost_QNAME, NoFreeExecutionHost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Submit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "submit")
    public JAXBElement<Submit> createSubmit(Submit value) {
        return new JAXBElement<Submit>(_Submit_QNAME, Submit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuspendJobGroup }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "suspendJobGroup")
    public JAXBElement<SuspendJobGroup> createSuspendJobGroup(SuspendJobGroup value) {
        return new JAXBElement<SuspendJobGroup>(_SuspendJobGroup_QNAME, SuspendJobGroup.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetClusterStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getClusterStatusResponse")
    public JAXBElement<GetClusterStatusResponse> createGetClusterStatusResponse(GetClusterStatusResponse value) {
        return new JAXBElement<GetClusterStatusResponse>(_GetClusterStatusResponse_QNAME, GetClusterStatusResponse.class, null, value);
    }

}
