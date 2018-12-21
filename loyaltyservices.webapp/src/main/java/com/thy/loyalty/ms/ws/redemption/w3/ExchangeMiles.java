
package com.thy.loyalty.ms.ws.redemption.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.thy.loyalty.ws.requestheader.RequestHeader;


/**
 * <p>Java class for exchangeMiles complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="exchangeMiles">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestHeader" type="{http://www.thy.com/ws/requestHeader}RequestHeader" minOccurs="0"/>
 *         &lt;element name="exchangeMileDetail" type="{http://w3.redemption.ws.ms.thy.com/}exchangeMileDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exchangeMiles", propOrder = {
    "requestHeader",
    "exchangeMileDetail"
})
public class ExchangeMiles {

    protected RequestHeader requestHeader;
    protected ExchangeMileDetail exchangeMileDetail;

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
     * Gets the value of the exchangeMileDetail property.
     * 
     * @return
     *     possible object is
     *     {@link ExchangeMileDetail }
     *     
     */
    public ExchangeMileDetail getExchangeMileDetail() {
        return exchangeMileDetail;
    }

    /**
     * Sets the value of the exchangeMileDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeMileDetail }
     *     
     */
    public void setExchangeMileDetail(ExchangeMileDetail value) {
        this.exchangeMileDetail = value;
    }

}
