
package com.thy.loyalty.ms.ws.redemption;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.thy.loyalty.ws.requestheader.RequestHeader;


/**
 * <p>Java class for GetOrderID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetOrderID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestHeader" type="{http://www.thy.com/ws/requestHeader}RequestHeader" minOccurs="0"/>
 *         &lt;element name="getOrderIDDetail" type="{http://redemption.ws.ms.thy.com/}getOrderIDDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetOrderID", propOrder = {
    "requestHeader",
    "getOrderIDDetail"
})
public class GetOrderID {

    protected RequestHeader requestHeader;
    protected GetOrderIDDetail getOrderIDDetail;

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
     * Gets the value of the getOrderIDDetail property.
     * 
     * @return
     *     possible object is
     *     {@link GetOrderIDDetail }
     *     
     */
    public GetOrderIDDetail getGetOrderIDDetail() {
        return getOrderIDDetail;
    }

    /**
     * Sets the value of the getOrderIDDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetOrderIDDetail }
     *     
     */
    public void setGetOrderIDDetail(GetOrderIDDetail value) {
        this.getOrderIDDetail = value;
    }

}
