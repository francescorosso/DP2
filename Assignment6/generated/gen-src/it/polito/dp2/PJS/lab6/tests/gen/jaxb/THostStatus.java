//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.29 at 12:38:03 PM CET 
//


package it.polito.dp2.PJS.lab6.tests.gen.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for THostStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="THostStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="Unavail"/>
 *     &lt;enumeration value="Closed"/>
 *     &lt;enumeration value="Unlicensed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "THostStatus")
@XmlEnum
public enum THostStatus {

    OK("OK"),
    @XmlEnumValue("Unavail")
    UNAVAIL("Unavail"),
    @XmlEnumValue("Closed")
    CLOSED("Closed"),
    @XmlEnumValue("Unlicensed")
    UNLICENSED("Unlicensed");
    private final String value;

    THostStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static THostStatus fromValue(String v) {
        for (THostStatus c: THostStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}