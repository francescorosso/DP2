//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.30 at 09:44:31 PM CET 
//


package it.polito.dp2.PJS.lab6.tests.gen.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for THostType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="THostType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Client"/>
 *     &lt;enumeration value="Server"/>
 *     &lt;enumeration value="Master"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "THostType")
@XmlEnum
public enum THostType {

    @XmlEnumValue("Client")
    CLIENT("Client"),
    @XmlEnumValue("Server")
    SERVER("Server"),
    @XmlEnumValue("Master")
    MASTER("Master");
    private final String value;

    THostType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static THostType fromValue(String v) {
        for (THostType c: THostType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
