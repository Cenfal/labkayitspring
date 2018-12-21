
package com.thy.loyalty.ms.ws.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for maxPinLengthResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="maxPinLengthResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="maxPinLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pinRules" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "maxPinLengthResult", propOrder = {
    "maxPinLength",
    "pinRules"
})
public class MaxPinLengthResult
    extends MethodResult
{

    protected int maxPinLength;
    protected String pinRules;

    /**
     * Gets the value of the maxPinLength property.
     * 
     */
    public int getMaxPinLength() {
        return maxPinLength;
    }

    /**
     * Sets the value of the maxPinLength property.
     * 
     */
    public void setMaxPinLength(int value) {
        this.maxPinLength = value;
    }

    /**
     * Gets the value of the pinRules property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPinRules() {
        return pinRules;
    }

    /**
     * Sets the value of the pinRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPinRules(String value) {
        this.pinRules = value;
    }

}
