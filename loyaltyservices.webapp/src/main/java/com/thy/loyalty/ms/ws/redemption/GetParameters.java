
package com.thy.loyalty.ms.ws.redemption;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.thy.loyalty.ws.requestheader.RequestHeader;


/**
 * <p>Java class for GetParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestHeader" type="{http://www.thy.com/ws/requestHeader}RequestHeader" minOccurs="0"/>
 *         &lt;element name="getParametersDetail" type="{http://redemption.ws.ms.thy.com/}getParametersDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetParameters", propOrder = {
    "requestHeader",
    "getParametersDetail"
})
public class GetParameters {

    protected RequestHeader requestHeader;
    protected GetParametersDetail getParametersDetail;

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
     * Gets the value of the getParametersDetail property.
     * 
     * @return
     *     possible object is
     *     {@link GetParametersDetail }
     *     
     */
    public GetParametersDetail getGetParametersDetail() {
        return getParametersDetail;
    }

    /**
     * Sets the value of the getParametersDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetParametersDetail }
     *     
     */
    public void setGetParametersDetail(GetParametersDetail value) {
        this.getParametersDetail = value;
    }

}
