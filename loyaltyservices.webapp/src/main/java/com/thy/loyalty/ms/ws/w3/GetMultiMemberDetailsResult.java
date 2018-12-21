
package com.thy.loyalty.ms.ws.w3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMultiMemberDetailsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMultiMemberDetailsResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://w3.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="multiMemberDetail" type="{http://w3.ws.ms.thy.com/}getMultiMemberDetailsResultRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMultiMemberDetailsResult", propOrder = {
    "multiMemberDetail"
})
public class GetMultiMemberDetailsResult
    extends MethodResult
{

    @XmlElement(nillable = true)
    protected List<GetMultiMemberDetailsResultRecord> multiMemberDetail;

    /**
     * Gets the value of the multiMemberDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the multiMemberDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMultiMemberDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetMultiMemberDetailsResultRecord }
     * 
     * 
     */
    public List<GetMultiMemberDetailsResultRecord> getMultiMemberDetail() {
        if (multiMemberDetail == null) {
            multiMemberDetail = new ArrayList<GetMultiMemberDetailsResultRecord>();
        }
        return this.multiMemberDetail;
    }

}
