package com.thy.loyalty.loyaltyservices.awardoperation.service.impl;

import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thy.loyalty.loyaltyservices.awardoperation.dto.NonAirIssueAwardRes;
import com.thy.loyalty.ms.config.WsConfig;
import com.thy.loyalty.ms.ws.redemption.AwardOperationsService;
import com.thy.loyalty.ms.ws.redemption.AwardOperationsService_Service;
import com.thy.loyalty.ms.ws.redemption.NonAirIssueAwardDetail;
import com.thy.loyalty.ms.ws.redemption.NonAirIssueAwardResult;
import com.thy.loyalty.ws.requestheader.ChannelType;
import com.thy.loyalty.ws.requestheader.RequestHeader;
import com.thy.loyalty.ws.responseheader.ResponseHeader;

public class MileRedemptionDAO {

	private static Log logger = LogFactory.getLog(MileRedemptionDAO.class);

	public static NonAirIssueAwardRes nonAirIssueAward(
			String channel,
			String airlineCode,
			String application,
			String agencyCode,
			String language,
			NonAirIssueAwardDetail nonAirIssueAwardDetail) throws Exception {
		
		
		NonAirIssueAwardRes result = new NonAirIssueAwardRes();
		RequestHeader requestHeader = new RequestHeader();
		
		try{
			requestHeader.setChannel(ChannelType.valueOf(channel));
			requestHeader.setLanguageCode(language);
			requestHeader.setAirlineCode(airlineCode);
			requestHeader.setAgencyCode(agencyCode);
			requestHeader.setApplication(application);
			
			requestHeader.setClientUsername("GR_BANKUSER");
			requestHeader.setClientCode("GR");
			
			AwardOperationsService_Service awardOperationService = new AwardOperationsService_Service();
			AwardOperationsService awardOperationPort = awardOperationService
					.getAwardOperationsServicePort();
			BindingProvider bp = (BindingProvider) awardOperationPort;

			// servis bilgileri
			String endpointURL = WsConfig.getInstance().AWARD_OPERATION_SERVICE_ENDPOINT;
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
				
				Holder<ResponseHeader> responseHeader = new Holder<ResponseHeader>();
				NonAirIssueAwardResult r = new NonAirIssueAwardResult();
				r =	awardOperationPort.nonAirIssueAward(requestHeader,
						nonAirIssueAwardDetail, responseHeader);
				
				if("00".equals(responseHeader.value.getMessages().get(0).getMessageCode()))
				{
					result.setNonAirIssueAwardResult(r);
				}
				
				result.setResultCode(responseHeader.value.getMessages().get(0).getMessageCode());
				result.setResultDescription(responseHeader.value.getMessages().get(0).getLocalizedDescription());
				
			} catch (Exception e) {
				logger.error("Error at getMemberDetails(): " + e.getMessage());
			}
			
		}catch (Throwable e) {
			logger.error("Error at getMemberDetails(): " + e.getLocalizedMessage());
		}


		return result;
	}

}
