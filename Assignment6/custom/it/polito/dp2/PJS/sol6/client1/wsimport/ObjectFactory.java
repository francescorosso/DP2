
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

    private final static QName _GetHosts_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getHosts");
    private final static QName _NoFreeExecutionHost_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "NoFreeExecutionHost");
    private final static QName _GetHostNamesResponse_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getHostNamesResponse");
    private final static QName _Submit_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "submit");
    private final static QName _GetHostNames_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getHostNames");
    private final static QName _GetHostsResponse_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "getHostsResponse");
    private final static QName _SubmitResponse_QNAME = new QName("http://service.sol6.PJS.dp2.polito.it/", "submitResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.polito.dp2.PJS.sol6.client1.wsimport
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHostsResponse }
     * 
     */
    public GetHostsResponse createGetHostsResponse() {
        return new GetHostsResponse();
    }

    /**
     * Create an instance of {@link GetHostsResponse.Return }
     * 
     */
    public GetHostsResponse.Return createGetHostsResponseReturn() {
        return new GetHostsResponse.Return();
    }

    /**
     * Create an instance of {@link Submit }
     * 
     */
    public Submit createSubmit() {
        return new Submit();
    }

    /**
     * Create an instance of {@link GetHostNamesResponse }
     * 
     */
    public GetHostNamesResponse createGetHostNamesResponse() {
        return new GetHostNamesResponse();
    }

    /**
     * Create an instance of {@link NoFreeExecutionHost }
     * 
     */
    public NoFreeExecutionHost createNoFreeExecutionHost() {
        return new NoFreeExecutionHost();
    }

    /**
     * Create an instance of {@link GetHosts }
     * 
     */
    public GetHosts createGetHosts() {
        return new GetHosts();
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
     * Create an instance of {@link GetHostsResponse.Return.Host }
     * 
     */
    public GetHostsResponse.Return.Host createGetHostsResponseReturnHost() {
        return new GetHostsResponse.Return.Host();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHostNamesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.sol6.PJS.dp2.polito.it/", name = "getHostNamesResponse")
    public JAXBElement<GetHostNamesResponse> createGetHostNamesResponse(GetHostNamesResponse value) {
        return new JAXBElement<GetHostNamesResponse>(_GetHostNamesResponse_QNAME, GetHostNamesResponse.class, null, value);
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

}
