package com.thy.loyalty.loyaltyservices.mileredemption.service.impl;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.springframework.stereotype.Service;

import com.jforce.connectors.oracle.Connector;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.CheckOrderIDDetail;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.CheckOrderIDResult;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.GetOrderIDDetail;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.GetOrderIDResult;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.GetParametersDetail;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.GetParametersResult;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.KeyValue;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.MrglogDetail;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.MrglogResult;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.OrderValuesDetail;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.OrderValuesResult;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.Parameter;
import com.thy.loyalty.loyaltyservices.mileredemption.service.IMileRedemptionGatewayService;
import com.thy.loyalty.loyaltyservices.ws.common.CommonJava;
import com.thy.loyalty.ms.config.CraneDButils;
import com.thy.loyalty.ms.config.CraneDb;
import com.thy.loyalty.ms.ws.w3.GetMemberDetailsResult;
import com.thy.loyalty.ms.ws.w3.MsKeyValuePairW3;
import com.thy.ws.header.request.RequestHeader;

@Service
public class MileRedemptionGatewayServiceImpl implements
		IMileRedemptionGatewayService {

	private static String mrgCode = "MRG";

	@Override
	public GetOrderIDResult GetOrderID(RequestHeader requestHeader,
			GetOrderIDDetail getOrderIDDetail) throws Exception {

		String serviceName = "msMrgOperations";
		String methodName = "GetOrderID";

		GetOrderIDResult getOrderIDResult = new GetOrderIDResult();

		// GetMemberDetail will be called to get member information
		// control member profile informations
		// InSufficientMiles control will be done here

		GetMemberDetailsResult memberDetailRes = new GetMemberDetailsResult();
		memberDetailRes = MemberDetailsDAO.getMemberDetails(requestHeader
				.getLanguageCode().toString(), getOrderIDDetail.getMemberID());

		if (memberDetailRes.getMemberDataKVPair().size() > 0) {
			for (MsKeyValuePairW3 item : memberDetailRes.getMemberDataKVPair()) {
				if (item.getKey().equals("D_OUT_TOTAL_MILES")) {
					if (getOrderIDDetail.getMiles() > Integer.parseInt(item
							.getValue())) {
						// TODO: insufficient miles error
						getOrderIDResult.setResultCode("12");
						getOrderIDResult.setResultDescription(CraneDButils
								.getResultMessage(getOrderIDResult
										.getResultCode(), serviceName,
										methodName, requestHeader
												.getLanguageCode().toString()));
						return getOrderIDResult;
					}
					break;
				}
			}

			Connector con = null;
			CallableStatement cs = null;

			String ClinetIPAddress = "";

			try {

				// get client IP address
				ClinetIPAddress = CommonJava
						.getClientRequestIdFromRequestHeader(requestHeader);
				// /////////////////////

				con = CraneDb.getConnection();
				String sql = "BEGIN p_esb_mile_redemption_gateway.get_order_id(?,"
						+ // 1
							// i_v_partner_code
							// =>
						"?," + // 2 i_v_username =>
						"?," + // 3 i_v_partner_password =>
						"?," + // 4 i_v_ip_address =>
						"?," + // 5 i_v_channel_code =>
						"?," + // 6 i_v_airline_code =>
						"?," + // 7 i_v_application =>
						"?," + // 8 i_v_agent =>
						"?," + // 9 i_v_language =>

						"?," + // 10 o_v_response_code =>
						"?," + // 11 o_v_response_description =>

						"?," + // 12 i_v_client_transaction_id
						"?," + // 13 i_v_operation_code
						"?," + // 14 i_v_member_id
						"?," + // 15 i_v_miles
						"?," + // 16 i_v_success_url

						"?," + // 17 o_v_order_id
						"?" + // 18 o_v_is_member_verify_otp_once

						"); " + "END;";
				cs = con.prepareCall(sql);

				// service base input parameters
				cs.setString(1, requestHeader.getClientCode()); // 1
																// i_v_partner_code
																// =>
				cs.setString(2, requestHeader.getClientUsername()); // 2
																	// i_v_username
																	// =>
				cs.setString(3, ""); // 3 i_v_partner_password =>
				cs.setString(4, ClinetIPAddress); // 4 i_v_ip_address =>
				cs.setString(5, requestHeader.getChannel().value()); // 5
																		// i_v_channel_code
																		// =>
				cs.setString(6, requestHeader.getAirlineCode()); // 6
																	// i_v_airline_code
																	// =>
				cs.setString(7, requestHeader.getApplication()); // 7
																	// i_v_application
																	// =>
				cs.setString(8, requestHeader.getAgencyCode()); // 8 i_v_agent
																// =>
				cs.setString(9, requestHeader.getLanguageCode().value()); // 9
																			// i_v_language
																			// =>
				// //////////////////////////////

				// service base output parameters
				cs.registerOutParameter(10, java.sql.Types.VARCHAR); // 10
																		// o_v_response_code
																		// =>
				cs.registerOutParameter(11, java.sql.Types.VARCHAR); // 11
																		// o_v_response_description
																		// =>
				// ///////////////////////////////

				// business input parameters
				cs.setString(12, requestHeader.getClientTransactionId()); // 12
																			// i_v_client_transaction_id
				cs.setString(13, getOrderIDDetail.getOperationCode()); // 13
																		// i_v_operation_code
				cs.setString(14, getOrderIDDetail.getMemberID()); // 14
																	// i_v_member_id
				cs.setInt(15, getOrderIDDetail.getMiles()); // 15 i_v_miles
				cs.setString(16, getOrderIDDetail.getSuccessURL()); // 14
																	// i_v_success_url
				// //////////////////////////

				// business output parameters
				cs.registerOutParameter(17, java.sql.Types.VARCHAR); // 17
																		// o_v_order_id
				cs.registerOutParameter(18, java.sql.Types.VARCHAR); // 18
																		// o_v_is_member_verify_otp_once
				// ///////////////////////////

				con.getData(cs);

				getOrderIDResult.setOrderID(cs.getString(17));
				getOrderIDResult.setMemberVerifyOtpOnce(cs.getString(18));

				getOrderIDResult.setResultCode(cs.getString(10));
				getOrderIDResult.setResultDescription(cs.getString(11));

			} catch (Exception e) {
				throw e;
			} finally {

				if (cs != null)
					cs.close();

				con.disconnectDB();
			}
		} else {
			// TODO: not TK member error
			getOrderIDResult.setResultCode("11");
			getOrderIDResult.setResultDescription(CraneDButils
					.getResultMessage(getOrderIDResult.getResultCode(),
							serviceName, methodName, requestHeader
									.getLanguageCode().toString()));
		}

		return getOrderIDResult;
	}

	@Override
	public GetParametersResult getParameters(RequestHeader requestHeader,
			GetParametersDetail getParametersDetail) throws Exception {

		GetParametersResult getParametersResult = new GetParametersResult();
		ArrayList<Parameter> parameterList = new ArrayList<Parameter>();

		Connector con = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		try {

			con = CraneDb.getConnection();
			String sql = "BEGIN p_parameter.get_parameters(?," + // 1
																	// i_v_group_code
					"?," + // 2 i_v_indicator
					"?" + // 3 o_c_parameters
					"); " + "END;";
			cs = con.prepareCall(sql);

			// business input parameters
			cs.setString(1, getParametersDetail.getGroupCode()); // 1
																	// i_v_group_code
			cs.setString(2, getParametersDetail.getIndicator()); // 2
																	// i_v_indicator
			// //////////////////////////

			// business output parameters
			cs.registerOutParameter(3, OracleTypes.CURSOR); // 3 o_c_parameters
			// ///////////////////////////

			con.getData(cs);

			rs = (ResultSet) cs.getObject(3);

			while (rs.next()) {
				Parameter param = new Parameter();
				param.setId(rs.getInt("id"));
				param.setGroupCode(rs.getString("group_code"));
				param.setIndicator(rs.getString("indicator"));
				param.setKey(rs.getString("key"));
				param.setValue(rs.getString("VALUE"));
				param.setDefinition(rs.getString("definition"));

				parameterList.add(param);
			}

			getParametersResult.setParameterList(parameterList);

			getParametersResult.setResultCode("00");
			getParametersResult.setResultDescription("SUCCESS");

		} catch (Exception e) {
			throw e;
		} finally {

			if (cs != null)
				cs.close();

			con.disconnectDB();
		}

		return getParametersResult;
	}

	@Override
	public OrderValuesResult OrderValues(RequestHeader requestHeader,
			OrderValuesDetail orderValuesDetail) throws Exception {

		OrderValuesResult orderValuesResult = new OrderValuesResult();

		ArrayList<KeyValue> orderValues = new ArrayList<KeyValue>();

		Connector con = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		String ClinetIPAddress = "";

		try {

			// get client IP address
			ClinetIPAddress = CommonJava
					.getClientRequestIdFromRequestHeader(requestHeader);
			// /////////////////////

			con = CraneDb.getConnection();
			String sql = "BEGIN p_esb_mile_redemption_gateway.get_order_id_detail(?,"
					+ // 1 i_v_partner_code =>
					"?," + // 2 i_v_username =>
					"?," + // 3 i_v_partner_password =>
					"?," + // 4 i_v_ip_address =>
					"?," + // 5 i_v_channel_code =>
					"?," + // 6 i_v_airline_code =>
					"?," + // 7 i_v_application =>
					"?," + // 8 i_v_agent =>
					"?," + // 9 i_v_language =>

					"?," + // 10 o_v_response_code =>
					"?," + // 11 o_v_response_description =>

					"?," + // 12 i_v_order_id

					"?" + // 13 o_c_order_id_detail

					"); " + "END;";
			cs = con.prepareCall(sql);

			// service base input parameters
			cs.setString(1, requestHeader.getClientCode()); // 1
															// i_v_partner_code
															// =>
			cs.setString(2, requestHeader.getClientUsername()); // 2
																// i_v_username
																// =>
			cs.setString(3, ""); // 3 i_v_partner_password =>
			cs.setString(4, ClinetIPAddress); // 4 i_v_ip_address =>
			cs.setString(5, requestHeader.getChannel().value()); // 5
																	// i_v_channel_code
																	// =>
			cs.setString(6, requestHeader.getAirlineCode()); // 6
																// i_v_airline_code
																// =>
			cs.setString(7, requestHeader.getApplication()); // 7
																// i_v_application
																// =>
			cs.setString(8, requestHeader.getAgencyCode()); // 8 i_v_agent =>
			cs.setString(9, requestHeader.getLanguageCode().value()); // 9
																		// i_v_language
																		// =>
			// //////////////////////////////

			// service base output parameters
			cs.registerOutParameter(10, java.sql.Types.VARCHAR); // 10
																	// o_v_response_code
																	// =>
			cs.registerOutParameter(11, java.sql.Types.VARCHAR); // 11
																	// o_v_response_description
																	// =>
			// ///////////////////////////////

			// business input parameters
			cs.setString(12, orderValuesDetail.getOrderID()); // 12 i_v_order_id
			// //////////////////////////

			// business output parameters
			cs.registerOutParameter(13, OracleTypes.CURSOR);
			// ///////////////////////////

			con.getData(cs);

			rs = (ResultSet) cs.getObject(13);

			String oidPartnerCode = "";

			if (rs != null) {
				while (rs.next()) {
					KeyValue param = new KeyValue();

					param.setKey(rs.getString("key"));
					param.setValue(rs.getString("VALUE"));

					orderValues.add(param);

					if (rs.getString("key").equalsIgnoreCase("PARTNER_CODE"))
						oidPartnerCode = rs.getString("VALUE");
				}
			}

			orderValuesResult.setOrderIdValues(orderValues);

			// Get Partner MRG Parameters
			GetParametersDetail getParametersDetail = new GetParametersDetail();
			getParametersDetail.setGroupCode(mrgCode);
			getParametersDetail.setIndicator(oidPartnerCode);

			GetParametersResult result = getParameters(requestHeader,
					getParametersDetail);

			orderValuesResult
					.setPartnerParameterList(result.getParameterList());
			// ///////////////////////////

			orderValuesResult.setResultCode(cs.getString(10));
			orderValuesResult.setResultDescription(cs.getString(11));

		} catch (Exception e) {
			throw e;
		} finally {

			if (cs != null)
				cs.close();

			con.disconnectDB();
		}

		return orderValuesResult;
	}

	@Override
	public MrglogResult Mrglog(RequestHeader requestHeader,
			MrglogDetail mrglogDetail) throws Exception {

		MrglogResult mrglogResult = new MrglogResult();

		Connector con = null;
		CallableStatement cs = null;

		try {
			con = CraneDb.getConnection();
			String sql = "BEGIN p_mile_redemption_gateway.insert_mrg_detail(?,"
					+ // 1 i_n_operation_id
					"?," + // 2 i_v_operation_code
					"?," + // 3 i_v_client_transaction_id
					"?" + // 4 i_v_log
					"); " + "END;";
			cs = con.prepareCall(sql);

			// business input parameters
			cs.setInt(1, mrglogDetail.getOperation_id()); // 1 i_n_operation_id
			cs.setString(2, mrglogDetail.getOperation_code()); // 2
																// i_v_operation_code
			cs.setString(3, mrglogDetail.getClientTransactionId()); // 3
																	// i_v_client_transaction_id
			cs.setString(4, mrglogDetail.getLog()); // 4 i_v_log
			// //////////////////////////

			con.getData(cs);

			mrglogResult.setResultCode("00");
			mrglogResult.setResultDescription("SUCCESS");

		} catch (Exception e) {
			throw e;
		} finally {

			if (cs != null)
				cs.close();

			con.disconnectDB();
		}

		return mrglogResult;
	}

	@Override
	public CheckOrderIDResult CheckOrderID(RequestHeader requestHeader,
			CheckOrderIDDetail checkOrderIDDetail) throws Exception {

		CheckOrderIDResult checkOrderIDResult = new CheckOrderIDResult();

		Connector con = null;
		CallableStatement cs = null;

		String ClinetIPAddress = "";

		try {

			// get client IP address
			ClinetIPAddress = CommonJava
					.getClientRequestIdFromRequestHeader(requestHeader);
			// /////////////////////

			con = CraneDb.getConnection();
			String sql = "BEGIN p_esb_mile_redemption_gateway.check_order_id(?,"
					+ // 1 i_v_partner_code =>
					"?," + // 2 i_v_username =>
					"?," + // 3 i_v_partner_password =>
					"?," + // 4 i_v_ip_address =>
					"?," + // 5 i_v_channel_code =>
					"?," + // 6 i_v_airline_code =>
					"?," + // 7 i_v_application =>
					"?," + // 8 i_v_agent =>
					"?," + // 9 i_v_language =>

					"?," + // 10 o_v_response_code =>
					"?," + // 11 o_v_response_description =>

					"?," + // 12 i_v_order_id
					"?," + // 13 i_n_redem_miles
					"?" + // 14 i_v_operation_code

					"); " + "END;";
			cs = con.prepareCall(sql);

			// service base input parameters
			cs.setString(1, requestHeader.getClientCode()); // 1
															// i_v_partner_code
															// =>
			cs.setString(2, requestHeader.getClientUsername()); // 2
																// i_v_username
																// =>
			cs.setString(3, ""); // 3 i_v_partner_password =>
			cs.setString(4, ClinetIPAddress); // 4 i_v_ip_address =>
			cs.setString(5, requestHeader.getChannel().value()); // 5
																	// i_v_channel_code
																	// =>
			cs.setString(6, requestHeader.getAirlineCode()); // 6
																// i_v_airline_code
																// =>
			cs.setString(7, requestHeader.getApplication()); // 7
																// i_v_application
																// =>
			cs.setString(8, requestHeader.getAgencyCode()); // 8 i_v_agent =>
			cs.setString(9, requestHeader.getLanguageCode().value()); // 9
																		// i_v_language
																		// =>
			// //////////////////////////////

			// service base output parameters
			cs.registerOutParameter(10, java.sql.Types.VARCHAR); // 10
																	// o_v_response_code
																	// =>
			cs.registerOutParameter(11, java.sql.Types.VARCHAR); // 11
																	// o_v_response_description
																	// =>
			// ///////////////////////////////

			// business input parameters
			cs.setString(12, checkOrderIDDetail.getOrderID()); // 12
																// i_v_order_id
			cs.setInt(13, checkOrderIDDetail.getRedemMiles()); // 13
																// i_n_redem_miles
			cs.setString(14, checkOrderIDDetail.getOperationCode()); // 14
																		// i_v_operation_code
			// //////////////////////////

			// business output parameters
			// ///////////////////////////

			con.getData(cs);

			checkOrderIDResult.setResultCode(cs.getString(10));
			checkOrderIDResult.setResultDescription(cs.getString(11));

		} catch (Exception e) {
			throw e;
		} finally {

			if (cs != null)
				cs.close();

			con.disconnectDB();
		}

		return checkOrderIDResult;
	}
}
