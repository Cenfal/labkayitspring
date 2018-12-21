
package com.thy.loyalty.ms.ws.common.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.thy.loyalty.ws.requestheader.RequestHeader;


/**
 * <p>Java class for calculateFlightMiles complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="calculateFlightMiles">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestHeader" type="{http://www.thy.com/ws/requestHeader}RequestHeader" minOccurs="0"/>
 *         &lt;element name="calculateFlightMilesDetail" type="{http://w3.common.ws.ms.thy.com/}calculateFlightMilesDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculateFlightMiles", propOrder = {
    "requestHeader",
    "calculateFlightMilesDetail"
})
public class CalculateFlightMiles {

    protected RequestHeader requestHeader;
    protected CalculateFlightMilesDetail calculateFlightMilesDetail;

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
     * Gets the value of the calculateFlightMilesDetail property.
     * 
     * @return
     *     possible object is
     *     {@link CalculateFlightMilesDetail }
     *     
     */
    public CalculateFlightMilesDetail getCalculateFlightMilesDetail() {
        return calculateFlightMilesDetail;
    }

    /**
     * Sets the value of the calculateFlightMilesDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link CalculateFlightMilesDetail }
     *     
     */
    public void setCalculateFlightMilesDetail(CalculateFlightMilesDetail value) {
        this.calculateFlightMilesDetail = value;
    }

}
