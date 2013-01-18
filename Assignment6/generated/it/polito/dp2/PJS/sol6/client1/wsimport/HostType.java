
package it.polito.dp2.PJS.sol6.client1.wsimport;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MASTER"/>
 *     &lt;enumeration value="SERVER"/>
 *     &lt;enumeration value="CLIENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostType", namespace = "http://pad.polito.it/PJSInfo")
@XmlEnum
public enum HostType {

    MASTER,
    SERVER,
    CLIENT;

    public String value() {
        return name();
    }

    public static HostType fromValue(String v) {
        return valueOf(v);
    }

}
