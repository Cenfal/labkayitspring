
package com.thy.loyalty.ms.ws.redemption.w3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nonAirReissueAwardResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nonAirReissueAwardResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.redemption.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="approvalCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reissuedMiles" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nonAirReissueAwardResult", propOrder = {
    "approvalCode",
    "reissuedMiles"
})
public class NonAirReissueAwardResult
    extends MethodResult
{

    protected int approvalCode;
    protected double reissuedMiles;

    /**
     * Gets the value of the approvalCode property.
     * 
     */
    public int getApprovalCode() {
        return approvalCode;
    }

    /**
     * Sets the value of the approvalCode property.
     * 
     */
    public void setApprovalCode(int value) {
        this.approvalCode = value;
    }

    /**
     * Gets the value of the reissuedMiles property.
     * 
     */
    public double getReissuedMiles() {
        return reissuedMiles;
    }

    /**
     * Sets the value of the reissuedMiles property.
     * 
     */
    public void setReissuedMiles(double value) {
        this.reissuedMiles = value;
    }

}
