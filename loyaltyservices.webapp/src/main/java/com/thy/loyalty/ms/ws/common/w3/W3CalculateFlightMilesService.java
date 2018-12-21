
package com.thy.loyalty.ms.ws.common.w3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "W3CalculateFlightMilesService", targetNamespace = "http://w3.common.ws.ms.thy.com/", wsdlLocation = "W3CalculateFlightMilesService.wsdl")
public class W3CalculateFlightMilesService
    extends Service
{

    private final static URL W3CALCULATEFLIGHTMILESSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.thy.loyalty.ms.ws.common.w3.W3CalculateFlightMilesService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.thy.loyalty.ms.ws.common.w3.W3CalculateFlightMilesService.class.getResource(".");
            url = new URL(baseUrl, "W3CalculateFlightMilesService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'W3CalculateFlightMilesService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        W3CALCULATEFLIGHTMILESSERVICE_WSDL_LOCATION = url;
    }

    public W3CalculateFlightMilesService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public W3CalculateFlightMilesService() {
        super(W3CALCULATEFLIGHTMILESSERVICE_WSDL_LOCATION, new QName("http://w3.common.ws.ms.thy.com/", "W3CalculateFlightMilesService"));
    }

    /**
     * 
     * @return
     *     returns CalculateFlightMilesService
     */
    @WebEndpoint(name = "CalculateFlightMilesServicePort")
    public CalculateFlightMilesService getCalculateFlightMilesServicePort() {
        return super.getPort(new QName("http://w3.common.ws.ms.thy.com/", "CalculateFlightMilesServicePort"), CalculateFlightMilesService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalculateFlightMilesService
     */
    @WebEndpoint(name = "CalculateFlightMilesServicePort")
    public CalculateFlightMilesService getCalculateFlightMilesServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://w3.common.ws.ms.thy.com/", "CalculateFlightMilesServicePort"), CalculateFlightMilesService.class, features);
    }

}
