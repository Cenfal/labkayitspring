
package com.thy.loyalty.ms.ws.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMultiMemberDetailsResultRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMultiMemberDetailsResultRecord">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.ws.ms.thy.com/}getMemberDetailsResult">
 *       &lt;sequence>
 *         &lt;element name="flyerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMultiMemberDetailsResultRecord", propOrder = {
    "flyerId"
})
public class GetMultiMemberDetailsResultRecord
    extends GetMemberDetailsResult
{

    protected String flyerId;

    /**
     * Gets the value of the flyerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlyerId() {
        return flyerId;
    }

    /**
     * Sets the value of the flyerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlyerId(String value) {
        this.flyerId = value;
    }

}
