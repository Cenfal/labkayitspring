
package com.thy.loyalty.ms.ws.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.thy.loyalty.ws.requestheader.RequestHeader;


/**
 * <p>Java class for getMultiMemberDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMultiMemberDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestHeader" type="{http://www.thy.com/ws/requestHeader}RequestHeader" minOccurs="0"/>
 *         &lt;element name="getMultiMemberDetailsDetail" type="{http://w3.ws.ms.thy.com/}getMultiMemberDetailsDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMultiMemberDetails", propOrder = {
    "requestHeader",
    "getMultiMemberDetailsDetail"
})
public class GetMultiMemberDetails {

    protected RequestHeader requestHeader;
    protected GetMultiMemberDetailsDetail getMultiMemberDetailsDetail;

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
     * Gets the value of the getMultiMemberDetailsDetail property.
     * 
     * @return
     *     possible object is
     *     {@link GetMultiMemberDetailsDetail }
     *     
     */
    public GetMultiMemberDetailsDetail getGetMultiMemberDetailsDetail() {
        return getMultiMemberDetailsDetail;
    }

    /**
     * Sets the value of the getMultiMemberDetailsDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMultiMemberDetailsDetail }
     *     
     */
    public void setGetMultiMemberDetailsDetail(GetMultiMemberDetailsDetail value) {
        this.getMultiMemberDetailsDetail = value;
    }

}
