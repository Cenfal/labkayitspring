
package gtesb.bc1c2850response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gtesb.bc1c2850response package. 
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

    private final static QName _WsServiceResponse_QNAME = new QName("http://gtesb/BC1C2850Response", "wsServiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gtesb.bc1c2850response
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link E2850ExpErrorWsQ }
     * 
     */
    public E2850ExpErrorWsQ createE2850ExpErrorWsQ() {
        return new E2850ExpErrorWsQ();
    }

    /**
     * Create an instance of {@link WsServiceResponse }
     * 
     */
    public WsServiceResponse createWsServiceResponse() {
        return new WsServiceResponse();
    }

    /**
     * Create an instance of {@link ExpError }
     * 
     */
    public ExpError createExpError() {
        return new ExpError();
    }

    /**
     * Create an instance of {@link OutputFieldsQ }
     * 
     */
    public OutputFieldsQ createOutputFieldsQ() {
        return new OutputFieldsQ();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WsServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gtesb/BC1C2850Response", name = "wsServiceResponse")
    public JAXBElement<WsServiceResponse> createWsServiceResponse(WsServiceResponse value) {
        return new JAXBElement<WsServiceResponse>(_WsServiceResponse_QNAME, WsServiceResponse.class, null, value);
    }

}
