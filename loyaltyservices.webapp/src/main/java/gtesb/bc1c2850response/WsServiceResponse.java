
package gtesb.bc1c2850response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WsServiceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WsServiceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outputFieldsQ" type="{http://gtesb/BC1C2850Response}OutputFieldsQ"/>
 *         &lt;element name="expError" type="{http://gtesb/BC1C2850Response}ExpError"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WsServiceResponse", propOrder = {
    "outputFieldsQ",
    "expError"
})
public class WsServiceResponse {

    @XmlElement(required = true)
    protected OutputFieldsQ outputFieldsQ;
    @XmlElement(required = true)
    protected ExpError expError;

    /**
     * Gets the value of the outputFieldsQ property.
     * 
     * @return
     *     possible object is
     *     {@link OutputFieldsQ }
     *     
     */
    public OutputFieldsQ getOutputFieldsQ() {
        return outputFieldsQ;
    }

    /**
     * Sets the value of the outputFieldsQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputFieldsQ }
     *     
     */
    public void setOutputFieldsQ(OutputFieldsQ value) {
        this.outputFieldsQ = value;
    }

    /**
     * Gets the value of the expError property.
     * 
     * @return
     *     possible object is
     *     {@link ExpError }
     *     
     */
    public ExpError getExpError() {
        return expError;
    }

    /**
     * Sets the value of the expError property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpError }
     *     
     */
    public void setExpError(ExpError value) {
        this.expError = value;
    }

}
