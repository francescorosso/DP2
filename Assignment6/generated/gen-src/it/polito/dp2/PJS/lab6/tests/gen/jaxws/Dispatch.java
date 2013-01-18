
package it.polito.dp2.PJS.lab6.tests.gen.jaxws;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *     The dispatch request carries the following items:
 *     - jobId: the id of the job to be dispatched
 *     - cmdline: the command to be run
 *     - stdin: the standard input to be passed to the job (optional)
 *     - callbackAddr: the URI where the job results have to be communicated
 *     
 * 
 * <p>Java class for dispatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dispatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jobId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="cmdline" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="stdin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="callbackAddr" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dispatch", propOrder = {
    "jobId",
    "cmdline",
    "stdin",
    "callbackAddr"
})
public class Dispatch {

    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger jobId;
    @XmlElement(required = true)
    protected String cmdline;
    protected String stdin;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String callbackAddr;

    /**
     * Gets the value of the jobId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getJobId() {
        return jobId;
    }

    /**
     * Sets the value of the jobId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setJobId(BigInteger value) {
        this.jobId = value;
    }

    /**
     * Gets the value of the cmdline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmdline() {
        return cmdline;
    }

    /**
     * Sets the value of the cmdline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmdline(String value) {
        this.cmdline = value;
    }

    /**
     * Gets the value of the stdin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStdin() {
        return stdin;
    }

    /**
     * Sets the value of the stdin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStdin(String value) {
        this.stdin = value;
    }

    /**
     * Gets the value of the callbackAddr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallbackAddr() {
        return callbackAddr;
    }

    /**
     * Sets the value of the callbackAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallbackAddr(String value) {
        this.callbackAddr = value;
    }

}
