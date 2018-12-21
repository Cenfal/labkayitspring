
package gtesb.bc1c2850request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for I2850ImpQ complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="I2850ImpQ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="offerKeyCodeQ">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="13"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "I2850ImpQ", propOrder = {
    "offerKeyCodeQ"
})
public class I2850ImpQ {

    @XmlElement(required = true)
    protected String offerKeyCodeQ;

    /**
     * Gets the value of the offerKeyCodeQ property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfferKeyCodeQ() {
        return offerKeyCodeQ;
    }

    /**
     * Sets the value of the offerKeyCodeQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfferKeyCodeQ(String value) {
        this.offerKeyCodeQ = value;
    }

}
