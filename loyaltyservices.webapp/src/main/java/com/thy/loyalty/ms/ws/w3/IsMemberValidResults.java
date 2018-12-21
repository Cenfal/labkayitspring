
package com.thy.loyalty.ms.ws.w3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for isMemberValidResults complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="isMemberValidResults">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="isMemberValidResultList" type="{http://w3.ws.ms.thy.com/}isMemberValidResultRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "isMemberValidResults", propOrder = {
    "isMemberValidResultList"
})
public class IsMemberValidResults
    extends MethodResult
{

    @XmlElement(nillable = true)
    protected List<IsMemberValidResultRecord> isMemberValidResultList;

    /**
     * Gets the value of the isMemberValidResultList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the isMemberValidResultList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIsMemberValidResultList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IsMemberValidResultRecord }
     * 
     * 
     */
    public List<IsMemberValidResultRecord> getIsMemberValidResultList() {
        if (isMemberValidResultList == null) {
            isMemberValidResultList = new ArrayList<IsMemberValidResultRecord>();
        }
        return this.isMemberValidResultList;
    }

}
