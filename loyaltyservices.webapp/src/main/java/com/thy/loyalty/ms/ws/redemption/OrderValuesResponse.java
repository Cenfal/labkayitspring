
package com.thy.loyalty.ms.ws.redemption;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.thy.loyalty.ws.responseheader.ResponseHeader;


/**
 * <p>Java class for OrderValuesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderValuesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responseHeader" type="{http://www.thy.com/ws/responseHeader}ResponseHeader" minOccurs="0"/>
 *         &lt;element name="return" type="{http://redemption.ws.ms.thy.com/}orderValuesResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderValuesResponse", propOrder = {
    "responseHeader",
    "_return"
})
public class OrderValuesResponse {

    protected ResponseHeader responseHeader;
    @XmlElement(name = "return")
    protected OrderValuesResult _return;

    /**
     * Gets the value of the responseHeader property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseHeader }
     *     
     */
    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    /**
     * Sets the value of the responseHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseHeader }
     *     
     */
    public void setResponseHeader(ResponseHeader value) {
        this.responseHeader = value;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link OrderValuesResult }
     *     
     */
    public OrderValuesResult getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderValuesResult }
     *     
     */
    public void setReturn(OrderValuesResult value) {
        this._return = value;
    }

}
