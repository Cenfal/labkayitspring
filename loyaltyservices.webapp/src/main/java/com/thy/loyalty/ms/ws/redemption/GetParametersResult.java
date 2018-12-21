
package com.thy.loyalty.ms.ws.redemption;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getParametersResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getParametersResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://redemption.ws.ms.thy.com/}methodResult">
 *       &lt;sequence>
 *         &lt;element name="parameterList" type="{http://redemption.ws.ms.thy.com/}parameter" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getParametersResult", propOrder = {
    "parameterList"
})
public class GetParametersResult
    extends MethodResult
{

    @XmlElement(nillable = true)
    protected List<Parameter> parameterList;

    /**
     * Gets the value of the parameterList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameterList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameterList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Parameter }
     * 
     * 
     */
    public List<Parameter> getParameterList() {
        if (parameterList == null) {
            parameterList = new ArrayList<Parameter>();
        }
        return this.parameterList;
    }

}
