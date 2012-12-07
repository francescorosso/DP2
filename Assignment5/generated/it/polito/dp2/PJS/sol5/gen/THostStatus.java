
package it.polito.dp2.PJS.sol5.gen;

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
