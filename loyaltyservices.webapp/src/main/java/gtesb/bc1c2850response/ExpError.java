
package gtesb.bc1c2850response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExpError complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExpError">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="returnCodea">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="reasonCodea">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="messageTxt">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="512"/>
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
@XmlType(name = "ExpError", propOrder = {
    "returnCodea",
    "reasonCodea",
    "messageTxt"
})
public class ExpError {

    protected int returnCodea;
    protected int reasonCodea;
    @XmlElement(required = true)
    protected String messageTxt;

    /**
     * Gets the value of the returnCodea property.
     * 
     */
    public int getReturnCodea() {
        return returnCodea;
    }

    /**
     * Sets the value of the returnCodea property.
     * 
     */
    public void setReturnCodea(int value) {
        this.returnCodea = value;
    }

    /**
     * Gets the value of the reasonCodea property.
     * 
     */
    public int getReasonCodea() {
        return reasonCodea;
    }

    /**
     * Sets the value of the reasonCodea property.
     * 
     */
    public void setReasonCodea(int value) {
        this.reasonCodea = value;
    }

    /**
     * Gets the value of the messageTxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageTxt() {
        return messageTxt;
    }

    /**
     * Sets the value of the messageTxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageTxt(String value) {
        this.messageTxt = value;
    }

}
