
package com.thy.loyalty.ms.ws.w3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for isMemberValidDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="isMemberValidDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isMemberValidList" type="{http://w3.ws.ms.thy.com/}isMemberValidDetailsRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "isMemberValidDetail", propOrder = {
    "isMemberValidList"
})
public class IsMemberValidDetail {

    @XmlElement(nillable = true)
    protected List<IsMemberValidDetailsRecord> isMemberValidList;

    /**
     * Gets the value of the isMemberValidList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the isMemberValidList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIsMemberValidList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IsMemberValidDetailsRecord }
     * 
     * 
     */
    public List<IsMemberValidDetailsRecord> getIsMemberValidList() {
        if (isMemberValidList == null) {
            isMemberValidList = new ArrayList<IsMemberValidDetailsRecord>();
        }
        return this.isMemberValidList;
    }

}
