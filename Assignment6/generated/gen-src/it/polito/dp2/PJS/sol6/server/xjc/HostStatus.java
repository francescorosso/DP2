//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.18 at 10:49:42 AM CET 
//


package it.polito.dp2.PJS.sol6.server.xjc;

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
@XmlType(name = "HostStatus")
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
