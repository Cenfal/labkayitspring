
package com.thy.loyalty.ms.ws.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.thy.loyalty.ws.requestheader.RequestHeader;


/**
 * <p>Java class for getMemberDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMemberDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestHeader" type="{http://www.thy.com/ws/requestHeader}RequestHeader" minOccurs="0"/>
 *         &lt;element name="getMemberDetailsDetail" type="{http://w3.ws.ms.thy.com/}getMemberDetailsDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMemberDetails", propOrder = {
    "requestHeader",
    "getMemberDetailsDetail"
})
public class GetMemberDetails {

    protected RequestHeader requestHeader;
    protected GetMemberDetailsDetail getMemberDetailsDetail;

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
     * Gets the value of the getMemberDetailsDetail property.
     * 
     * @return
     *     possible object is
     *     {@link GetMemberDetailsDetail }
     *     
     */
    public GetMemberDetailsDetail getGetMemberDetailsDetail() {
        return getMemberDetailsDetail;
    }

    /**
     * Sets the value of the getMemberDetailsDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMemberDetailsDetail }
     *     
     */
    public void setGetMemberDetailsDetail(GetMemberDetailsDetail value) {
        this.getMemberDetailsDetail = value;
    }

}
