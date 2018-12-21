
package com.thy.loyalty.ms.ws.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkPinSecurityForNewMemberDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkPinSecurityForNewMemberDetails">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.ws.ms.thy.com/}checkCredentialDetails">
 *       &lt;sequence>
 *         &lt;element name="birth_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkPinSecurityForNewMemberDetails", propOrder = {
    "birthDate"
})
public class CheckPinSecurityForNewMemberDetails
    extends CheckCredentialDetails
{

    @XmlElement(name = "birth_date")
    protected String birthDate;

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDate(String value) {
        this.birthDate = value;
    }

}
