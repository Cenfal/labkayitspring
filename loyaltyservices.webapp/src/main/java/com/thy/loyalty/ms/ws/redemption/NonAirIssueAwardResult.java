
package com.thy.loyalty.ms.ws.redemption;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nonAirIssueAwardResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nonAirIssueAwardResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://redemption.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="approvalCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="redeemedMiles" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nonAirIssueAwardResult", propOrder = {
    "approvalCode",
    "redeemedMiles"
})
public class NonAirIssueAwardResult
{

    protected int approvalCode;
    protected double redeemedMiles;

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
     * Gets the value of the redeemedMiles property.
     * 
     */
    public double getRedeemedMiles() {
        return redeemedMiles;
    }

    /**
     * Sets the value of the redeemedMiles property.
     * 
     */
    public void setRedeemedMiles(double value) {
        this.redeemedMiles = value;
    }

}
