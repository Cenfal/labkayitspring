
package com.thy.loyalty.ms.ws.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for memberLoginW3Result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="memberLoginW3Result">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="forceMemberChangePin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isLoginPossible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loggedMemberId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "memberLoginW3Result", propOrder = {
    "forceMemberChangePin",
    "isLoginPossible",
    "loggedMemberId",
    "userRole"
})
public class MemberLoginW3Result
    extends MethodResult
{

    protected String forceMemberChangePin;
    protected String isLoginPossible;
    protected String loggedMemberId;
    protected String userRole;

    /**
     * Gets the value of the forceMemberChangePin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForceMemberChangePin() {
        return forceMemberChangePin;
    }

    /**
     * Sets the value of the forceMemberChangePin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForceMemberChangePin(String value) {
        this.forceMemberChangePin = value;
    }

    /**
     * Gets the value of the isLoginPossible property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsLoginPossible() {
        return isLoginPossible;
    }

    /**
     * Sets the value of the isLoginPossible property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsLoginPossible(String value) {
        this.isLoginPossible = value;
    }

    /**
     * Gets the value of the loggedMemberId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoggedMemberId() {
        return loggedMemberId;
    }

    /**
     * Sets the value of the loggedMemberId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoggedMemberId(String value) {
        this.loggedMemberId = value;
    }

    /**
     * Gets the value of the userRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * Sets the value of the userRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserRole(String value) {
        this.userRole = value;
    }

}
