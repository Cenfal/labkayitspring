
package com.thy.loyalty.ms.ws.redemption;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getOrderIDResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getOrderIDResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://redemption.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="memberVerifyOtpOnce" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getOrderIDResult", propOrder = {
    "memberVerifyOtpOnce",
    "orderID"
})
public class GetOrderIDResult
    extends MethodResult
{

    protected String memberVerifyOtpOnce;
    protected String orderID;

    /**
     * Gets the value of the memberVerifyOtpOnce property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberVerifyOtpOnce() {
        return memberVerifyOtpOnce;
    }

    /**
     * Sets the value of the memberVerifyOtpOnce property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberVerifyOtpOnce(String value) {
        this.memberVerifyOtpOnce = value;
    }

    /**
     * Gets the value of the orderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * Sets the value of the orderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderID(String value) {
        this.orderID = value;
    }

}
