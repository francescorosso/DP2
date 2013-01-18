
package it.polito.dp2.PJS.lab6.tests.gen.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.polito.dp2.PJS.lab6.tests.gen.jaxws package. 
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

    private final static QName _KillResponse_QNAME = new QName("http://pad.polito.it/PJS", "killResponse");
    private final static QName _DispatchResponse_QNAME = new QName("http://pad.polito.it/PJS", "dispatchResponse");
    private final static QName _Suspend_QNAME = new QName("http://pad.polito.it/PJS", "suspend");
    private final static QName _SuspendResponse_QNAME = new QName("http://pad.polito.it/PJS", "suspendResponse");
    private final static QName _Resume_QNAME = new QName("http://pad.polito.it/PJS", "resume");
    private final static QName _ServiceUnavailable_QNAME = new QName("http://pad.polito.it/PJS", "ServiceUnavailable");
    private final static QName _ResumeResponse_QNAME = new QName("http://pad.polito.it/PJS", "resumeResponse");
    private final static QName _TooManyJobs_QNAME = new QName("http://pad.polito.it/PJS", "TooManyJobs");
    private final static QName _AlreadyDispatchedJob_QNAME = new QName("http://pad.polito.it/PJS", "AlreadyDispatchedJob");
    private final static QName _Kill_QNAME = new QName("http://pad.polito.it/PJS", "kill");
    private final static QName _Dispatch_QNAME = new QName("http://pad.polito.it/PJS", "dispatch");
    private final static QName _UnknownJob_QNAME = new QName("http://pad.polito.it/PJS", "UnknownJob");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polito.dp2.PJS.lab6.tests.gen.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Suspend }
     * 
     */
    public Suspend createSuspend() {
        return new Suspend();
    }

    /**
     * Create an instance of {@link DispatchResponse }
     * 
     */
    public DispatchResponse createDispatchResponse() {
        return new DispatchResponse();
    }

    /**
     * Create an instance of {@link SuspendResponse }
     * 
     */
    public SuspendResponse createSuspendResponse() {
        return new SuspendResponse();
    }

    /**
     * Create an instance of {@link ServiceUnavailable }
     * 
     */
    public ServiceUnavailable createServiceUnavailable() {
        return new ServiceUnavailable();
    }

    /**
     * Create an instance of {@link Resume }
     * 
     */
    public Resume createResume() {
        return new Resume();
    }

    /**
     * Create an instance of {@link KillResponse }
     * 
     */
    public KillResponse createKillResponse() {
        return new KillResponse();
    }

    /**
     * Create an instance of {@link AlreadyDispatchedJob }
     * 
     */
    public AlreadyDispatchedJob createAlreadyDispatchedJob() {
        return new AlreadyDispatchedJob();
    }

    /**
     * Create an instance of {@link Kill }
     * 
     */
    public Kill createKill() {
        return new Kill();
    }

    /**
     * Create an instance of {@link UnknownJob }
     * 
     */
    public UnknownJob createUnknownJob() {
        return new UnknownJob();
    }

    /**
     * Create an instance of {@link Dispatch }
     * 
     */
    public Dispatch createDispatch() {
        return new Dispatch();
    }

    /**
     * Create an instance of {@link ResumeResponse }
     * 
     */
    public ResumeResponse createResumeResponse() {
        return new ResumeResponse();
    }

    /**
     * Create an instance of {@link TooManyJobs }
     * 
     */
    public TooManyJobs createTooManyJobs() {
        return new TooManyJobs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KillResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pad.polito.it/PJS", name = "killResponse")
    public JAXBElement<KillResponse> createKillResponse(KillResponse value) {
        return new JAXBElement<KillResponse>(_KillResponse_QNAME, KillResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DispatchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pad.polito.it/PJS", name = "dispatchResponse")
    public JAXBElement<DispatchResponse> createDispatchResponse(DispatchResponse value) {
        return new JAXBElement<DispatchResponse>(_DispatchResponse_QNAME, DispatchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Suspend }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pad.polito.it/PJS", name = "suspend")
    public JAXBElement<Suspend> createSuspend(Suspend value) {
        return new JAXBElement<Suspend>(_Suspend_QNAME, Suspend.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SuspendResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pad.polito.it/PJS", name = "suspendResponse")
    public JAXBElement<SuspendResponse> createSuspendResponse(SuspendResponse value) {
        return new JAXBElement<SuspendResponse>(_SuspendResponse_QNAME, SuspendResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Resume }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pad.polito.it/PJS", name = "resume")
    public JAXBElement<Resume> createResume(Resume value) {
        return new JAXBElement<Resume>(_Resume_QNAME, Resume.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceUnavailable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pad.polito.it/PJS", name = "ServiceUnavailable")
    public JAXBElement<ServiceUnavailable> createServiceUnavailable(ServiceUnavailable value) {
        return new JAXBElement<ServiceUnavailable>(_ServiceUnavailable_QNAME, ServiceUnavailable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResumeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pad.polito.it/PJS", name = "resumeResponse")
    public JAXBElement<ResumeResponse> createResumeResponse(ResumeResponse value) {
        return new JAXBElement<ResumeResponse>(_ResumeResponse_QNAME, ResumeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TooManyJobs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pad.polito.it/PJS", name = "TooManyJobs")
    public JAXBElement<TooManyJobs> createTooManyJobs(TooManyJobs value) {
        return new JAXBElement<TooManyJobs>(_TooManyJobs_QNAME, TooManyJobs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AlreadyDispatchedJob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pad.polito.it/PJS", name = "AlreadyDispatchedJob")
    public JAXBElement<AlreadyDispatchedJob> createAlreadyDispatchedJob(AlreadyDispatchedJob value) {
        return new JAXBElement<AlreadyDispatchedJob>(_AlreadyDispatchedJob_QNAME, AlreadyDispatchedJob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Kill }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pad.polito.it/PJS", name = "kill")
    public JAXBElement<Kill> createKill(Kill value) {
        return new JAXBElement<Kill>(_Kill_QNAME, Kill.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Dispatch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pad.polito.it/PJS", name = "dispatch")
    public JAXBElement<Dispatch> createDispatch(Dispatch value) {
        return new JAXBElement<Dispatch>(_Dispatch_QNAME, Dispatch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnknownJob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pad.polito.it/PJS", name = "UnknownJob")
    public JAXBElement<UnknownJob> createUnknownJob(UnknownJob value) {
        return new JAXBElement<UnknownJob>(_UnknownJob_QNAME, UnknownJob.class, null, value);
    }

}
