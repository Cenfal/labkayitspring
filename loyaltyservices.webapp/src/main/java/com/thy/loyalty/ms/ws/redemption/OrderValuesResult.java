
package com.thy.loyalty.ms.ws.redemption;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderValuesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderValuesResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://redemption.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="orderIdValues" type="{http://redemption.ws.ms.thy.com/}keyValue" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="partnerParameterList" type="{http://redemption.ws.ms.thy.com/}parameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderValuesResult", propOrder = {
    "orderIdValues",
    "partnerParameterList"
})
public class OrderValuesResult
    extends MethodResult
{

    @XmlElement(nillable = true)
    protected List<KeyValue> orderIdValues;
    @XmlElement(nillable = true)
    protected List<Parameter> partnerParameterList;

    /**
     * Gets the value of the orderIdValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orderIdValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrderIdValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValue }
     * 
     * 
     */
    public List<KeyValue> getOrderIdValues() {
        if (orderIdValues == null) {
            orderIdValues = new ArrayList<KeyValue>();
        }
        return this.orderIdValues;
    }

    /**
     * Gets the value of the partnerParameterList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partnerParameterList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartnerParameterList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Parameter }
     * 
     * 
     */
    public List<Parameter> getPartnerParameterList() {
        if (partnerParameterList == null) {
            partnerParameterList = new ArrayList<Parameter>();
        }
        return this.partnerParameterList;
    }

}
