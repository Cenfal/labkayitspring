
package com.thy.loyalty.ms.ws.redemption.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.thy.loyalty.ws.requestheader.RequestHeader;


/**
 * <p>Java class for MileageDonationCharityList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MileageDonationCharityList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestHeader" type="{http://www.thy.com/ws/requestHeader}RequestHeader" minOccurs="0"/>
 *         &lt;element name="mileageDonationCharityListDetail" type="{http://w3.redemption.ws.ms.thy.com/}mileageDonationCharityListDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MileageDonationCharityList", propOrder = {
    "requestHeader",
    "mileageDonationCharityListDetail"
})
public class MileageDonationCharityList {

    protected RequestHeader requestHeader;
    protected MileageDonationCharityListDetail mileageDonationCharityListDetail;

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
     * Gets the value of the mileageDonationCharityListDetail property.
     * 
     * @return
     *     possible object is
     *     {@link MileageDonationCharityListDetail }
     *     
     */
    public MileageDonationCharityListDetail getMileageDonationCharityListDetail() {
        return mileageDonationCharityListDetail;
    }

    /**
     * Sets the value of the mileageDonationCharityListDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link MileageDonationCharityListDetail }
     *     
     */
    public void setMileageDonationCharityListDetail(MileageDonationCharityListDetail value) {
        this.mileageDonationCharityListDetail = value;
    }

}
