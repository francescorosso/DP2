
package it.polito.dp2.PJS.sol6.client1.wsimport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMasterHostResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMasterHostResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                 &lt;/sequence>
 *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="type" use="required" type="{http://pad.polito.it/PJSInfo}HostType" />
 *                 &lt;attribute name="status" use="required" type="{http://pad.polito.it/PJSInfo}HostStatus" />
 *                 &lt;attribute name="load" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="memory" type="{http://www.w3.org/2001/XMLSchema}int" />
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
@XmlType(name = "getMasterHostResponse", propOrder = {
    "_return"
})
public class GetMasterHostResponse {

    @XmlElement(name = "return")
    protected GetMasterHostResponse.Return _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link GetMasterHostResponse.Return }
     *     
     */
    public GetMasterHostResponse.Return getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMasterHostResponse.Return }
     *     
     */
    public void setReturn(GetMasterHostResponse.Return value) {
        this._return = value;
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
     *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="type" use="required" type="{http://pad.polito.it/PJSInfo}HostType" />
     *       &lt;attribute name="status" use="required" type="{http://pad.polito.it/PJSInfo}HostStatus" />
     *       &lt;attribute name="load" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="memory" type="{http://www.w3.org/2001/XMLSchema}int" />
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

        @XmlAttribute(name = "name", required = true)
        protected String name;
        @XmlAttribute(name = "type", required = true)
        protected HostType type;
        @XmlAttribute(name = "status", required = true)
        protected HostStatus status;
        @XmlAttribute(name = "load")
        protected Integer load;
        @XmlAttribute(name = "memory")
        protected Integer memory;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link HostType }
         *     
         */
        public HostType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link HostType }
         *     
         */
        public void setType(HostType value) {
            this.type = value;
        }

        /**
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link HostStatus }
         *     
         */
        public HostStatus getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link HostStatus }
         *     
         */
        public void setStatus(HostStatus value) {
            this.status = value;
        }

        /**
         * Gets the value of the load property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getLoad() {
            return load;
        }

        /**
         * Sets the value of the load property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setLoad(Integer value) {
            this.load = value;
        }

        /**
         * Gets the value of the memory property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getMemory() {
            return memory;
        }

        /**
         * Sets the value of the memory property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setMemory(Integer value) {
            this.memory = value;
        }

    }

}
