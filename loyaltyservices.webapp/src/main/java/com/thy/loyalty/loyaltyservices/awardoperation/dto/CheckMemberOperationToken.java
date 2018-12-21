package com.thy.loyalty.loyaltyservices.awardoperation.dto;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jforce.connectors.oracle.Connector;
import com.thy.loyalty.ms.config.CraneDb;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.ws.header.request.RequestHeader;

public class CheckMemberOperationToken {

	private static Log logger = LogFactory
			.getLog(CheckMemberOperationToken.class);

	public static TokenResult checkToken(RequestHeader requestHeader,
			TokenDetail tokenDetail) {

		TokenResult result = new TokenResult();

		logger.info("ms_pack_esb_check.check_operation_token  procedure is being called..");

		Connector con = null;
		java.sql.CallableStatement cs = null;

		try {

			con = CraneDb.getConnection();

			String query = "begin  "
					+ "ls_pack_esb_check.check_operation_token(i_v_partner_code 			=> ?,"
					+ "i_v_partner_user_name 		=> ?,"
					+ "i_v_partner_password 		=> ?,"
					+ "i_v_ip_address 				=> ?," + "i_v_channel_code 			=> ?,"
					+ "i_v_airline_code 			=> ?," + "i_v_application 			=> ?,"
					+ "i_v_agent 					=> ?," + "i_v_language 				=> ?,"
					+ "o_v_response_code 			=> ?,"
					+ "o_v_response_description 	=> ?,"
					+ "i_v_member_id 				=> ?," + // 12 - i_v_member_id
					"i_v_operation_code 			=> ?," + // 13 - i_v_operation_name
					"i_v_token 					=> ?" + // 14 - i_v_token
					");" + "end;";

			cs = con.prepareCall(query);

			cs.setString(1, requestHeader.getClientCode());
			cs.setString(2, requestHeader.getClientUsername());
			cs.setString(3, "");
			cs.setString(4, "");

			cs.setString(5, requestHeader.getChannel().value());
			cs.setString(6, requestHeader.getAirlineCode());
			cs.setString(7, requestHeader.getApplication());
			cs.setString(8, requestHeader.getAgent());
			cs.setString(9, requestHeader.getLanguageCode().value());

			// Web service main response
			cs.registerOutParameter(10, java.sql.Types.VARCHAR); // O_V_RESPONSE_CODE
			cs.registerOutParameter(11, java.sql.Types.VARCHAR); // O_V_RESPONSE_DESCRIPTION

			cs.setString(12, tokenDetail.getMemberID());
			cs.setString(13, tokenDetail.getOperationName());
			cs.setString(14, tokenDetail.getToken());

			con.getData(cs);

			result.setResultCode(cs.getString(10));
			result.setResultDescription(cs.getString(11));

		} catch (Exception e) {
			logger.error("Error in ls_pack_esb_check.check_operation_token "
					+ StringUtils.stack2string(e));
			// System.out.println(StringUtils.stack2string(e));
		} finally {
			try {
				cs.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error("Error in ls_pack_esb_check.check_operation_tokenprocedure (SQLException) "
						+ StringUtils.stack2string(e));
			}
			con.disconnectDB();
		}

		return result;
	}

}
