
package com.thy.loyalty.ms.ws.w3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMemberDetailsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMemberDetailsResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="memberDataKVPair" type="{http://w3.ws.ms.thy.com/}msKeyValuePairW3" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMemberDetailsResult", propOrder = {
    "memberDataKVPair"
})
@XmlSeeAlso({
    GetMultiMemberDetailsResultRecord.class
})
public class GetMemberDetailsResult
    extends MethodResult
{

    @XmlElement(nillable = true)
    protected List<MsKeyValuePairW3> memberDataKVPair;

    /**
     * Gets the value of the memberDataKVPair property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the memberDataKVPair property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMemberDataKVPair().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MsKeyValuePairW3 }
     * 
     * 
     */
    public List<MsKeyValuePairW3> getMemberDataKVPair() {
        if (memberDataKVPair == null) {
            memberDataKVPair = new ArrayList<MsKeyValuePairW3>();
        }
        return this.memberDataKVPair;
    }

}
