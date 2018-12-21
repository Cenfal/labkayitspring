
package com.thy.loyalty.ms.ws.redemption.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flightAwardCalculateResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flightAwardCalculateResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.redemption.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="p_app_stat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_award_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_awd_message_de" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_awd_message_en" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_awd_message_tr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_class_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_company_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_d_s_count" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_found_first" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_is_voucher" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_last_minute_upgrade" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="p_m_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_m_sname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="p_red_miles_1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="p_red_miles_2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="p_red_miles_3" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="p_red_miles_4" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="p_red_miles_5" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flightAwardCalculateResult", propOrder = {
    "pAppStat",
    "pAwardType",
    "pAwdMessageDe",
    "pAwdMessageEn",
    "pAwdMessageTr",
    "pClassCode",
    "pCompanyCode",
    "pdsCount",
    "pFoundFirst",
    "pId",
    "pIsVoucher",
    "pLastMinuteUpgrade",
    "pmName",
    "pmSname",
    "pRedMiles1",
    "pRedMiles2",
    "pRedMiles3",
    "pRedMiles4",
    "pRedMiles5"
})
public class FlightAwardCalculateResult
    extends MethodResult
{

    @XmlElement(name = "p_app_stat")
    protected String pAppStat;
    @XmlElement(name = "p_award_type")
    protected String pAwardType;
    @XmlElement(name = "p_awd_message_de")
    protected String pAwdMessageDe;
    @XmlElement(name = "p_awd_message_en")
    protected String pAwdMessageEn;
    @XmlElement(name = "p_awd_message_tr")
    protected String pAwdMessageTr;
    @XmlElement(name = "p_class_code")
    protected String pClassCode;
    @XmlElement(name = "p_company_code")
    protected String pCompanyCode;
    @XmlElement(name = "p_d_s_count")
    protected String pdsCount;
    @XmlElement(name = "p_found_first")
    protected String pFoundFirst;
    @XmlElement(name = "p_id")
    protected String pId;
    @XmlElement(name = "p_is_voucher")
    protected String pIsVoucher;
    @XmlElement(name = "p_last_minute_upgrade")
    protected int pLastMinuteUpgrade;
    @XmlElement(name = "p_m_name")
    protected String pmName;
    @XmlElement(name = "p_m_sname")
    protected String pmSname;
    @XmlElement(name = "p_red_miles_1")
    protected double pRedMiles1;
    @XmlElement(name = "p_red_miles_2")
    protected double pRedMiles2;
    @XmlElement(name = "p_red_miles_3")
    protected double pRedMiles3;
    @XmlElement(name = "p_red_miles_4")
    protected double pRedMiles4;
    @XmlElement(name = "p_red_miles_5")
    protected double pRedMiles5;

    /**
     * Gets the value of the pAppStat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAppStat() {
        return pAppStat;
    }

    /**
     * Sets the value of the pAppStat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAppStat(String value) {
        this.pAppStat = value;
    }

    /**
     * Gets the value of the pAwardType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAwardType() {
        return pAwardType;
    }

    /**
     * Sets the value of the pAwardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAwardType(String value) {
        this.pAwardType = value;
    }

    /**
     * Gets the value of the pAwdMessageDe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAwdMessageDe() {
        return pAwdMessageDe;
    }

    /**
     * Sets the value of the pAwdMessageDe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAwdMessageDe(String value) {
        this.pAwdMessageDe = value;
    }

    /**
     * Gets the value of the pAwdMessageEn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAwdMessageEn() {
        return pAwdMessageEn;
    }

    /**
     * Sets the value of the pAwdMessageEn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAwdMessageEn(String value) {
        this.pAwdMessageEn = value;
    }

    /**
     * Gets the value of the pAwdMessageTr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAwdMessageTr() {
        return pAwdMessageTr;
    }

    /**
     * Sets the value of the pAwdMessageTr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAwdMessageTr(String value) {
        this.pAwdMessageTr = value;
    }

    /**
     * Gets the value of the pClassCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPClassCode() {
        return pClassCode;
    }

    /**
     * Sets the value of the pClassCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPClassCode(String value) {
        this.pClassCode = value;
    }

    /**
     * Gets the value of the pCompanyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPCompanyCode() {
        return pCompanyCode;
    }

    /**
     * Sets the value of the pCompanyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPCompanyCode(String value) {
        this.pCompanyCode = value;
    }

    /**
     * Gets the value of the pdsCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDSCount() {
        return pdsCount;
    }

    /**
     * Sets the value of the pdsCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDSCount(String value) {
        this.pdsCount = value;
    }

    /**
     * Gets the value of the pFoundFirst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPFoundFirst() {
        return pFoundFirst;
    }

    /**
     * Sets the value of the pFoundFirst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPFoundFirst(String value) {
        this.pFoundFirst = value;
    }

    /**
     * Gets the value of the pId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPId() {
        return pId;
    }

    /**
     * Sets the value of the pId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPId(String value) {
        this.pId = value;
    }

    /**
     * Gets the value of the pIsVoucher property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPIsVoucher() {
        return pIsVoucher;
    }

    /**
     * Sets the value of the pIsVoucher property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPIsVoucher(String value) {
        this.pIsVoucher = value;
    }

    /**
     * Gets the value of the pLastMinuteUpgrade property.
     * 
     */
    public int getPLastMinuteUpgrade() {
        return pLastMinuteUpgrade;
    }

    /**
     * Sets the value of the pLastMinuteUpgrade property.
     * 
     */
    public void setPLastMinuteUpgrade(int value) {
        this.pLastMinuteUpgrade = value;
    }

    /**
     * Gets the value of the pmName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPMName() {
        return pmName;
    }

    /**
     * Sets the value of the pmName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPMName(String value) {
        this.pmName = value;
    }

    /**
     * Gets the value of the pmSname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPMSname() {
        return pmSname;
    }

    /**
     * Sets the value of the pmSname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPMSname(String value) {
        this.pmSname = value;
    }

    /**
     * Gets the value of the pRedMiles1 property.
     * 
     */
    public double getPRedMiles1() {
        return pRedMiles1;
    }

    /**
     * Sets the value of the pRedMiles1 property.
     * 
     */
    public void setPRedMiles1(double value) {
        this.pRedMiles1 = value;
    }

    /**
     * Gets the value of the pRedMiles2 property.
     * 
     */
    public double getPRedMiles2() {
        return pRedMiles2;
    }

    /**
     * Sets the value of the pRedMiles2 property.
     * 
     */
    public void setPRedMiles2(double value) {
        this.pRedMiles2 = value;
    }

    /**
     * Gets the value of the pRedMiles3 property.
     * 
     */
    public double getPRedMiles3() {
        return pRedMiles3;
    }

    /**
     * Sets the value of the pRedMiles3 property.
     * 
     */
    public void setPRedMiles3(double value) {
        this.pRedMiles3 = value;
    }

    /**
     * Gets the value of the pRedMiles4 property.
     * 
     */
    public double getPRedMiles4() {
        return pRedMiles4;
    }

    /**
     * Sets the value of the pRedMiles4 property.
     * 
     */
    public void setPRedMiles4(double value) {
        this.pRedMiles4 = value;
    }

    /**
     * Gets the value of the pRedMiles5 property.
     * 
     */
    public double getPRedMiles5() {
        return pRedMiles5;
    }

    /**
     * Sets the value of the pRedMiles5 property.
     * 
     */
    public void setPRedMiles5(double value) {
        this.pRedMiles5 = value;
    }

}
