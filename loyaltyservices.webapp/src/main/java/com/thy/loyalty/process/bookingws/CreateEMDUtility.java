/**
 * 
 */
package com.thy.loyalty.process.bookingws;

import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import com.thy.client.ChannelType;
import com.thy.client.EmdsCreateOTARequest;
import com.thy.client.EmdsCreateOTAResponse;
import com.thy.client.EmdsService;
import com.thy.client.EmdsService_Service;
import com.thy.client.ParamType;
import com.thy.client.RequestHeader;
import com.thy.client.ResponseHeader;
import com.thy.loyalty.loyaltyservices.ws.common.CommonJava;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.loyalty.ms.config.WsConfig;
import com.thy.loyalty.ms.dblog.DBLogRecord;
import com.thy.loyalty.ms.ws.redemption.w3.SignInType;

public class CreateEMDUtility {

	public static EmdsService getEMDServiceType() {

		EmdsService_Service service = new EmdsService_Service();
		EmdsService type = service.getEmdsServicePort();

		BindingProvider bp = (BindingProvider) type;

		String endpointURL = WsConfig.getInstance().EMDSERVICE_ENDPOINT;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);
		
//		if (!Utils.isEmptyString(Parameters.getString("TKMILES_WS_TIMEOUT_IN_SECS")))
//			stub._setProperty("weblogic.webservice.rpc.timeoutsecs",Parameters.getString("TKMILES_WS_TIMEOUT_IN_SECS"));
		
		if ("FIREWALL".equals(WsConfig.getInstance().EMDSERVICE_SERVERACCESSTYPE)) {
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, WsConfig.getInstance().EMDSERVICE_FIREWALLUSERNAME);
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, WsConfig.getInstance().EMDSERVICE_FIREWALLPASSWORD);
		}

		List handlerChain = bp.getBinding().getHandlerChain();
		bp.getBinding().setHandlerChain(handlerChain);
		
		return type;
		
	}

	public static CreateEmdResult createEMD( SignInType signcode, EmdsCreateOTARequest emdRequest, DBLogRecord dbLog){
		
		CreateEmdResult createEmdResult = new CreateEmdResult();
		
		try {
			
			EmdsService type = CreateEMDUtility.getEMDServiceType();

			RequestHeader requestHeader = new RequestHeader();
			
			// CIP de bu kýsým yok
			ParamType par = new ParamType();
			par.setKey(WsConfig.getInstance().EMDSERVICE_EXTRAPARAMETER_KEY);
			par.setValue(WsConfig.getInstance().EMDSERVICE_EXTRAPARAMETER_VALUE);
			
			requestHeader.getExtraParameters().add(par);
			requestHeader.setClientTransactionId(emdRequest.getNPhaseId());
			requestHeader.setClientUsername(WsConfig.getInstance().EMDSERVICE_USERNAME);
			requestHeader.setClientCode(WsConfig.getInstance().EMDSERVICE_CLIENT_CODE);
			requestHeader.setUserAgencyCode(signcode.getInitials());
			requestHeader.setDutyCode(signcode.getDutyCode());
			requestHeader.setTon(signcode.getOfficeNumber());
			requestHeader.setAgencyOfficeCode(signcode.getCityCode());
			requestHeader.setChannel(ChannelType.WEB);
			requestHeader.setAirlineCode("TK");

			Holder<ResponseHeader> responseHeader = new Holder<ResponseHeader>();
			Holder<EmdsCreateOTAResponse> eMDResponse = new Holder<EmdsCreateOTAResponse>();

			dbLog.InsertComment("Create EMD request :" + CreateEMDUtility.logStringEMDRequest(emdRequest));
			
			type.emdsCreate(requestHeader, emdRequest, eMDResponse, responseHeader);
			
			if (eMDResponse!=null && eMDResponse.value!=null && responseHeader!=null && responseHeader.value!=null) {
			dbLog.InsertComment("Create EMD response :"+ CreateEMDUtility.logStringEMDResponse(eMDResponse.value, responseHeader.value));
			}
			
			if (eMDResponse.value == null) {
				
				if (responseHeader.value.getMessages() != null && responseHeader.value.getMessages().size() > 0) {
					
//					createEmdResult.setEmdNumber(eMDResponse.value.getEmdNumber());
					createEmdResult.setResultCode("55");
					createEmdResult.setResultDescription(responseHeader.value.getMessages().get(0).getReason()+":"+responseHeader.value.getMessages().get(0).getLocalizedDescription());
				} else {
					
//					createEmdResult.setEmdNumber(eMDResponse.value.getEmdNumber());
					createEmdResult.setResultCode("09");
					createEmdResult.setResultDescription("Response message is null");
				}
				
			} else {

				if (CommonJava.strEqualNullOrEmpty(eMDResponse.value.getEmdNumber())) {

//					createEmdResult.setEmdNumber(eMDResponse.value.getEmdNumber());
					createEmdResult.setResultCode("09");
					
//					if(!"<>".equals(eMDResponse.value.getErrorMessage())){
//						createEmdResult.setResultDescription(responseHeader.value.getMessages().get(0).getReason());
//					}else{
						createEmdResult.setResultDescription("EMD Number is null");
//					}
					
				}else{
					
					createEmdResult.setEmdNumber(eMDResponse.value.getEmdNumber());
					createEmdResult.setResultCode("00");
					createEmdResult.setResultDescription("SUCCESS");
				
				}
			}

		} catch (Exception e) {
			createEmdResult.setResultCode("99");
			createEmdResult.setResultDescription(StringUtils.stack2string(e));
		}
		
		return createEmdResult;
		
	}
	
	public static String logStringEMDRequest(EmdsCreateOTARequest emdRequest){
		
		
		String inputParams="";
		String nphaseID="";
		
		try {
			
//			if(emdRequest.getSignCode()!=null) 
//				inputParams=inputParams +"\n SignInType : " + DBLogRecord.generatelog(emdRequest.getSignCode());
			
			if(emdRequest.getProfile()!=null)  
				inputParams=inputParams +"\n ProfileType : " + DBLogRecord.generatelog(emdRequest.getProfile());
			
			if(emdRequest.getFlight()!=null)  
				inputParams=inputParams +"\n FlightType : " + DBLogRecord.generatelog(emdRequest.getFlight());
			
//			if(payments.getPaymentType()!=null)  
//				inputParams=inputParams +"\n EMDRequestPaymentsType.paymentType : " + DBLogRecord.generatelog(payments.getPaymentType().toString());
			
			if(emdRequest.getPaymentInfo().getCashPaymentData()!=null &&
			   emdRequest.getPaymentInfo().getCashPaymentData().getCashPaymentList()!=null &&
			   emdRequest.getPaymentInfo().getCashPaymentData().getCashPaymentList().size()>0 &&
			   emdRequest.getPaymentInfo().getCashPaymentData().getCashPaymentList().get(0)!=null)  
				inputParams=inputParams +"\n EMDRequestPaymentsType.cashPayments : " + DBLogRecord.generatelog(emdRequest.getPaymentInfo().getCashPaymentData().getCashPaymentList().get(0));
			
			if(emdRequest.getPaymentInfo().getCardPaymentData()!=null && 
			   emdRequest.getPaymentInfo().getCardPaymentData().getCardPaymentList()!=null &&
			   emdRequest.getPaymentInfo().getCardPaymentData().getCardPaymentList().size()>0 &&
			   emdRequest.getPaymentInfo().getCardPaymentData().getCardPaymentList().get(0)!=null)  
				inputParams=inputParams +"\n EMDRequestPaymentsType.cardPayments : " + DBLogRecord.generatelog(emdRequest.getPaymentInfo().getCardPaymentData().getCardPaymentList().get(0));
			
			if(emdRequest.getPaymentInfo().getMilesPaymentData()!=null &&
			   emdRequest.getPaymentInfo().getMilesPaymentData().getMilesPaymentList()!=null &&
			   emdRequest.getPaymentInfo().getMilesPaymentData().getMilesPaymentList().size()>0 &&
			   emdRequest.getPaymentInfo().getMilesPaymentData().getMilesPaymentList().get(0)!=null)  
				inputParams=inputParams +"\n EMDRequestPaymentsType.milesPayments : " + DBLogRecord.generatelog(emdRequest.getPaymentInfo().getMilesPaymentData().getMilesPaymentList().get(0));
			
			if(emdRequest.getPaymentInfo().getVposPaymentData()!=null && 
			   emdRequest.getPaymentInfo().getVposPaymentData().getVposPaymentList()!=null &&
			   emdRequest.getPaymentInfo().getVposPaymentData().getVposPaymentList().size()>0 &&
			   emdRequest.getPaymentInfo().getVposPaymentData().getVposPaymentList().get(0)!=null)  
				inputParams=inputParams +"\n EMDRequestPaymentsType.vposPayments : " + DBLogRecord.generatelog(emdRequest.getPaymentInfo().getVposPaymentData().getVposPaymentList().get(0));
			
			nphaseID = emdRequest.getNPhaseId();
			
			inputParams = "Input Parameters :\n NphaseId: "+nphaseID+"\n "+inputParams;
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			inputParams = "Error while preparing log Exception: "+StringUtils.stack2string(e1);
		}

		return inputParams;
	}

	public static String logStringEMDResponse(EmdsCreateOTAResponse response, ResponseHeader responseHeader){
		
		String responseStr="";
		
		if (response == null) {
			
			if (responseHeader.getMessages() != null && responseHeader.getMessages().size()>0) {
					responseStr = responseStr + "\n" + "statusCode : " + responseHeader.getStatusCode();
					responseStr = responseStr + "\n" + "reason : " + responseHeader.getMessages().get(0).getReason();
					responseStr = responseStr + "\n" + "localizedDescription : " + responseHeader.getMessages().get(0).getLocalizedDescription();
			} else {
				
				responseStr = responseStr + "\n response.getErrorMessage() is null or empty";
			}
		} else {

			if (CommonJava.strEqualNullOrEmpty(response.getEmdNumber())) {

				responseStr = responseStr + "\n response.getEmdNumber() is null or empty";
			}
			
			// EMD buraya kadar gelmisse doludur
			responseStr = responseStr + "\n EmdNumber :" + response.getEmdNumber();
			
			responseStr = responseStr +  DBLogRecord.generatelog(response);
		}
		
		
		return responseStr;
		
	}
	
}
