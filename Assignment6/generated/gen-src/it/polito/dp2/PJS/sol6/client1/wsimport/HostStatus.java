
package it.polito.dp2.PJS.sol6.client1.wsimport;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="UNAVAIL"/>
 *     &lt;enumeration value="CLOSED"/>
 *     &lt;enumeration value="UNLICENSED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostStatus", namespace = "http://pad.polito.it/PJSInfo")
@XmlEnum
public enum HostStatus {

    OK,
    UNAVAIL,
    CLOSED,
    UNLICENSED;

    public String value() {
        return name();
    }

    public static HostStatus fromValue(String v) {
        return valueOf(v);
    }

}
