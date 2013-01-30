
package it.polito.dp2.PJS.sol6.client1.wsimport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for submit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="submit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="submissionHostName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cmd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sdtIn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "submit", propOrder = {
    "submissionHostName",
    "cmd",
    "sdtIn",
    "jobGroup"
})
public class Submit {

    protected String submissionHostName;
    protected String cmd;
    protected String sdtIn;
    protected String jobGroup;

    /**
     * Gets the value of the submissionHostName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmissionHostName() {
        return submissionHostName;
    }

    /**
     * Sets the value of the submissionHostName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmissionHostName(String value) {
        this.submissionHostName = value;
    }

    /**
     * Gets the value of the cmd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmd() {
        return cmd;
    }

    /**
     * Sets the value of the cmd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmd(String value) {
        this.cmd = value;
    }

    /**
     * Gets the value of the sdtIn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSdtIn() {
        return sdtIn;
    }

    /**
     * Sets the value of the sdtIn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSdtIn(String value) {
        this.sdtIn = value;
    }

    /**
     * Gets the value of the jobGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobGroup() {
        return jobGroup;
    }

    /**
     * Sets the value of the jobGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobGroup(String value) {
        this.jobGroup = value;
    }

}
