/**
 * 
 *//*

package com.thy.entrychannel.loyaltyservices.milesell.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thy.entrychannel.entity.mileProcess.MileProcessTransaction;
import com.thy.entrychannel.entity.mileProcess.MileProcessTransactionDAO;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comarch.clm.thy.api.services.ExtCLMServiceStub;
import com.comarch.clm.thy.api.services.ExtCLMServiceStub.ChannelType;
import com.comarch.clm.thy.api.services.ExtCLMServiceStub.ParamType;
import com.comarch.clm.thy.api.services.ExtCLMServiceStub.ResponseHeader;
import com.jforce.tools.SimpleDate;
import com.thy.entrychannel.loyaltyservices.member.dto.Member;
import com.thy.entrychannel.loyaltyservices.mileredemption.service.impl.MemberDetailsDAO;
import com.thy.entrychannel.loyaltyservices.milesell.dto.MileSellProcessDetail;
import com.thy.entrychannel.loyaltyservices.milesell.dto.MileSellProcessResult;
import com.thy.entrychannel.loyaltyservices.milesell.dto.MileSellTransactionStatus;
import com.thy.entrychannel.loyaltyservices.milesell.dto.MileType;
import com.thy.entrychannel.loyaltyservices.milesell.dto.PaymentType;
import com.thy.entrychannel.loyaltyservices.milesell.dto.UndoMileSellProcessDetail;
import com.thy.entrychannel.loyaltyservices.milesell.dto.UndoMileSellProcessResult;
import com.thy.entrychannel.loyaltyservices.milesell.service.IMileSellOperationService;
import com.thy.entrychannel.ms.common.operations.Utils;
import com.thy.entrychannel.ms.config.StringUtils;
import com.thy.entrychannel.ms.config.WsConfig;
import com.thy.entrychannel.ms.dblog.DBLogRecord;
import com.thy.entrychannel.ms.ws.w3.GetMemberDetailsResult;
import com.thy.entrychannel.ms.ws.w3.MsKeyValuePairW3;
import com.thy.entrychannel.process.bookingws.BookingWSOperations;
import com.thy.entrychannel.process.bookingws.CreateEmdDetail;
import com.thy.entrychannel.process.bookingws.CreditCard;
import com.thy.entrychannel.process.milesell.MileSellOperations;
import com.thy.ws.header.request.RequestHeader;

*/
/**
 * @author O_CETIN3
 *
 *//*

@Service
public class MileSellOperationServiceImpl implements IMileSellOperationService {
	
	private static Log logger = LogFactory.getLog(MileSellOperationServiceImpl.class);

	@Override
	public MileSellProcessResult mileSellProcess(RequestHeader requestHeader,MileSellProcessDetail mileSellProcessDetail, DBLogRecord dbLog) throws Exception {
		
		MileSellProcessResult mileSellProcessResult = new MileSellProcessResult();
		MileSellTransactionStatus mileSellTransactionStatus = MileSellTransactionStatus.STARTED;

		//generate approval code
		int approvalCode = MileSellOperations.generateApprovalCode();
		
		dbLog.InsertComment("Approvalcode has been created: "+approvalCode);
		
		//generate transaction record
		MileProcessTransaction mileProcess = new MileProcessTransaction();
		
		try {
			
			mileProcess.setMileType(mileSellProcessDetail.getMileType());
			mileProcess.setNphaseID(mileSellProcessDetail.getnPhaseId());
			mileProcess.setApprovalCode(approvalCode);
			mileProcess.setDblogProcessID((int)dbLog.getProcessId());
			mileProcess.setOrderID(mileSellProcessDetail.getOrderID());
			mileProcess.setStatus(MileSellTransactionStatus.STARTED);
			
			mileProcess.insertRecord(); 

			dbLog.InsertComment("mileProcess has been inserted: ", mileProcess, mileProcess);
			
			mileSellTransactionStatus = MileSellTransactionStatus.INPROGRESS;
			MileProcessTransactionDAO.updateStatus(mileSellTransactionStatus, mileProcess.getId());
			
			//get memberDetails - BEGIN
			Member member = new Member();
			member.setMemberId(mileSellProcessDetail.getSponsorFFid());
			
			Map<String,String> result = controlMemberDetails(requestHeader.getLanguageCode().toString(), member, dbLog);

			dbLog.InsertComment("controlMemberDetails has been called: ");
			
			if (result!=null && result.get("RETUN_CODE")!=null) {

				dbLog.InsertComment("Error in controlMemberDetails :"+ result.get("RETUN_TEXT"));
				
				MileProcessTransactionDAO.updateStatus(MileSellTransactionStatus.FAILED, mileProcess.getId());
				
				mileSellProcessResult.setResultCode(result.get("RETUN_CODE"));
				mileSellProcessResult.setResultDescription(result.get("RETUN_TEXT"));
				
				return mileSellProcessResult;
			}

			//call createEMD
			dbLog.InsertComment("createEmdDetail initializing ");
			CreateEmdDetail createEmdDetail = new CreateEmdDetail();
			
			createEmdDetail.setMember(member);
			createEmdDetail.setnPhaseId(mileSellProcessDetail.getnPhaseId());
			createEmdDetail.setPaymentType(mileSellProcessDetail.getPaymentType());
			createEmdDetail.setApprovalCode(approvalCode);

			if (PaymentType.CARD.equals(createEmdDetail.getPaymentType())||PaymentType.VPOS.equals(createEmdDetail.getPaymentType())) {
				
				CreditCard creditCard = new CreditCard();
				
				creditCard.setAuthCode(mileSellProcessDetail.getBankAuthentiactionCode());
				creditCard.setBankCode(mileSellProcessDetail.getBankCode());
				creditCard.setCardNumber(mileSellProcessDetail.getCardNumber());
				creditCard.setCardType(mileSellProcessDetail.getCardType());
				creditCard.setExpireDate(new SimpleDate(String.valueOf(mileSellProcessDetail.getCardExpireDate()), "yyyyMM"));
				creditCard.setHostDate(mileSellProcessDetail.getHostDate());
				creditCard.setVirtualCard(mileSellProcessDetail.getVirtualCard()==null?true:false);
				
				createEmdDetail.setCreditCard(creditCard);
				
			}
			createEmdDetail.setCurrency(mileSellProcessDetail.getEmdCurrency());
			createEmdDetail.setCurrencyRate(mileSellProcessDetail.getCurrencyRate());
			createEmdDetail.setMileType(mileSellProcessDetail.getMileType());
			createEmdDetail.setOrderId(mileSellProcessDetail.getOrderID());
			createEmdDetail.setPrice(new BigDecimal(mileSellProcessDetail.getEmdPrice()));
//			createEmdDetail.setTax(mileSellProcessDetail.get);
			createEmdDetail.setMileAmount((int)mileSellProcessDetail.getMileAmount());
			
			BookingWSOperations.createEMD(createEmdDetail, dbLog);

			dbLog.InsertComment("CreateEMD has been created: ", createEmdDetail, createEmdDetail);
			
			MileProcessTransactionDAO.updateEmdNumber(createEmdDetail.getEmdNumber(),mileProcess.getId());

			dbLog.InsertComment("mileProcess.updateEmdNumber has been called: ", "emdNumber: "+createEmdDetail.getEmdNumber()+", mileProcessId: "+mileProcess.getId(), null);
			
			//call CLM mile com.comarch.clm.thy.api.services
			dbLog.StartStep();

			Double  emdPrice = mileSellProcessDetail.getMileAmount();
			Integer loyaltyApprovalCode = 0;
			ResponseHeader responseHeader = null;
			
			ExtCLMServiceStub stub = new ExtCLMServiceStub();
			
			stub._getServiceClient().getAxisService().setEndpointURL(WsConfig.getInstance().CLM_SERVICE_ENDPOINT);
			
			if (!Utils.isEmptyString(WsConfig.getInstance().EMDSERVICE_TIMEOUT_IN_SECS)){
				stub._getServiceClient().getOptions().setProperty("weblogic.webservice.rpc.timeoutsecs",
						WsConfig.getInstance().EMDSERVICE_TIMEOUT_IN_SECS);
			}

			if ("FIREWALL".equals(WsConfig.getInstance().SERVICE_ACCESS_TYPE)) {

				HttpTransportProperties.Authenticator basicAuthentication  = new HttpTransportProperties. Authenticator ( ) ;
				basicAuthentication.setUsername ( WsConfig.getInstance().FIREWALL_USERNAME ) ;
				basicAuthentication.setPassword ( WsConfig.getInstance().FIREWALL_PASSWORD ) ;
				stub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, basicAuthentication );
				stub._getServiceClient().getOptions().setProperty("username", WsConfig.getInstance().FIREWALL_USERNAME );
				stub._getServiceClient().getOptions().setProperty("password", WsConfig.getInstance().FIREWALL_PASSWORD );
				stub._getServiceClient().getOptions().setProperty (org. apache. axis2. transport. http. HTTPConstants. CHUNKED,  Boolean. FALSE ) ;
			}

			requestHeader.setClientCode(WsConfig.getInstance().CLM_CLIENT_CODE);
			requestHeader.setClientUsername(WsConfig.getInstance().CLM_CLIENT_USERNAME);
//			requestHeader.setLanguageCode(LanguageCodeType.ENGLISH);
			requestHeader.setChannel(com.thy.ws.header.request.ChannelType.WEB);
//			requestHeader.setClientTransactionId("4564576247");
			
			if (MileType.bonus.equals(mileSellProcessDetail.getMileType())) {
				
				ExtCLMServiceStub.PurchasePointsExtResponseE responseE = new ExtCLMServiceStub.PurchasePointsExtResponseE();
				ExtCLMServiceStub.PurchasePointsExtE paramsE = new ExtCLMServiceStub.PurchasePointsExtE();
				ExtCLMServiceStub.PurchasePointsExt params = new ExtCLMServiceStub.PurchasePointsExt();
				
				params.setAmount(((Double)mileSellProcessDetail.getEmdPrice()).intValue());
				params.setCost(emdPrice.intValue());
				params.setCurrency(mileSellProcessDetail.getEmdCurrency());
				params.setEmd(createEmdDetail.getEmdNumber());
				params.setExternalReferenceID(String.valueOf(approvalCode));
				params.setFfid(mileSellProcessDetail.getTargetFFid());
				params.setRequestHeader(convertRequestHeader(requestHeader));
				params.setSponsorFFid(mileSellProcessDetail.getSponsorFFid());
				
				paramsE.setPurchasePointsExt( params );
				
				responseE = stub.purchasePointsExt( paramsE );
				
				responseHeader = responseE.getPurchasePointsExtResponse().getResponseHeader();
				loyaltyApprovalCode = (int) (long) responseE.getPurchasePointsExtResponse().get_return().getLoyaltyApprovalCode();
				
			}else if (MileType.expireMileReaktivate.equals(mileSellProcessDetail.getMileType())) {

				ExtCLMServiceStub.ReactivatedExpiredPointsResponseE responseE = new ExtCLMServiceStub.ReactivatedExpiredPointsResponseE();
				ExtCLMServiceStub.ReactivateExpiredPointsE paramsE = new ExtCLMServiceStub.ReactivateExpiredPointsE();
				ExtCLMServiceStub.ReactivateExpiredPoints params = new ExtCLMServiceStub.ReactivateExpiredPoints();

				params.setCost(emdPrice.intValue());
				params.setCurrency(mileSellProcessDetail.getEmdCurrency());
				params.setEmd(createEmdDetail.getEmdNumber());
				params.setExternalReferenceID(String.valueOf(approvalCode));
				params.setFfid(mileSellProcessDetail.getSponsorFFid());
				params.setMile(((Double)mileSellProcessDetail.getEmdPrice()).intValue());
				params.setRequestHeader(convertRequestHeader(requestHeader));
				
				paramsE.setReactivateExpiredPoints( params );
				
				responseE = stub.reactivateExpiredPoints( paramsE );
				
				responseHeader = responseE.getReactivatedExpiredPointsResponse().getResponseHeader();
				loyaltyApprovalCode = (int) (long) responseE.getReactivatedExpiredPointsResponse().get_return().getLoyaltyApprovalCode();
				
			}else if (MileType.mileReaktivate.equals(mileSellProcessDetail.getMileType())) {

				ExtCLMServiceStub.ExtendPointsExpiryResponseE responseE = new ExtCLMServiceStub.ExtendPointsExpiryResponseE();
				ExtCLMServiceStub.ExtendPointsExpiryE paramsE = new ExtCLMServiceStub.ExtendPointsExpiryE();
				ExtCLMServiceStub.ExtendPointsExpiry params = new ExtCLMServiceStub.ExtendPointsExpiry();

				params.setCost(emdPrice.intValue());
				params.setCurrency(mileSellProcessDetail.getEmdCurrency());
				params.setEmd(createEmdDetail.getEmdNumber());
				params.setExternalReferenceID(String.valueOf(approvalCode));
				params.setFfID(mileSellProcessDetail.getSponsorFFid());
				params.setMile(((Double)mileSellProcessDetail.getEmdPrice()).intValue());
				params.setRequestHeader(convertRequestHeader(requestHeader));
				
				paramsE.setExtendPointsExpiry( params );
				
				responseE = stub.extendPointsExpiry( paramsE );
				
				responseHeader = responseE.getExtendPointsExpiryResponse().getResponseHeader();
				loyaltyApprovalCode = (int) (long) responseE.getExtendPointsExpiryResponse().get_return().getLoyaltyApprovalCode();
				
			}else if (MileType.mileTransfer.equals(mileSellProcessDetail.getMileType())) {

				ExtCLMServiceStub.TransferPointsExtResponseE responseE = new ExtCLMServiceStub.TransferPointsExtResponseE();
				ExtCLMServiceStub.TransferPointsExtE paramsE = new ExtCLMServiceStub.TransferPointsExtE();
				ExtCLMServiceStub.TransferPointsExt params = new ExtCLMServiceStub.TransferPointsExt();

				params.setCost(emdPrice.intValue());
				params.setCurrency(mileSellProcessDetail.getEmdCurrency());
				params.setEmd(createEmdDetail.getEmdNumber());
				params.setExternalReferenceID(String.valueOf(approvalCode));
				params.setFromffID(mileSellProcessDetail.getSponsorFFid());
				params.setMile(((Double)mileSellProcessDetail.getEmdPrice()).intValue());
				params.setRequestHeader(convertRequestHeader(requestHeader));
				params.setToffID(mileSellProcessDetail.getTargetFFid());
				
				paramsE.setTransferPointsExt( params );
				
				responseE = stub.transferPointsExt( paramsE );
				
				responseHeader = responseE.getTransferPointsExtResponse().getResponseHeader();
				loyaltyApprovalCode = (int) (long) responseE.getTransferPointsExtResponse().get_return().getLoyaltyApprovalCode();
				
			}else if (MileType.statu.equals(mileSellProcessDetail.getMileType())) {

				ExtCLMServiceStub.PurchaseStatusMilesResponseE responseE = new ExtCLMServiceStub.PurchaseStatusMilesResponseE();
				ExtCLMServiceStub.PurchaseStatusMilesE paramsE = new ExtCLMServiceStub.PurchaseStatusMilesE();
				ExtCLMServiceStub.PurchaseStatusMiles params = new ExtCLMServiceStub.PurchaseStatusMiles();

				params.setCost(emdPrice.intValue());
				params.setCurrency(mileSellProcessDetail.getEmdCurrency());
				params.setEmd(createEmdDetail.getEmdNumber());
				params.setExternalReferenceID(String.valueOf(approvalCode));
				params.setSponsorFFid(mileSellProcessDetail.getSponsorFFid());
				params.setAmount(((Double)mileSellProcessDetail.getEmdPrice()).intValue());
				params.setRequestHeader(convertRequestHeader(requestHeader));
				params.setFfid(mileSellProcessDetail.getTargetFFid());
				params.setMileType(mileSellProcessDetail.getMileType().toString());
				
				paramsE.setPurchaseStatusMiles( params );
				
				responseE = stub.purchaseStatusMiles( paramsE );
				
				responseHeader = responseE.getPurchaseStatusMilesResponse().getResponseHeader();
				loyaltyApprovalCode = (int) (long) responseE.getPurchaseStatusMilesResponse().get_return().getLoyaltyApprovalCode();
				
			}
			
			if ("SUCCESS".equals(String.valueOf(responseHeader.getStatusCode()))) {
				MileProcessTransactionDAO.updateClmApprovalCode(loyaltyApprovalCode, mileProcess.getId());
				mileSellTransactionStatus = MileSellTransactionStatus.COMPLETED;
				mileSellProcessResult.setResultCode("00");
				mileSellProcessResult.setResultDescription("SUCCESS");
			}else {
				mileSellTransactionStatus = MileSellTransactionStatus.FAILED;
				mileSellProcessResult.setResultCode(responseHeader.getMessages()[0].getMessageCode());
				mileSellProcessResult.setResultDescription(responseHeader.getMessages()[0].getLocalizedDescription());
			}
			MileProcessTransactionDAO.updateStatus(mileSellTransactionStatus, mileProcess.getId());

			dbLog.EndStep(Long.toString(loyaltyApprovalCode), mileSellProcessDetail, responseHeader, "CLM com.comarch.clm.thy.api.services called");
			
		} catch (Exception e) {

			MileProcessTransactionDAO.updateStatus(MileSellTransactionStatus.FAILED, mileProcess.getId());
			
			mileSellProcessResult.setResultCode("99");
			mileSellProcessResult.setResultDescription(StringUtils.stack2string(e));
			dbLog.InsertComment("Exception : "+ StringUtils.stack2string(e));
		}
		
		return mileSellProcessResult;
	}

	@Override
	public UndoMileSellProcessResult undoMileSellProcess(RequestHeader requestHeader,UndoMileSellProcessDetail undoMileSellProcessDetail, DBLogRecord dbLog) {

		dbLog.InsertComment("undoMileSellProcess has started");
		
		UndoMileSellProcessResult undoMileSellProcessResult = new UndoMileSellProcessResult();
		
		try {

			ResponseHeader responseHeader = null;
			
			ExtCLMServiceStub stub = new ExtCLMServiceStub();
			
			stub._getServiceClient().getAxisService().setEndpointURL(WsConfig.getInstance().CLM_SERVICE_ENDPOINT);
			
			if (!Utils.isEmptyString(WsConfig.getInstance().EMDSERVICE_TIMEOUT_IN_SECS)){
				stub._getServiceClient().getOptions().setProperty("weblogic.webservice.rpc.timeoutsecs",
						WsConfig.getInstance().EMDSERVICE_TIMEOUT_IN_SECS);
			}

			if ("FIREWALL".equals(WsConfig.getInstance().SERVICE_ACCESS_TYPE)) {

				HttpTransportProperties.Authenticator basicAuthentication  = new HttpTransportProperties. Authenticator ( ) ;
				basicAuthentication.setUsername ( WsConfig.getInstance().FIREWALL_USERNAME ) ;
				basicAuthentication.setPassword ( WsConfig.getInstance().FIREWALL_PASSWORD ) ;
				stub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, basicAuthentication );
				stub._getServiceClient().getOptions().setProperty("username", WsConfig.getInstance().FIREWALL_USERNAME );
				stub._getServiceClient().getOptions().setProperty("password", WsConfig.getInstance().FIREWALL_PASSWORD );
				stub._getServiceClient().getOptions().setProperty (org. apache. axis2. transport. http. HTTPConstants. CHUNKED,  Boolean. FALSE ) ;
			}

			requestHeader.setClientCode(WsConfig.getInstance().CLM_CLIENT_CODE);
			requestHeader.setClientUsername(WsConfig.getInstance().CLM_CLIENT_USERNAME);
//			requestHeader.setLanguageCode(LanguageCodeType.ENGLISH);
			requestHeader.setChannel(com.thy.ws.header.request.ChannelType.WEB);
			
			List<MileProcessTransaction> listMileProcessTransaction = MileProcessTransactionDAO.getMileProcessTransactionList( undoMileSellProcessDetail.getNphaseID());
			//for kalkacak
			for (MileProcessTransaction mileProcessTransaction : listMileProcessTransaction) {

				ExtCLMServiceStub.ReverseTransactionExtResponseE responseE = new ExtCLMServiceStub.ReverseTransactionExtResponseE();
				ExtCLMServiceStub.ReverseTransactionExtE paramsE = new ExtCLMServiceStub.ReverseTransactionExtE();
				ExtCLMServiceStub.ReverseTransactionExt params = new ExtCLMServiceStub.ReverseTransactionExt();
				
				params.setTransactionId((long) mileProcessTransaction.getClmApprovalCode());
				params.setRequestHeader(convertRequestHeader(requestHeader));
				
				paramsE.setReverseTransactionExt( params );
				
				responseE = stub.reverseTransactionExt( paramsE );
				
				responseHeader = responseE.getReverseTransactionExtResponse().getResponseHeader();
				
				dbLog.InsertComment("reverseTransactionExt has returned",mileProcessTransaction,responseHeader.getStatusCode());
				//TODO : CreateEmd nin undosu çaðrýlacak
				
				MileProcessTransactionDAO.updateStatus(MileSellTransactionStatus.ROLLBACK, mileProcessTransaction.getId());
			}
			
			if (listMileProcessTransaction==null||listMileProcessTransaction.size()==0) {
				dbLog.InsertComment("No record has found for nphaseID :"+undoMileSellProcessDetail.getNphaseID());
				
				undoMileSellProcessResult.setResultCode("01");
				undoMileSellProcessResult.setResultDescription("No record has found for nphaseID :"+undoMileSellProcessDetail.getNphaseID());
			}
		} catch (Exception e) {
			
			undoMileSellProcessResult.setResultCode("09");
			undoMileSellProcessResult.setResultDescription("ERROR");
			
			dbLog.InsertComment("Exception : "+ StringUtils.stack2string(e));
			
			e.printStackTrace();
		}

		dbLog.InsertComment("undoMileSellProcess has finished");
		
		undoMileSellProcessResult.setResultCode("00");
		undoMileSellProcessResult.setResultDescription("SUCCESS");
		
		return undoMileSellProcessResult;
	}

	private Map<String, String> controlMemberDetails(String languageCode, Member member, DBLogRecord dbLog) {

		Map<String, String> result = new HashMap<String, String>();
		
		GetMemberDetailsResult memberDetailRes = new GetMemberDetailsResult();
		try {
			memberDetailRes = MemberDetailsDAO.getMemberDetails(languageCode, member.getMemberId() );
		} catch (Exception e) {
			logger.error("Error in nonAirIssueAwardWithToken in getMemberDetails method "
					+ StringUtils.stack2string(e));
			
			result.put("RETURN_CODE", "09");
			result.put("RETURN_TEXT", StringUtils.stack2string(e));
		}

		if (memberDetailRes.getMemberDataKVPair() != null) {

			for(MsKeyValuePairW3 item : memberDetailRes.getMemberDataKVPair())
			{
				if("D_OUT_NAME".equals(item.getKey())||"D_OUT_SURNAME".equals(item.getKey())){
					if(item.getValue().contains("?") 
					|| item.getValue().contains("-") 
					|| item.getValue().contains(".") 
					|| item.getValue().contains("(") 
					|| item.getValue().contains(")") 
					|| item.getValue().contains("/") 
					|| item.getValue().contains("*") 
					|| item.getValue().contains("+") 
					|| item.getValue().contains("!") 
					|| item.getValue().contains("_") ){

						result.put("RETURN_CODE", "09");
						result.put("RETURN_TEXT", "Invaild char in name or surname");
						
						return result;
					}
				}
				
				if ("D_OUT_SEX".equals(item.getKey())) {
					member.setMemberSex(item.getValue());
				}
				if ("D_OUT_IDENTITY_CARD_NO".equals(item.getKey())) {
					member.setMemberIdentityCardNo(item.getValue());
				}
				if ("D_OUT_PRIMARY_EMAIL_ADDR".equals(item.getKey())) {
					member.setMemberPrimaryEmailAdress(item.getValue());
				}
				if ("D_OUT_NAME".equals(item.getKey())) {
					member.setMemberName(item.getValue());
				}
				if ("D_OUT_SURNAME".equals(item.getKey())) {
					member.setMemberSurname(item.getValue());
				}
			}
		}
		return result;
	}

	private com.comarch.clm.thy.api.services.ExtCLMServiceStub.RequestHeader convertRequestHeader( com.thy.ws.header.request.RequestHeader inRequestHeader){
		com.comarch.clm.thy.api.services.ExtCLMServiceStub.RequestHeader outRequestHeader = new com.comarch.clm.thy.api.services.ExtCLMServiceStub.RequestHeader();
		
		outRequestHeader.setAgencyCode(inRequestHeader.getAgencyCode());
		outRequestHeader.setAgencyOfficeCode(inRequestHeader.getAgencyOfficeCode());
		outRequestHeader.setAgencySubCode(inRequestHeader.getAgencySubCode());
		outRequestHeader.setAgent(inRequestHeader.getAgent());
		outRequestHeader.setAirlineCode(inRequestHeader.getAirlineCode());
		outRequestHeader.setApplication(inRequestHeader.getApplication());
		outRequestHeader.setChannel(ChannelType.WEB);
		outRequestHeader.setClientCode(inRequestHeader.getClientCode());
		outRequestHeader.setClientTransactionId(inRequestHeader.getClientTransactionId());
		outRequestHeader.setClientUsername(inRequestHeader.getClientUsername());
		outRequestHeader.setCurrency(inRequestHeader.getCurrency());
		outRequestHeader.setDutyCode(inRequestHeader.getDutyCode());
//		outRequestHeader.setLanguageCode(inRequestHeader.getLanguageCode().toString());
		outRequestHeader.setTon(inRequestHeader.getTon());
//		outRequestHeader.setUserAgencyCode(inRequestHeader.getUserAgencyCode());
		outRequestHeader.setUserAgencyCode("XX");

		ParamType[] par = new ParamType[1];
		par[0] = new ParamType();
		par[0].setKey(WsConfig.getInstance().EMDSERVICE_EXTRAPARAMETER_KEY);
		par[0].setValue(WsConfig.getInstance().EMDSERVICE_EXTRAPARAMETER_VALUE);

		outRequestHeader.setExtraParameters(par);
		
		return outRequestHeader;
	}
}
*/
