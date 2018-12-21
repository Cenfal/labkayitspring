
package gtesb.bc1c2850request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WsServiceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WsServiceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hdrCompanyId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="hdrPlatformType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="hdrUserId">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="hdrPassword">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="hdrToken">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="64"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="hdrDialectCd">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="logDisplayYN">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="inputFieldsQ" type="{http://gtesb/BC1C2850Request}InputFieldsQ"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WsServiceRequest", propOrder = {
    "hdrCompanyId",
    "hdrPlatformType",
    "hdrUserId",
    "hdrPassword",
    "hdrToken",
    "hdrDialectCd",
    "logDisplayYN",
    "inputFieldsQ"
})
public class WsServiceRequest {

    @XmlElement(required = true)
    protected String hdrCompanyId;
    @XmlElement(required = true)
    protected String hdrPlatformType;
    @XmlElement(required = true)
    protected String hdrUserId;
    @XmlElement(required = true)
    protected String hdrPassword;
    @XmlElement(required = true)
    protected String hdrToken;
    @XmlElement(required = true)
    protected String hdrDialectCd;
    @XmlElement(required = true)
    protected String logDisplayYN;
    @XmlElement(required = true)
    protected InputFieldsQ inputFieldsQ;

    /**
     * Gets the value of the hdrCompanyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHdrCompanyId() {
        return hdrCompanyId;
    }

    /**
     * Sets the value of the hdrCompanyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHdrCompanyId(String value) {
        this.hdrCompanyId = value;
    }

    /**
     * Gets the value of the hdrPlatformType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHdrPlatformType() {
        return hdrPlatformType;
    }

    /**
     * Sets the value of the hdrPlatformType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHdrPlatformType(String value) {
        this.hdrPlatformType = value;
    }

    /**
     * Gets the value of the hdrUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHdrUserId() {
        return hdrUserId;
    }

    /**
     * Sets the value of the hdrUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHdrUserId(String value) {
        this.hdrUserId = value;
    }

    /**
     * Gets the value of the hdrPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHdrPassword() {
        return hdrPassword;
    }

    /**
     * Sets the value of the hdrPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHdrPassword(String value) {
        this.hdrPassword = value;
    }

    /**
     * Gets the value of the hdrToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHdrToken() {
        return hdrToken;
    }

    /**
     * Sets the value of the hdrToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHdrToken(String value) {
        this.hdrToken = value;
    }

    /**
     * Gets the value of the hdrDialectCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHdrDialectCd() {
        return hdrDialectCd;
    }

    /**
     * Sets the value of the hdrDialectCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHdrDialectCd(String value) {
        this.hdrDialectCd = value;
    }

    /**
     * Gets the value of the logDisplayYN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogDisplayYN() {
        return logDisplayYN;
    }

    /**
     * Sets the value of the logDisplayYN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogDisplayYN(String value) {
        this.logDisplayYN = value;
    }

    /**
     * Gets the value of the inputFieldsQ property.
     * 
     * @return
     *     possible object is
     *     {@link InputFieldsQ }
     *     
     */
    public InputFieldsQ getInputFieldsQ() {
        return inputFieldsQ;
    }

    /**
     * Sets the value of the inputFieldsQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputFieldsQ }
     *     
     */
    public void setInputFieldsQ(InputFieldsQ value) {
        this.inputFieldsQ = value;
    }

}
