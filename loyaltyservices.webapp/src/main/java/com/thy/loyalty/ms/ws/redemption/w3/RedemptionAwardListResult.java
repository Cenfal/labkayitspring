
package com.thy.loyalty.ms.ws.redemption.w3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for redemptionAwardListResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="redemptionAwardListResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.redemption.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberOfAllAwards" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="redemptionAwardList" type="{http://w3.redemption.ws.ms.thy.com/}redemptionAwardList" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "redemptionAwardListResult", propOrder = {
    "language",
    "numberOfAllAwards",
    "redemptionAwardList",
    "userId"
})
public class RedemptionAwardListResult
    extends MethodResult
{

    protected String language;
    protected int numberOfAllAwards;
    @XmlElement(nillable = true)
    protected List<RedemptionAwardList> redemptionAwardList;
    protected String userId;

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the numberOfAllAwards property.
     * 
     */
    public int getNumberOfAllAwards() {
        return numberOfAllAwards;
    }

    /**
     * Sets the value of the numberOfAllAwards property.
     * 
     */
    public void setNumberOfAllAwards(int value) {
        this.numberOfAllAwards = value;
    }

    /**
     * Gets the value of the redemptionAwardList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the redemptionAwardList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRedemptionAwardList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RedemptionAwardList }
     * 
     * 
     */
    public List<RedemptionAwardList> getRedemptionAwardList() {
        if (redemptionAwardList == null) {
            redemptionAwardList = new ArrayList<RedemptionAwardList>();
        }
        return this.redemptionAwardList;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

}
