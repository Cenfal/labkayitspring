
package gtesb.bc1c2850response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for E2850ExpErrorWsQ complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="E2850ExpErrorWsQ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorCodeQ">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="errorTextQ">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
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
@XmlType(name = "E2850ExpErrorWsQ", propOrder = {
    "errorCodeQ",
    "errorTextQ"
})
public class E2850ExpErrorWsQ {

    protected int errorCodeQ;
    @XmlElement(required = true)
    protected String errorTextQ;

    /**
     * Gets the value of the errorCodeQ property.
     * 
     */
    public int getErrorCodeQ() {
        return errorCodeQ;
    }

    /**
     * Sets the value of the errorCodeQ property.
     * 
     */
    public void setErrorCodeQ(int value) {
        this.errorCodeQ = value;
    }

    /**
     * Gets the value of the errorTextQ property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorTextQ() {
        return errorTextQ;
    }

    /**
     * Sets the value of the errorTextQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorTextQ(String value) {
        this.errorTextQ = value;
    }

}
