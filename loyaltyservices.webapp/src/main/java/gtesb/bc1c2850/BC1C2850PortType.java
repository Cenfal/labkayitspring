
package gtesb.bc1c2850;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import gtesb.bc1c2850request.WsServiceRequest;
import gtesb.bc1c2850response.WsServiceResponse;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "BC1C2850PortType", targetNamespace = "http://gtesb/BC1C2850/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    gtesb.bc1c2850response.ObjectFactory.class,
    gtesb.bc1c2850.ObjectFactory.class,
    gtesb.bc1c2850request.ObjectFactory.class
})
public interface BC1C2850PortType {


    /**
     * 
     * @param parameters
     * @return
     *     returns gtesb.bc1c2850response.WsServiceResponse
     */
    @WebMethod(operationName = "BC1C2850Operation", action = "http://gtesb/BC1C2850/BC1C2850Operation")
    @WebResult(name = "wsServiceResponse", targetNamespace = "http://gtesb/BC1C2850Response", partName = "parameters")
    public WsServiceResponse bc1C2850Operation(
        @WebParam(name = "wsServiceRequest", targetNamespace = "http://gtesb/BC1C2850Request", partName = "parameters")
        WsServiceRequest parameters);

}