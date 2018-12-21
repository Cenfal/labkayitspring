
package com.thy.loyalty.ms.ws.redemption.w3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ecGiftMembersResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ecGiftMembersResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.redemption.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="ecGiftList" type="{http://w3.redemption.ws.ms.thy.com/}ecGiftMemberList" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ecGiftMembersResult", propOrder = {
    "ecGiftList"
})
public class EcGiftMembersResult
    extends MethodResult
{

    @XmlElement(nillable = true)
    protected List<EcGiftMemberList> ecGiftList;

    /**
     * Gets the value of the ecGiftList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ecGiftList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEcGiftList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EcGiftMemberList }
     * 
     * 
     */
    public List<EcGiftMemberList> getEcGiftList() {
        if (ecGiftList == null) {
            ecGiftList = new ArrayList<EcGiftMemberList>();
        }
        return this.ecGiftList;
    }

}
