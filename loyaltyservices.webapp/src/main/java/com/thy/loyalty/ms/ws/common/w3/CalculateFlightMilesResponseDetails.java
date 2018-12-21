
package com.thy.loyalty.ms.ws.common.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for calculateFlightMilesResponseDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="calculateFlightMilesResponseDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="baseMiles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="basePoint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cabinType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="classCodes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="definition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flightCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promoMiles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="promoPoints" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalMiles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculateFlightMilesResponseDetails", propOrder = {
    "baseMiles",
    "basePoint",
    "cabinType",
    "classCodes",
    "definition",
    "flightCount",
    "promoMiles",
    "promoPoints",
    "totalMiles"
})
public class CalculateFlightMilesResponseDetails {

    protected String baseMiles;
    protected String basePoint;
    protected String cabinType;
    protected String classCodes;
    protected String definition;
    protected String flightCount;
    protected String promoMiles;
    protected String promoPoints;
    protected String totalMiles;

    /**
     * Gets the value of the baseMiles property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseMiles() {
        return baseMiles;
    }

    /**
     * Sets the value of the baseMiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseMiles(String value) {
        this.baseMiles = value;
    }

    /**
     * Gets the value of the basePoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBasePoint() {
        return basePoint;
    }

    /**
     * Sets the value of the basePoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBasePoint(String value) {
        this.basePoint = value;
    }

    /**
     * Gets the value of the cabinType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCabinType() {
        return cabinType;
    }

    /**
     * Sets the value of the cabinType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCabinType(String value) {
        this.cabinType = value;
    }

    /**
     * Gets the value of the classCodes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassCodes() {
        return classCodes;
    }

    /**
     * Sets the value of the classCodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassCodes(String value) {
        this.classCodes = value;
    }

    /**
     * Gets the value of the definition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Sets the value of the definition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefinition(String value) {
        this.definition = value;
    }

    /**
     * Gets the value of the flightCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightCount() {
        return flightCount;
    }

    /**
     * Sets the value of the flightCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightCount(String value) {
        this.flightCount = value;
    }

    /**
     * Gets the value of the promoMiles property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoMiles() {
        return promoMiles;
    }

    /**
     * Sets the value of the promoMiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoMiles(String value) {
        this.promoMiles = value;
    }

    /**
     * Gets the value of the promoPoints property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoPoints() {
        return promoPoints;
    }

    /**
     * Sets the value of the promoPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoPoints(String value) {
        this.promoPoints = value;
    }

    /**
     * Gets the value of the totalMiles property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalMiles() {
        return totalMiles;
    }

    /**
     * Sets the value of the totalMiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalMiles(String value) {
        this.totalMiles = value;
    }

}
