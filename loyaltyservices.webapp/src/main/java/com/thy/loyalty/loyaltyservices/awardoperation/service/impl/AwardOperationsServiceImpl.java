package com.thy.loyalty.loyaltyservices.awardoperation.service.impl;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jforce.connectors.oracle.Connector;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.CheckMemberOperationToken;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.NonAirIssueAwardRes;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.NonAirIssueAwardWithOrderIDDetail;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.NonAirIssueAwardWithOrderIDResult;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.NonAirIssueAwardWithTokenDetail;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.NonAirIssueAwardWithTokenResult;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.OnlineShoppingGetTokenIDDetail;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.OnlineShoppingGetTokenIDResult;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.TokenDetail;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.TokenResult;
import com.thy.loyalty.loyaltyservices.awardoperation.service.IAwardOperationsService;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.CheckOrderIDDetail;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.CheckOrderIDResult;
import com.thy.loyalty.loyaltyservices.mileredemption.service.impl.MemberDetailsDAO;
import com.thy.loyalty.loyaltyservices.mileredemption.service.impl.MileRedemptionGatewayServiceImpl;
import com.thy.loyalty.ms.config.CraneDButils;
import com.thy.loyalty.ms.config.CraneDb;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.loyalty.ms.ws.w3.GetMemberDetailsResult;
import com.thy.loyalty.ms.ws.w3.MemberLoginDetails;
import com.thy.loyalty.ms.ws.w3.MemberLoginW3Result;
import com.thy.loyalty.ms.ws.w3.MsKeyValuePairW3;
import com.thy.ws.header.request.ChannelType;
import com.thy.ws.header.request.LanguageCodeType;

@Service
public class AwardOperationsServiceImpl implements IAwardOperationsService {

	private static Log logger = LogFactory
			.getLog(AwardOperationsServiceImpl.class);

	@Override
	public NonAirIssueAwardWithOrderIDResult nonAirIssueAwardWithOrderID(
			String clientCode,
			String clientUserName,
			String channel,
			String airlineCode,
			String application,
			String agencyCode,
			String agent,
			String language,
			NonAirIssueAwardWithOrderIDDetail nonAirIssueAwardWithOrderIDDetail)
					throws Exception {

		NonAirIssueAwardWithOrderIDResult nonAirIssueAwardWithOrderIDResult = new NonAirIssueAwardWithOrderIDResult();

		NonAirIssueAwardRes result = new NonAirIssueAwardRes();

		MileRedemptionGatewayServiceImpl mrg = new MileRedemptionGatewayServiceImpl();

		CheckOrderIDDetail checkOrderIDDetail = new CheckOrderIDDetail();

		checkOrderIDDetail.setOrderID(nonAirIssueAwardWithOrderIDDetail
				.getOrderID());
		checkOrderIDDetail.setOperationCode(nonAirIssueAwardWithOrderIDDetail
				.getOperationCode());
		checkOrderIDDetail
		.setRedemMiles((int) nonAirIssueAwardWithOrderIDDetail
				.getQuantity());

		com.thy.ws.header.request.RequestHeader req = new com.thy.ws.header.request.RequestHeader();
		req.setClientCode(clientCode);
		req.setClientUsername(clientUserName);
		req.setChannel(ChannelType.valueOf(channel));
		req.setAirlineCode(airlineCode);
		req.setApplication(application);
		req.setAgencyCode(agencyCode);

		for(LanguageCodeType item : LanguageCodeType.values())
		{
			if(item.value().equals(language)){
				req.setLanguageCode(item);
			}
		}

		CheckOrderIDResult checkOrderIDResult = mrg.CheckOrderID(req,
				checkOrderIDDetail);

		if (StringUtils.handleNullString(checkOrderIDResult.getResultCode())
				.equalsIgnoreCase("00")) {

			// TODO:nkaplan Comarch Servisinin methodu çaðýrýlacak
			result = MileRedemptionDAO.nonAirIssueAward(channel,
					airlineCode,
					application,
					agencyCode,
					language,
					nonAirIssueAwardWithOrderIDDetail);
			//			nonAirIssueAwardResult.setApprovalCode(result.getApprovalCode());
			//			nonAirIssueAwardResult.setRedeemedMiles(result.getRedeemedMiles());
			//			nonAirIssueAwardResult.setResultCode("");
			//			nonAirIssueAwardResult.setResultDescription("");

			if (result == null || result.getResultCode() == null) {
				nonAirIssueAwardWithOrderIDResult.setResultCode("99");
				nonAirIssueAwardWithOrderIDResult.setResultDescription("Error in nonAirIssueAward ResultCode null");
			} else {
				nonAirIssueAwardWithOrderIDResult.setResultCode(result.getResultCode());
				nonAirIssueAwardWithOrderIDResult.setResultDescription(result.getResultDescription());
			}

		} else {
			nonAirIssueAwardWithOrderIDResult.setResultCode(checkOrderIDResult.getResultCode());
			nonAirIssueAwardWithOrderIDResult.setResultDescription(checkOrderIDResult.getResultDescription());
		}

		nonAirIssueAwardWithOrderIDResult.setNonAirIssueAwardResult(result.getNonAirIssueAwardResult());

		return nonAirIssueAwardWithOrderIDResult;
	}

	@Override
	public NonAirIssueAwardWithTokenResult nonAirIssueAwardWithToken(
			String clientCode,
			String clientUserName,
			String channel,
			String airlineCode,
			String application,
			String agencyCode,
			String agent,
			String language,
			NonAirIssueAwardWithTokenDetail nonAirIssueAwardWithTokenDetail) {

		String serviceName = "msCheckOperations";
		String methodName = "nonAirIssueAwardWithToken";
		NonAirIssueAwardWithTokenResult result = new NonAirIssueAwardWithTokenResult();

		NonAirIssueAwardRes res = new NonAirIssueAwardRes();

		TokenDetail tokenDetail = new TokenDetail();
		tokenDetail.setMemberID(nonAirIssueAwardWithTokenDetail.getMemberId());
		tokenDetail.setOperationName("ONLINE_SHOPPING");
		tokenDetail.setToken(nonAirIssueAwardWithTokenDetail.getToken());

		// member control
		GetMemberDetailsResult memberDetailRes = new GetMemberDetailsResult();
		try {
			memberDetailRes = MemberDetailsDAO.getMemberDetails(language,
					nonAirIssueAwardWithTokenDetail.getMemberId());
		} catch (Exception e) {
			logger.error("Error in nonAirIssueAwardWithToken in getMemberDetails method "
					+ StringUtils.stack2string(e));
		}

		if (memberDetailRes.getMemberDataKVPair() != null) {
			
			com.thy.ws.header.request.RequestHeader req = new com.thy.ws.header.request.RequestHeader();
			req.setClientCode(clientCode);
			req.setClientUsername(clientUserName);
			req.setChannel(ChannelType.valueOf(channel));
			req.setAirlineCode(airlineCode);
			req.setApplication(application);
			req.setAgencyCode(agencyCode);
			for(LanguageCodeType item : LanguageCodeType.values())
			{
				if(item.value().equals(language)){
					req.setLanguageCode(item);
				}
			}
			

			TokenResult tokenResult = CheckMemberOperationToken.checkToken(
					req, tokenDetail);

			if (StringUtils.handleNullString(tokenResult.getResultCode())
					.equalsIgnoreCase("00")) {
				// TODO:nkaplan Comarch servisi çaðýrýlacak
				try {
					res = MileRedemptionDAO
							.nonAirIssueAward(channel,
									airlineCode,
									application,
									agencyCode,
									language,
									nonAirIssueAwardWithTokenDetail);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error("Error in nonAirIssueAwardWithToken in getMemberDetails method "
							+ StringUtils.stack2string(e));
				}
				
				result.setResultCode(res.getResultCode());
				result.setResultDescription(res.getResultDescription());

			} else {
				result.setResultCode(tokenResult.getResultCode());
				result.setResultDescription(tokenResult.getResultDescription());
			}

			result.setNonAirIssueAwardResult(res.getNonAirIssueAwardResult());
		} else {
			// TODO NOT TK member error 11
			result.setResultCode("11");
			result.setResultDescription(CraneDButils.getResultMessage(
					result.getResultCode(), serviceName, methodName,
					language));
		}

		return result;
	}

	@Override
	public OnlineShoppingGetTokenIDResult OnlineShoppingGetTokenID(
			String clientCode,
			String clientUserName,
			String channel,
			String airlineCode,
			String application,
			String agencyCode,
			String agent,
			String language,
			OnlineShoppingGetTokenIDDetail detail) {

		String serviceName = "msCheckOperations";
		String methodName = "OnlineShoppingGetTokenID";

		OnlineShoppingGetTokenIDResult result = new OnlineShoppingGetTokenIDResult();
		String status = null; // D_OUT_STATUS_CODE
		String tier = null; // D_OUT_CARD_TYPE
		int totalMiles = 0; // D_OUT_TOTAL_MILES

		// member control
		GetMemberDetailsResult memberDetailRes = new GetMemberDetailsResult();
		try {
			memberDetailRes = MemberDetailsDAO.getMemberDetails(language, detail.getMemberID());
		} catch (Exception e) {
			logger.error("Error in nonAirIssueAwardWithToken in getMemberDetails method "
					+ StringUtils.stack2string(e));
		}

		if (memberDetailRes.getMemberDataKVPair() != null && memberDetailRes.getMemberDataKVPair().size() != 0) {

			for (MsKeyValuePairW3 item : memberDetailRes.getMemberDataKVPair()) {
				if(item.getKey().equals("D_OUT_STATUS_CODE"))
				{
					status = item.getValue();
				}
				if(item.getKey().equals("D_OUT_CARD_TYPE") )
				{
					tier = item.getValue();
				}			
				if(item.getKey().equals("D_OUT_TOTAL_MILES"))
				{
					totalMiles = Integer.parseInt(item.getValue());
				}
			}

			MemberLoginW3Result memberLoginRes = new MemberLoginW3Result();
			MemberLoginDetails memberLoginDetail = new MemberLoginDetails();
			memberLoginDetail.setMemberId(detail.getMemberID());
			memberLoginDetail.setPinNumber(detail.getPinCode());
			memberLoginDetail.setLoginChannel("1");
			memberLoginDetail.setLoginText(detail.getMemberID());

			try {
				memberLoginRes = MemberDetailsDAO.memberLogin(
						memberLoginDetail, language);
			} catch (Exception e) {
				logger.error("Error in nonAirIssueAwardWithToken in memberLogin method "
						+ StringUtils.stack2string(e));
			}
			
			if ("T".equals(memberLoginRes.getIsLoginPossible())) {

				Connector con = null;
				java.sql.CallableStatement cs = null;

				try {

					con = CraneDb.getConnection();

					String query = "begin  "
							+ "ls_pack_esb_check.create_operation_token(i_v_partner_code 			=> ?,"
							+ "i_v_partner_user_name 		=> ?,"
							+ "i_v_partner_password 		=> ?,"
							+ "i_v_ip_address 			=> ?,"
							+ "i_v_channel_code 			=> ?,"
							+ "i_v_airline_code 			=> ?,"
							+ "i_v_application 			=> ?,"
							+ "i_v_agent 					=> ?," 
							+ "i_v_language 				=> ?,"
							+ "o_v_response_code 			=> ?,"
							+ "o_v_response_description 	=> ?,"
							+ "i_v_member_id 				=> ?," // 12
							+ "i_v_member_pin 		    => ?," // 13
							+ "i_v_operation_code 		=> ?," // 14

							+ "o_v_token 						=> ?," // 15
							+ "o_n_expiration_time_minute 	=> ?" + // 16
							// "o_v_member_status 		        => ?," + // 17
							// "o_v_member_validation_status 	=> ?," + // 18
							// "o_n_member_total_miles 		=> ?," + // 19
							// "o_v_member_tier 		        => ?" + // 20
							");" + "end;";

					cs = con.prepareCall(query);

					cs.setString(1, clientCode);
					cs.setString(2, clientUserName);
					cs.setString(3, "");
					cs.setString(4, "");

					cs.setString(5, channel);
					cs.setString(6, airlineCode);
					cs.setString(7, application);
					cs.setString(8, agent);
					cs.setString(9, language);
					//cs.setString(9, Utils.validateRequestLanguage(requestHeader
					//		.getLanguageCode()));

					// Web service main response
					cs.registerOutParameter(10, java.sql.Types.VARCHAR); // O_V_RESPONSE_CODE
					cs.registerOutParameter(11, java.sql.Types.VARCHAR); // O_V_RESPONSE_DESCRIPTION

					cs.setString(12, detail.getMemberID());
					cs.setString(13, detail.getPinCode());
					cs.setString(14, detail.getOperationCode());

					cs.registerOutParameter(15, java.sql.Types.VARCHAR); // o_v_token
					cs.registerOutParameter(16, java.sql.Types.NUMERIC); // o_n_expiration_time_minute

					con.getData(cs);

					result.setResultCode(cs.getString(10));
					result.setResultDescription(cs.getString(11));

					result.setToken(cs.getString(15));
					result.setTokenExpireMinute(cs.getInt(16));
					result.setMemberStatus(status);
					// TODO: nkaplan Validation status should be set to result
					// result.setValidationStatus(cs.getString(18));
					result.setTotalMiles(totalMiles);
					result.setTier(tier);

				} catch (Exception e) {
					logger.error("Error in ls_pack_esb_check.create_operation_token "
							+ StringUtils.stack2string(e));
					// System.out.println(StringUtils.stack2string(e));
				} finally {
					try {
						cs.close();

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						logger.error("Error in ls_pack_esb_check.create_operation_token procedure (SQLException) "
								+ StringUtils.stack2string(e));
					}
					con.disconnectDB();
				}
			} else {
				// TODO TK could not login error
				result.setToken(null);
				result.setTokenExpireMinute(0);
				result.setMemberStatus(null);
				result.setValidationStatus(null);
			}
		} else {
			// TODO NOT TK member error
			result.setResultCode("11");
			result.setResultDescription(CraneDButils.getResultMessage(
					result.getResultCode(), serviceName, methodName,
					language));
		}

		return result;
	}

}
