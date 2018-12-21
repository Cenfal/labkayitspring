
package com.thy.loyalty.ms.ws.common.w3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.thy.entrychannel.ms.ws.common.w3 package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CalculateFlightMilesResponse_QNAME = new QName("http://w3.common.ws.ms.thy.com/", "calculateFlightMilesResponse");
    private final static QName _CalculateFlightMiles_QNAME = new QName("http://w3.common.ws.ms.thy.com/", "calculateFlightMiles");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.thy.entrychannel.ms.ws.common.w3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculateFlightMilesResult }
     * 
     */
    public CalculateFlightMilesResult createCalculateFlightMilesResult() {
        return new CalculateFlightMilesResult();
    }

    /**
     * Create an instance of {@link CalculateFlightMiles }
     * 
     */
    public CalculateFlightMiles createCalculateFlightMiles() {
        return new CalculateFlightMiles();
    }

    /**
     * Create an instance of {@link CalculateFlightMilesDetail }
     * 
     */
    public CalculateFlightMilesDetail createCalculateFlightMilesDetail() {
        return new CalculateFlightMilesDetail();
    }

    /**
     * Create an instance of {@link CalculateFlightMilesResponse }
     * 
     */
    public CalculateFlightMilesResponse createCalculateFlightMilesResponse() {
        return new CalculateFlightMilesResponse();
    }

    /**
     * Create an instance of {@link CalculateFlightMilesResponseDetails }
     * 
     */
    public CalculateFlightMilesResponseDetails createCalculateFlightMilesResponseDetails() {
        return new CalculateFlightMilesResponseDetails();
    }

    /**
     * Create an instance of {@link ServiceResult }
     * 
     */
    public ServiceResult createServiceResult() {
        return new ServiceResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateFlightMilesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://w3.common.ws.ms.thy.com/", name = "calculateFlightMilesResponse")
    public JAXBElement<CalculateFlightMilesResponse> createCalculateFlightMilesResponse(CalculateFlightMilesResponse value) {
        return new JAXBElement<CalculateFlightMilesResponse>(_CalculateFlightMilesResponse_QNAME, CalculateFlightMilesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateFlightMiles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://w3.common.ws.ms.thy.com/", name = "calculateFlightMiles")
    public JAXBElement<CalculateFlightMiles> createCalculateFlightMiles(CalculateFlightMiles value) {
        return new JAXBElement<CalculateFlightMiles>(_CalculateFlightMiles_QNAME, CalculateFlightMiles.class, null, value);
    }

}
