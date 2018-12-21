package com.thy.loyalty.loyaltyservices.couponoperation.service.impl;

import gtesb.bc1c2850.BC1C2850PortType;
import gtesb.bc1c2850.BC1C2850Service;
import gtesb.bc1c2850request.I2850ImpQ;
import gtesb.bc1c2850request.InputFieldsQ;
import gtesb.bc1c2850request.WsServiceRequest;
import gtesb.bc1c2850response.WsServiceResponse;

import java.util.List;

import javax.xml.ws.BindingProvider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thy.loyalty.ms.config.WsConfig;


public class GarantiCIPCouponDAO {
	

	private static Log logger = LogFactory.getLog(GarantiCIPCouponDAO.class);

	public static WsServiceResponse useGarantiCoupon(String couponCode) throws Exception {

		WsServiceResponse result = new WsServiceResponse();

		BC1C2850Service garantiService = new BC1C2850Service();
		BC1C2850PortType garantiPort = garantiService.getBC1C2850SOAPPort();

		BindingProvider bp = (BindingProvider) garantiPort;

		// servis bilgileri
		String endpointURL = WsConfig.getInstance().GARANTI_SERVICE_ENDPOINT;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				endpointURL);
		if ("FIREWALL".equals(WsConfig.getInstance().SERVICE_ACCESS_TYPE)) {
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
					WsConfig.getInstance().GARANTI_FIREWALL_USERNAME);
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
					WsConfig.getInstance().GARANTI_FIREWALL_PASSWORD);
		}

		List handlerChain = bp.getBinding().getHandlerChain();
		bp.getBinding().setHandlerChain(handlerChain);

		try {
			WsServiceRequest request = getRequestHeader();
			InputFieldsQ inputFields = new InputFieldsQ();
			I2850ImpQ input = new I2850ImpQ();
			input.setOfferKeyCodeQ(couponCode);
			inputFields.setI2850ImpQ(input);
			request.setInputFieldsQ(inputFields);

			result = garantiPort.bc1C2850Operation(request);
			//RESULT DA HATA KONTROLU YAP
			//
			
		} catch (Exception e) {
			logger.error("Error at getMemberDetails(): " + e.getMessage());
		}

		return result;
	}
	
	private static WsServiceRequest getRequestHeader() {
		WsServiceRequest requestHeader = new WsServiceRequest();
		requestHeader.setHdrCompanyId("GAR");
		requestHeader.setHdrPlatformType(WsConfig.getInstance().GARANTI_PLATFORM_TYPE);
		requestHeader.setHdrUserId(WsConfig.getInstance().GARANTI_HDR_USERID);
		requestHeader.setHdrPassword(WsConfig.getInstance().GARANTI_HDR_PASSWORD);
		requestHeader.setHdrDialectCd("TR");
		requestHeader.setLogDisplayYN("Y");
		return requestHeader;
	}


}
