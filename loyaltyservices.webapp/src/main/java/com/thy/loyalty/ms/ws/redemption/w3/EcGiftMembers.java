
package com.thy.loyalty.ms.ws.redemption.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.thy.loyalty.ws.requestheader.RequestHeader;


/**
 * <p>Java class for EcGiftMembers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EcGiftMembers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestHeader" type="{http://www.thy.com/ws/requestHeader}RequestHeader" minOccurs="0"/>
 *         &lt;element name="ecGiftMembersDetail" type="{http://w3.redemption.ws.ms.thy.com/}ecGiftMembersDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EcGiftMembers", propOrder = {
    "requestHeader",
    "ecGiftMembersDetail"
})
public class EcGiftMembers {

    protected RequestHeader requestHeader;
    protected EcGiftMembersDetail ecGiftMembersDetail;

    /**
     * Gets the value of the requestHeader property.
     * 
     * @return
     *     possible object is
     *     {@link RequestHeader }
     *     
     */
    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    /**
     * Sets the value of the requestHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestHeader }
     *     
     */
    public void setRequestHeader(RequestHeader value) {
        this.requestHeader = value;
    }

    /**
     * Gets the value of the ecGiftMembersDetail property.
     * 
     * @return
     *     possible object is
     *     {@link EcGiftMembersDetail }
     *     
     */
    public EcGiftMembersDetail getEcGiftMembersDetail() {
        return ecGiftMembersDetail;
    }

    /**
     * Sets the value of the ecGiftMembersDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link EcGiftMembersDetail }
     *     
     */
    public void setEcGiftMembersDetail(EcGiftMembersDetail value) {
        this.ecGiftMembersDetail = value;
    }

}
