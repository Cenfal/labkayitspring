
package gtesb.bc1c2850response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OutputFieldsQ complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutputFieldsQ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="e2850ExpErrorWsQ" type="{http://gtesb/BC1C2850Response}E2850ExpErrorWsQ"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputFieldsQ", propOrder = {
    "e2850ExpErrorWsQ"
})
public class OutputFieldsQ {

    @XmlElement(required = true)
    protected E2850ExpErrorWsQ e2850ExpErrorWsQ;

    /**
     * Gets the value of the e2850ExpErrorWsQ property.
     * 
     * @return
     *     possible object is
     *     {@link E2850ExpErrorWsQ }
     *     
     */
    public E2850ExpErrorWsQ getE2850ExpErrorWsQ() {
        return e2850ExpErrorWsQ;
    }

    /**
     * Sets the value of the e2850ExpErrorWsQ property.
     * 
     * @param value
     *     allowed object is
     *     {@link E2850ExpErrorWsQ }
     *     
     */
    public void setE2850ExpErrorWsQ(E2850ExpErrorWsQ value) {
        this.e2850ExpErrorWsQ = value;
    }

}
