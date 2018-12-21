
package com.thy.loyalty.ms.ws.redemption.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for awardAdviserList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="awardAdviserList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="awardID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cabin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinationCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exceptEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exceptStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isGuarantee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OW_RT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promotionDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "awardAdviserList", propOrder = {
    "awardID",
    "cabin",
    "destinationCity",
    "endDate",
    "exceptEndDate",
    "exceptStartDate",
    "isGuarantee",
    "mile",
    "owrt",
    "promotionDesc",
    "startDate"
})
public class AwardAdviserList {

    protected String awardID;
    protected String cabin;
    protected String destinationCity;
    protected String endDate;
    protected String exceptEndDate;
    protected String exceptStartDate;
    protected String isGuarantee;
    protected String mile;
    @XmlElement(name = "OW_RT")
    protected String owrt;
    protected String promotionDesc;
    protected String startDate;

    /**
     * Gets the value of the awardID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwardID() {
        return awardID;
    }

    /**
     * Sets the value of the awardID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwardID(String value) {
        this.awardID = value;
    }

    /**
     * Gets the value of the cabin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCabin() {
        return cabin;
    }

    /**
     * Sets the value of the cabin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCabin(String value) {
        this.cabin = value;
    }

    /**
     * Gets the value of the destinationCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationCity() {
        return destinationCity;
    }

    /**
     * Sets the value of the destinationCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationCity(String value) {
        this.destinationCity = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the exceptEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptEndDate() {
        return exceptEndDate;
    }

    /**
     * Sets the value of the exceptEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptEndDate(String value) {
        this.exceptEndDate = value;
    }

    /**
     * Gets the value of the exceptStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExceptStartDate() {
        return exceptStartDate;
    }

    /**
     * Sets the value of the exceptStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExceptStartDate(String value) {
        this.exceptStartDate = value;
    }

    /**
     * Gets the value of the isGuarantee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsGuarantee() {
        return isGuarantee;
    }

    /**
     * Sets the value of the isGuarantee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsGuarantee(String value) {
        this.isGuarantee = value;
    }

    /**
     * Gets the value of the mile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMile() {
        return mile;
    }

    /**
     * Sets the value of the mile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMile(String value) {
        this.mile = value;
    }

    /**
     * Gets the value of the owrt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOWRT() {
        return owrt;
    }

    /**
     * Sets the value of the owrt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOWRT(String value) {
        this.owrt = value;
    }

    /**
     * Gets the value of the promotionDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromotionDesc() {
        return promotionDesc;
    }

    /**
     * Sets the value of the promotionDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromotionDesc(String value) {
        this.promotionDesc = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

}
