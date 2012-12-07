
package it.polito.dp2.PJS.sol5.gen;

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
