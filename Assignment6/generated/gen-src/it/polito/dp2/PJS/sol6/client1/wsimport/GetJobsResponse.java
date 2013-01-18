
package it.polito.dp2.PJS.sol6.client1.wsimport;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getJobsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getJobsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="jobID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="state" use="required" type="{http://pad.polito.it/PJSInfo}JobStatus" />
 *                 &lt;attribute name="submissionHost" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="submissionTime" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *                 &lt;attribute name="jobGroup" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="executionHost" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getJobsResponse", propOrder = {
    "_return"
})
public class GetJobsResponse {

    @XmlElement(name = "return", nillable = true)
    protected List<GetJobsResponse.Return> _return;

    /**
     * Gets the value of the return property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the return property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetJobsResponse.Return }
     * 
     * 
     */
    public List<GetJobsResponse.Return> getReturn() {
        if (_return == null) {
            _return = new ArrayList<GetJobsResponse.Return>();
        }
        return this._return;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *       &lt;/sequence>
     *       &lt;attribute name="jobID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="state" use="required" type="{http://pad.polito.it/PJSInfo}JobStatus" />
     *       &lt;attribute name="submissionHost" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="submissionTime" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
     *       &lt;attribute name="jobGroup" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="executionHost" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Return {

        @XmlAttribute(name = "jobID", required = true)
        protected String jobID;
        @XmlAttribute(name = "state", required = true)
        protected JobStatus state;
        @XmlAttribute(name = "submissionHost", required = true)
        protected String submissionHost;
        @XmlAttribute(name = "submissionTime", required = true)
        protected long submissionTime;
        @XmlAttribute(name = "jobGroup")
        protected String jobGroup;
        @XmlAttribute(name = "executionHost")
        protected String executionHost;

        /**
         * Gets the value of the jobID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJobID() {
            return jobID;
        }

        /**
         * Sets the value of the jobID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJobID(String value) {
            this.jobID = value;
        }

        /**
         * Gets the value of the state property.
         * 
         * @return
         *     possible object is
         *     {@link JobStatus }
         *     
         */
        public JobStatus getState() {
            return state;
        }

        /**
         * Sets the value of the state property.
         * 
         * @param value
         *     allowed object is
         *     {@link JobStatus }
         *     
         */
        public void setState(JobStatus value) {
            this.state = value;
        }

        /**
         * Gets the value of the submissionHost property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSubmissionHost() {
            return submissionHost;
        }

        /**
         * Sets the value of the submissionHost property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSubmissionHost(String value) {
            this.submissionHost = value;
        }

        /**
         * Gets the value of the submissionTime property.
         * 
         */
        public long getSubmissionTime() {
            return submissionTime;
        }

        /**
         * Sets the value of the submissionTime property.
         * 
         */
        public void setSubmissionTime(long value) {
            this.submissionTime = value;
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

        /**
         * Gets the value of the executionHost property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExecutionHost() {
            return executionHost;
        }

        /**
         * Sets the value of the executionHost property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExecutionHost(String value) {
            this.executionHost = value;
        }

    }

}
