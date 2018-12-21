package com.thy.loyalty.loyaltyservices.mileredemption.service.impl;

import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thy.loyalty.ms.config.WsConfig;
import com.thy.loyalty.ms.ws.w3.GetMemberDetailsDetail;
import com.thy.loyalty.ms.ws.w3.GetMemberDetailsResult;
import com.thy.loyalty.ms.ws.w3.MemberCredentialService;
import com.thy.loyalty.ms.ws.w3.MemberDetailsService;
import com.thy.loyalty.ms.ws.w3.MemberLoginDetails;
import com.thy.loyalty.ms.ws.w3.MemberLoginW3Result;
import com.thy.loyalty.ms.ws.w3.W3MemberCredentialService;
import com.thy.loyalty.ms.ws.w3.W3MemberDetailsService;
import com.thy.loyalty.ws.requestheader.ChannelType;
import com.thy.loyalty.ws.requestheader.RequestHeader;
import com.thy.loyalty.ws.responseheader.ResponseHeader;

public class MemberDetailsDAO {

	private static Log logger = LogFactory.getLog(MemberDetailsDAO.class);

	public static GetMemberDetailsResult getMemberDetails(String language,
			String memberId) throws Exception {

		GetMemberDetailsResult result = new GetMemberDetailsResult();

		W3MemberDetailsService memberDetailService = new W3MemberDetailsService();
		MemberDetailsService memberDetailPort = memberDetailService
				.getMemberDetailsServicePort();

		BindingProvider bp = (BindingProvider) memberDetailPort;

		// servis bilgileri
		String endpointURL = WsConfig.getInstance().MEMBER_DETAILS_SERVICE_ENDPOINT;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				endpointURL);
		if ("FIREWALL".equals(WsConfig.getInstance().SERVICE_ACCESS_TYPE)) {
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
					WsConfig.getInstance().FIREWALL_USERNAME);
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
					WsConfig.getInstance().FIREWALL_PASSWORD);
		}

		List handlerChain = bp.getBinding().getHandlerChain();
		bp.getBinding().setHandlerChain(handlerChain);

		try {
			GetMemberDetailsDetail getMemberDetailsDetail = new GetMemberDetailsDetail();
			RequestHeader requestHeader = getRequestHeader(language);

			getMemberDetailsDetail.setFfid(memberId);

			Holder<ResponseHeader> responseHeader = new Holder<ResponseHeader>();
			result = memberDetailPort.getMemberDetails(requestHeader,
					getMemberDetailsDetail, responseHeader);
			//RESPONSEHEADER DA HATA KONTROLU YAP
			if(!"MS01102200".equals(responseHeader.value.getMessages().get(0).getMessageCode()))
			{
				result.getMemberDataKVPair().clear();
			}
			
		} catch (Exception e) {
			logger.error("Error at getMemberDetails(): " + e.getMessage());
		}

		return result;
	}

	public static MemberLoginW3Result memberLogin(
			MemberLoginDetails memberLoginDetail, String language)
			throws Exception {

		MemberLoginW3Result result = new MemberLoginW3Result();
		W3MemberCredentialService memberCredentialService = new W3MemberCredentialService();
		MemberCredentialService memberCredentialPort = memberCredentialService
				.getMemberCredentialServicePort();
		BindingProvider bp = (BindingProvider) memberCredentialPort;

		// servis bilgileri
		String endpointURL = WsConfig.getInstance().MEMBER_CREDENTIALS_SERVICE_ENDPOINT;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				endpointURL);
		if ("FIREWALL".equals(WsConfig.getInstance().SERVICE_ACCESS_TYPE)) {
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
					WsConfig.getInstance().FIREWALL_USERNAME);
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
					WsConfig.getInstance().FIREWALL_PASSWORD);
		}

		List handlerChain = bp.getBinding().getHandlerChain();
		bp.getBinding().setHandlerChain(handlerChain);

		try {
			RequestHeader requestHeader;
			requestHeader = getRequestHeader(language);

			Holder<ResponseHeader> responseHeader = null;
			result = memberCredentialPort.memberLogin(requestHeader,
					memberLoginDetail, responseHeader);

		} catch (Exception e) {
			logger.error("Error at memberLogin(): " + e.getMessage());
		}

		return result;

	}

	private static RequestHeader getRequestHeader(String language) {
		RequestHeader requestHeader = new RequestHeader();
		if (language == null || language.equalsIgnoreCase("tr")) {
			requestHeader.setLanguageCode("TR");
		} else {
			requestHeader.setLanguageCode("EN");
		}

		requestHeader
				.setClientUsername(WsConfig.getInstance().WS_CLM_CLIENT_USERNAME);
		requestHeader.setClientCode(WsConfig.getInstance().WS_CLM_CLIENT_CODE);
		requestHeader.setChannel(ChannelType.WEB);
		requestHeader.setAirlineCode(WsConfig.getInstance().WS_AIRLINE_CODE);
		requestHeader.setAgent(WsConfig.getInstance().WS_HEADER_AGENT);
		requestHeader
				.setApplication(WsConfig.getInstance().WS_HEADER_APPLICATION);
		requestHeader.setClientTransactionId((new java.rmi.server.UID())
				.toString());

		return requestHeader;
	}
}
