
package com.thy.loyalty.ms.ws.redemption;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.thy.loyalty.ws.requestheader.RequestHeader;


/**
 * <p>Java class for nonAirAwardReversal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nonAirAwardReversal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestHeader" type="{http://www.thy.com/ws/requestHeader}RequestHeader" minOccurs="0"/>
 *         &lt;element name="nonAirAwardReversalDetail" type="{http://redemption.ws.ms.thy.com/}nonAirAwardReversalDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nonAirAwardReversal", propOrder = {
    "requestHeader",
    "nonAirAwardReversalDetail"
})
public class NonAirAwardReversal {

    protected RequestHeader requestHeader;
    protected NonAirAwardReversalDetail nonAirAwardReversalDetail;

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
     * Gets the value of the nonAirAwardReversalDetail property.
     * 
     * @return
     *     possible object is
     *     {@link NonAirAwardReversalDetail }
     *     
     */
    public NonAirAwardReversalDetail getNonAirAwardReversalDetail() {
        return nonAirAwardReversalDetail;
    }

    /**
     * Sets the value of the nonAirAwardReversalDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonAirAwardReversalDetail }
     *     
     */
    public void setNonAirAwardReversalDetail(NonAirAwardReversalDetail value) {
        this.nonAirAwardReversalDetail = value;
    }

}
