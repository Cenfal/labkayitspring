package com.thy.loyalty.loyaltyservices.earn.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.thy.loyalty.loyaltyservices.earn.dto.CalculateFlightMilesMultipleSegmentDetail;
import com.thy.loyalty.loyaltyservices.earn.dto.CalculateFlightMilesMultipleSegmentResult;
import com.thy.loyalty.loyaltyservices.earn.dto.Itenerary;
import com.thy.loyalty.loyaltyservices.earn.dto.IteneraryMilesEarningResult;
import com.thy.loyalty.loyaltyservices.earn.dto.ItenerarySegment;
import com.thy.loyalty.loyaltyservices.earn.dto.ItenerarySegmentMilesEarningResult;
import com.thy.loyalty.loyaltyservices.earn.dto.ItenerarySegmentResult;
import com.thy.loyalty.loyaltyservices.earn.service.ICalculateFlightMilesService;
import com.thy.loyalty.loyaltyservices.ws.common.CommonJava;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.loyalty.ms.config.WsConfig;
import com.thy.loyalty.ms.ws.common.w3.CalculateFlightMilesDetail;
import com.thy.loyalty.ms.ws.common.w3.CalculateFlightMilesResponseDetails;
import com.thy.loyalty.ms.ws.common.w3.CalculateFlightMilesResult;
import com.thy.loyalty.ms.ws.common.w3.CalculateFlightMilesService;
import com.thy.loyalty.ms.ws.common.w3.W3CalculateFlightMilesService;
import com.thy.ws.header.request.RequestHeader;
import com.thy.loyalty.ws.requestheader.ChannelType;
import com.thy.ws.requestheader.LanguageCodeType;
import com.thy.loyalty.ws.responseheader.ResponseHeader;
import com.thy.loyalty.ws.responseheader.StatusCode;

@Service
public class CalculateFlightMilesServiceImpl implements ICalculateFlightMilesService {

	private static Log logger = LogFactory.getLog(CalculateFlightMilesServiceImpl.class);
	
	@Override
	public CalculateFlightMilesMultipleSegmentResult calculateFlightMilesMultipleSegment(RequestHeader requestHeader,
						CalculateFlightMilesMultipleSegmentDetail calculateFlightMilesMultipleSegmentDetail) {


		CalculateFlightMilesMultipleSegmentResult result = new CalculateFlightMilesMultipleSegmentResult();
		
		try {
			
			ArrayList<IteneraryMilesEarningResult> iteneraryMilesEarningResultsList = new ArrayList<IteneraryMilesEarningResult>();
			
			for (int i = 0; i < calculateFlightMilesMultipleSegmentDetail.getIteneraryList().size(); i++) {
				iteneraryMilesEarningResultsList.add(getIteneraryMilesEarningResult(calculateFlightMilesMultipleSegmentDetail.getIteneraryList().get(i)));
			}

			
			result.setIteneraryMilesEarningResultsList(iteneraryMilesEarningResultsList);
			
			result.setResultCode("00");
			result.setResultDescription("Success");
			
		} catch (Throwable e) {
			logger.error(StringUtils.stack2string((Exception)e));

			result.setResultCode("SYSTEM_ERROR");
			result.setResultDescription("SYSTEM_ERROR");

		}
		
		
		return result;
	}
	
	private IteneraryMilesEarningResult getIteneraryMilesEarningResult(Itenerary itenary) throws Throwable{
		
		IteneraryMilesEarningResult result = new IteneraryMilesEarningResult();
		
		int baseMiles = 0;		int promoMiles  = 0;
		int basePoint = 0;		int promoPoints = 0;
		
		result.setShowItenarary(true); // Default TRUE
		
		ItenerarySegmentMilesEarningResult itenarySegmentMilesEarningResult = null; 
		
		ArrayList<ItenerarySegmentResult> itenerarySegmentResultList = new ArrayList<ItenerarySegmentResult>();
		ItenerarySegmentResult itenerarySegmentResult;
		
		for (int i = 0; i < itenary.getItenerarySegmentsList().size(); i++) {
			
			itenarySegmentMilesEarningResult = callCalculateFlightMiles(itenary.getItenerarySegmentsList().get(i));
			
			itenerarySegmentResult = new ItenerarySegmentResult();
				itenerarySegmentResult.setSegmentIndex(itenary.getItenerarySegmentsList().get(i).getSegmentIndex());
				itenerarySegmentResult.setResultCode(itenarySegmentMilesEarningResult.getResultCode());
				itenerarySegmentResult.setResultDescription(itenarySegmentMilesEarningResult.getResultDescription());
			itenerarySegmentResultList.add(itenerarySegmentResult);
			
			baseMiles 	+= itenarySegmentMilesEarningResult.getBaseMiles();
			promoMiles  += itenarySegmentMilesEarningResult.getPromoMiles();
			
			basePoint 	+= itenarySegmentMilesEarningResult.getBasePoint();
			promoPoints += itenarySegmentMilesEarningResult.getPromoPoints();
			
			if (itenarySegmentMilesEarningResult.getIsErrorOccured()){
				result.setShowItenarary(false);
			}
			
		}
		
		// result parameters
		result.setIteneraryIndex	(itenary.getIteneraryIndex());
		result.setSegmentCount		(itenary.getItenerarySegmentsList().size());
		
		result.setBaseMiles		(baseMiles);
		result.setPromoMiles	(promoMiles);
		result.setTotalMiles	(baseMiles + promoMiles);
		
		result.setBasePoint		(basePoint);
		result.setPromoPoints	(promoPoints);
		result.setTotalPoints	(basePoint + promoPoints);
		
		result.setItenerarySegmentResultList(itenerarySegmentResultList);
		
		
		return result;
	}
	
	
	private ItenerarySegmentMilesEarningResult callCalculateFlightMiles(ItenerarySegment itenarySegment) throws Throwable{
		
		ItenerarySegmentMilesEarningResult result = new ItenerarySegmentMilesEarningResult();
			result.setSegmentIndex(itenarySegment.getSegmentIndex());
			result.setBaseMiles		(0);
			result.setPromoMiles	(0);
			result.setBasePoint		(0);
			result.setPromoPoints	(0);
		
		
		CalculateFlightMilesService service = getCalculateFlightMiles();
		
		CalculateFlightMilesDetail calculateFlightMilesDetail = new CalculateFlightMilesDetail();
			calculateFlightMilesDetail.setOrigin(itenarySegment.getOrigin());
			calculateFlightMilesDetail.setDestination(itenarySegment.getDestination());
			calculateFlightMilesDetail.setFlightDate(itenarySegment.getFlightDate());
			calculateFlightMilesDetail.setCabinCode(itenarySegment.getCabinCode());
			calculateFlightMilesDetail.setClassCode(itenarySegment.getOperatingClassCode());
			calculateFlightMilesDetail.setMarketingClassCode(itenarySegment.getMarketingClassCode());
			calculateFlightMilesDetail.setOperatingFlightNumber(itenarySegment.getOperatingFlightNumber());
			calculateFlightMilesDetail.setMarketingFlightNumber(itenarySegment.getMarketingFlightNumber());
			calculateFlightMilesDetail.setCardType(CommonJava.strEqualNullOrEmpty(itenarySegment.getMemberCardType()) ? "CC":itenarySegment.getMemberCardType()); // Default CC
		
		Holder<ResponseHeader> responseHeader = new Holder<ResponseHeader>();
		
		CalculateFlightMilesResult serviceResult = service.calculateFlightMiles(getRequestHeaderForCalculateFlightMiles(), calculateFlightMilesDetail, responseHeader );

		
		if("MS00907000".equals(responseHeader.value.getMessages().get(0).getMessageCode())){
			
			// Delete LEAST_CLASS from response array
			ArrayList<CalculateFlightMilesResponseDetails> resultList = new ArrayList<CalculateFlightMilesResponseDetails>();
			for (int i = 0; i < serviceResult.getMilesResponseDetail().size(); i++) {
				if (! "LEASTCLASS".equals(serviceResult.getMilesResponseDetail().get(i).getCabinType())) {
					resultList.add(serviceResult.getMilesResponseDetail().get(i));
				}
			}
			
			//-
			
			if (resultList != null && resultList.size() == 1){
				// BASARILI VE TEK SONUC OLAN IDEAL SONUCLAR
				result.setBaseMiles		(Integer.parseInt(resultList.get(0).getBaseMiles()));
				result.setPromoMiles	(Integer.parseInt(resultList.get(0).getPromoMiles()));
				result.setBasePoint		(Integer.parseInt(resultList.get(0).getBasePoint()));
				result.setPromoPoints	(Integer.parseInt(resultList.get(0).getPromoPoints()));
				
				result.setResultCode		("00");
				result.setResultDescription	("SUCCESS");
				
			} else if (resultList.size() > 1) {
				// BIRDEN FAZLA SECENEK DONEN KAYITLAR
				result.setResultCode		("MR");
				result.setResultDescription	("MORE_THAN_ONE_RESULT");
				
			} else {
				// HERHANGI BIR SONUC GELMEMISSE
				result.setResultCode		("NR");
				result.setResultDescription	("NULL_RESPONSE");
			}
			
		} else {
			// SERVISTEN BASARILI CEVAP GELMEZSE
			result.setResultCode		(responseHeader.value.getMessages().get(0).getMessageCode().replace("MS009070", ""));
			result.setResultDescription	("W3CalculateFlightMilesService > " + 
										 "Error Code : " + responseHeader.value.getMessages().get(0).getMessageCode() +	" " +
										 "Error Description : " + responseHeader.value.getMessages().get(0).getLocalizedDescription());
			
			if(responseHeader.value.getStatusCode() != StatusCode.SUCCESS){
				result.setIsErrorOccured(true);
			}
			
		}
		
		
		return result;
	}
	
	
	private CalculateFlightMilesService getCalculateFlightMiles() {
		
		W3CalculateFlightMilesService w3calculateFlightMiles = new W3CalculateFlightMilesService();
		CalculateFlightMilesService port = w3calculateFlightMiles.getCalculateFlightMilesServicePort();

		BindingProvider bp = (BindingProvider) port;
		
		// servis bilgileri
		String endpointURL = WsConfig.getInstance().W3CALCULATE_FLIGHT_MILES_ENDPOINT_URL;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);
		if("FIREWALL".equals(WsConfig.getInstance().W3CALCULATE_FLIGHT_MILES_SERVICE_ACCESS_TYPE))
		{
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, WsConfig.getInstance().W3CALCULATE_FLIGHT_MILES_FIREWALL_USERNAME);
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, WsConfig.getInstance().W3CALCULATE_FLIGHT_MILES_FIREWALL_PASSWORD);
		}
		// header kullanici bilgileri
		Map<String,List<String>> headerUser = new HashMap<String,List<String>>();
		
			List<String> credentialInfos = new ArrayList<String>();
				credentialInfos.add(WsConfig.getInstance().W3CALCULATE_FLIGHT_MILES_CLIENT_CODE);
				headerUser.put("Username", credentialInfos);
				
				credentialInfos = new ArrayList<String>();
				credentialInfos.add(WsConfig.getInstance().W3CALCULATE_FLIGHT_MILES_CLIENT_USERNAME);
				headerUser.put("Password", credentialInfos);
			
		bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headerUser);
		//
		
		List handlerChain = bp.getBinding().getHandlerChain();	
		bp.getBinding().setHandlerChain(handlerChain);
	
		return port;		
		
	}
	
	private com.thy.loyalty.ws.requestheader.RequestHeader getRequestHeaderForCalculateFlightMiles(){
		
		com.thy.loyalty.ws.requestheader.RequestHeader requestHeader = new com.thy.loyalty.ws.requestheader.RequestHeader();
			requestHeader.setClientCode			(WsConfig.getInstance().W3CALCULATE_FLIGHT_MILES_CLIENT_CODE);
			requestHeader.setClientUsername		(WsConfig.getInstance().W3CALCULATE_FLIGHT_MILES_CLIENT_USERNAME);
			requestHeader.setChannel			(ChannelType.TKAPP);
			requestHeader.setLanguageCode		(LanguageCodeType.EN.value());
			requestHeader.setAirlineCode		("TK");
			requestHeader.setApplication		("LOYALTY_SERVICE");
			requestHeader.setClientTransactionId(((new Date()).getTime()) + "");
		
		return requestHeader;
		
	}
	
	
	

}
