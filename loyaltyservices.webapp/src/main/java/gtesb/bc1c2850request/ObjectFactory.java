
package gtesb.bc1c2850request;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gtesb.bc1c2850request package. 
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

    private final static QName _WsServiceRequest_QNAME = new QName("http://gtesb/BC1C2850Request", "wsServiceRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gtesb.bc1c2850request
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link I2850ImpQ }
     * 
     */
    public I2850ImpQ createI2850ImpQ() {
        return new I2850ImpQ();
    }

    /**
     * Create an instance of {@link WsServiceRequest }
     * 
     */
    public WsServiceRequest createWsServiceRequest() {
        return new WsServiceRequest();
    }

    /**
     * Create an instance of {@link InputFieldsQ }
     * 
     */
    public InputFieldsQ createInputFieldsQ() {
        return new InputFieldsQ();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WsServiceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtesb/BC1C2850Request", name = "wsServiceRequest")
    public JAXBElement<WsServiceRequest> createWsServiceRequest(WsServiceRequest value) {
        return new JAXBElement<WsServiceRequest>(_WsServiceRequest_QNAME, WsServiceRequest.class, null, value);
    }

}
