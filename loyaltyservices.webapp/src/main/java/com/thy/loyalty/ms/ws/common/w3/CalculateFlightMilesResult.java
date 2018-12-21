
package com.thy.loyalty.ms.ws.common.w3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for calculateFlightMilesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="calculateFlightMilesResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.common.ws.ms.thy.com/}serviceResult">
 *       &lt;sequence>
 *         &lt;element name="milesResponseDetail" type="{http://w3.common.ws.ms.thy.com/}calculateFlightMilesResponseDetails" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculateFlightMilesResult", propOrder = {
    "milesResponseDetail"
})
public class CalculateFlightMilesResult
    extends ServiceResult
{

    @XmlElement(nillable = true)
    protected List<CalculateFlightMilesResponseDetails> milesResponseDetail;

    /**
     * Gets the value of the milesResponseDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the milesResponseDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMilesResponseDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CalculateFlightMilesResponseDetails }
     * 
     * 
     */
    public List<CalculateFlightMilesResponseDetails> getMilesResponseDetail() {
        if (milesResponseDetail == null) {
            milesResponseDetail = new ArrayList<CalculateFlightMilesResponseDetails>();
        }
        return this.milesResponseDetail;
    }

}
