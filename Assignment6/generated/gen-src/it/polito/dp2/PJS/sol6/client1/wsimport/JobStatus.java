
package it.polito.dp2.PJS.sol6.client1.wsimport;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for JobStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="JobStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="RUNNING"/>
 *     &lt;enumeration value="DONE"/>
 *     &lt;enumeration value="EXIT"/>
 *     &lt;enumeration value="SUSPENDED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "JobStatus", namespace = "http://pad.polito.it/PJSInfo")
@XmlEnum
public enum JobStatus {

    PENDING,
    RUNNING,
    DONE,
    EXIT,
    SUSPENDED;

    public String value() {
        return name();
    }

    public static JobStatus fromValue(String v) {
        return valueOf(v);
    }

}
