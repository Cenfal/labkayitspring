
package com.thy.loyalty.ms.ws.w3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.thy.entrychannel.ms.ws.w3 package.
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

    private final static QName _GetMultiMemberDetails_QNAME = new QName("http://w3.ws.ms.thy.com/", "getMultiMemberDetails");
    private final static QName _GetMemberDetails_QNAME = new QName("http://w3.ws.ms.thy.com/", "getMemberDetails");
    private final static QName _GetMemberDetailsResponse_QNAME = new QName("http://w3.ws.ms.thy.com/", "getMemberDetailsResponse");
    private final static QName _GetMultiMemberDetailsResponse_QNAME = new QName("http://w3.ws.ms.thy.com/", "getMultiMemberDetailsResponse");
    private final static QName _IsServiceUpResponse_QNAME = new QName("http://w3.ws.ms.thy.com/", "isServiceUpResponse");
    private final static QName _IsServiceUp_QNAME = new QName("http://w3.ws.ms.thy.com/", "isServiceUp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.thy.entrychannel.ms.ws.w3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMultiMemberDetailsDetail }
     * 
     */
    public GetMultiMemberDetailsDetail createGetMultiMemberDetailsDetail() {
        return new GetMultiMemberDetailsDetail();
    }

    /**
     * Create an instance of {@link GetMemberDetailsResponse }
     * 
     */
    public GetMemberDetailsResponse createGetMemberDetailsResponse() {
        return new GetMemberDetailsResponse();
    }

    /**
     * Create an instance of {@link MethodResult }
     * 
     */
    public MethodResult createMethodResult() {
        return new MethodResult();
    }

    /**
     * Create an instance of {@link GetMemberDetails }
     * 
     */
    public GetMemberDetails createGetMemberDetails() {
        return new GetMemberDetails();
    }

    /**
     * Create an instance of {@link IsServiceUp }
     * 
     */
    public IsServiceUp createIsServiceUp() {
        return new IsServiceUp();
    }

    /**
     * Create an instance of {@link MsKeyValuePairW3 }
     * 
     */
    public MsKeyValuePairW3 createMsKeyValuePairW3() {
        return new MsKeyValuePairW3();
    }

    /**
     * Create an instance of {@link IsServiceUpResponse }
     * 
     */
    public IsServiceUpResponse createIsServiceUpResponse() {
        return new IsServiceUpResponse();
    }

    /**
     * Create an instance of {@link GetMultiMemberDetailsResult }
     * 
     */
    public GetMultiMemberDetailsResult createGetMultiMemberDetailsResult() {
        return new GetMultiMemberDetailsResult();
    }

    /**
     * Create an instance of {@link GetMemberDetailsDetail }
     * 
     */
    public GetMemberDetailsDetail createGetMemberDetailsDetail() {
        return new GetMemberDetailsDetail();
    }

    /**
     * Create an instance of {@link GetMultiMemberDetailsResultRecord }
     * 
     */
    public GetMultiMemberDetailsResultRecord createGetMultiMemberDetailsResultRecord() {
        return new GetMultiMemberDetailsResultRecord();
    }

    /**
     * Create an instance of {@link GetMemberDetailsResult }
     * 
     */
    public GetMemberDetailsResult createGetMemberDetailsResult() {
        return new GetMemberDetailsResult();
    }

    /**
     * Create an instance of {@link GetMultiMemberDetailsResponse }
     * 
     */
    public GetMultiMemberDetailsResponse createGetMultiMemberDetailsResponse() {
        return new GetMultiMemberDetailsResponse();
    }

    /**
     * Create an instance of {@link GetMultiMemberDetails }
     * 
     */
    public GetMultiMemberDetails createGetMultiMemberDetails() {
        return new GetMultiMemberDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMultiMemberDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://w3.ws.ms.thy.com/", name = "getMultiMemberDetails")
    public JAXBElement<GetMultiMemberDetails> createGetMultiMemberDetails(GetMultiMemberDetails value) {
        return new JAXBElement<GetMultiMemberDetails>(_GetMultiMemberDetails_QNAME, GetMultiMemberDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMemberDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://w3.ws.ms.thy.com/", name = "getMemberDetails")
    public JAXBElement<GetMemberDetails> createGetMemberDetails(GetMemberDetails value) {
        return new JAXBElement<GetMemberDetails>(_GetMemberDetails_QNAME, GetMemberDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMemberDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://w3.ws.ms.thy.com/", name = "getMemberDetailsResponse")
    public JAXBElement<GetMemberDetailsResponse> createGetMemberDetailsResponse(GetMemberDetailsResponse value) {
        return new JAXBElement<GetMemberDetailsResponse>(_GetMemberDetailsResponse_QNAME, GetMemberDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMultiMemberDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://w3.ws.ms.thy.com/", name = "getMultiMemberDetailsResponse")
    public JAXBElement<GetMultiMemberDetailsResponse> createGetMultiMemberDetailsResponse(GetMultiMemberDetailsResponse value) {
        return new JAXBElement<GetMultiMemberDetailsResponse>(_GetMultiMemberDetailsResponse_QNAME, GetMultiMemberDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsServiceUpResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://w3.ws.ms.thy.com/", name = "isServiceUpResponse")
    public JAXBElement<IsServiceUpResponse> createIsServiceUpResponse(IsServiceUpResponse value) {
        return new JAXBElement<IsServiceUpResponse>(_IsServiceUpResponse_QNAME, IsServiceUpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsServiceUp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://w3.ws.ms.thy.com/", name = "isServiceUp")
    public JAXBElement<IsServiceUp> createIsServiceUp(IsServiceUp value) {
        return new JAXBElement<IsServiceUp>(_IsServiceUp_QNAME, IsServiceUp.class, null, value);
    }

}
