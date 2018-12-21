
package gtesb.bc1c2850request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InputFieldsQ complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InputFieldsQ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="i2850ImpQ" type="{http://gtesb/BC1C2850Request}I2850ImpQ"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputFieldsQ", propOrder = {
    "i2850ImpQ"
})
public class InputFieldsQ {

    @XmlElement(required = true)
    protected I2850ImpQ i2850ImpQ;

    /**
     * Gets the value of the i2850ImpQ property.
     * 
     * @return
     *     possible object is
     *     {@link I2850ImpQ }
     *     
     */
    public I2850ImpQ getI2850ImpQ() {
        return i2850ImpQ;
    }

    /**
     * Sets the value of the i2850ImpQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link I2850ImpQ }
     *     
     */
    public void setI2850ImpQ(I2850ImpQ value) {
        this.i2850ImpQ = value;
    }

}
