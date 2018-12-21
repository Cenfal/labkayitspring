
package com.thy.loyalty.ms.ws.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for memberLoginDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="memberLoginDetails">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.ws.ms.thy.com/}checkCredentialDetails">
 *       &lt;sequence>
 *         &lt;element name="login_channel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="login_text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "memberLoginDetails", propOrder = {
    "loginChannel",
    "loginText"
})
public class MemberLoginDetails
    extends CheckCredentialDetails
{

    @XmlElement(name = "login_channel")
    protected String loginChannel;
    @XmlElement(name = "login_text")
    protected String loginText;

    /**
     * Gets the value of the loginChannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginChannel() {
        return loginChannel;
    }

    /**
     * Sets the value of the loginChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginChannel(String value) {
        this.loginChannel = value;
    }

    /**
     * Gets the value of the loginText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginText() {
        return loginText;
    }

    /**
     * Sets the value of the loginText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginText(String value) {
        this.loginText = value;
    }

}
