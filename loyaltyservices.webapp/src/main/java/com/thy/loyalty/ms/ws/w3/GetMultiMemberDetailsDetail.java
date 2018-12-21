
package com.thy.loyalty.ms.ws.w3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMultiMemberDetailsDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMultiMemberDetailsDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="multiMemberDetailList" type="{http://w3.ws.ms.thy.com/}getMemberDetailsDetail" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMultiMemberDetailsDetail", propOrder = {
    "multiMemberDetailList"
})
public class GetMultiMemberDetailsDetail {

    @XmlElement(nillable = true)
    protected List<GetMemberDetailsDetail> multiMemberDetailList;

    /**
     * Gets the value of the multiMemberDetailList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the multiMemberDetailList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMultiMemberDetailList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetMemberDetailsDetail }
     * 
     * 
     */
    public List<GetMemberDetailsDetail> getMultiMemberDetailList() {
        if (multiMemberDetailList == null) {
            multiMemberDetailList = new ArrayList<GetMemberDetailsDetail>();
        }
        return this.multiMemberDetailList;
    }

}
