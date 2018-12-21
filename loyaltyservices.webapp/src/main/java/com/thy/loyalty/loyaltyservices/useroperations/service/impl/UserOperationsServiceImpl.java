package com.thy.loyalty.loyaltyservices.useroperations.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jforce.connectors.oracle.Connector;
import com.thy.loyalty.loyaltyservices.useroperations.dto.UserFileRecord;
import com.thy.loyalty.loyaltyservices.useroperations.dto.UserLoginDetail;
import com.thy.loyalty.loyaltyservices.useroperations.dto.UserLoginResult;
import com.thy.loyalty.loyaltyservices.useroperations.dto.UserProcessRecord;
import com.thy.loyalty.loyaltyservices.useroperations.service.IUserOperationsService;
import com.thy.loyalty.ms.config.CraneDb;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.loyalty.ms.utility.dto.Utils;
import com.thy.ws.header.request.RequestHeader;

/**
 * @author HITATOPRAK
 * 
 */

@Service
public class UserOperationsServiceImpl implements IUserOperationsService {
	private static Log logger = LogFactory
			.getLog(UserOperationsServiceImpl.class);
	private static final String ServiceName = "qmpUserLoginServices";

	@Override
	public UserLoginResult userLogin(RequestHeader requestHeader,
			UserLoginDetail userLoginDetail) {
		UserLoginResult userLoginResult = new UserLoginResult();
		String partnerCode = "";
		String partnerUserName = "";
		String channelCode = "";
		String airlineCode = "";
		String application = "";
		String agent = "";
		String language = "";

		logger.info("qmp_pack_security_services.user_login has been called..");
		Connector con = null;
		java.sql.CallableStatement cs = null;

		try {
			partnerCode = requestHeader.getClientCode();
			partnerUserName = requestHeader.getClientUsername();
			channelCode = (requestHeader.getChannel() == null) ? "" : Utils
					.validateChannelType(requestHeader.getChannel());
			airlineCode = requestHeader.getAirlineCode();
			application = requestHeader.getApplication();
			agent = requestHeader.getAgent();
			language = (requestHeader.getLanguageCode() == null) ? "EN" : Utils
					.validateRequestLanguage(requestHeader.getLanguageCode());

			con = CraneDb.getConnection();

			String query = "begin\n"
					+ "  -- Call the procedure\n"
					+ "  qmp_pack_security_services.user_login(i_v_partner_code => :i_v_partner_code,\n"
					+ "                                        i_v_partner_user_name => :i_v_partner_user_name,\n"
					+ "                                        i_v_partner_password => :i_v_partner_password,\n"
					+ "                                        i_v_ip_address => :i_v_ip_address,\n"
					+ "                                        i_v_channel_code => :i_v_channel_code,\n"
					+ "                                        i_v_airline_code => :i_v_airline_code,\n"
					+ "                                        i_v_application => :i_v_application,\n"
					+ "                                        i_v_agent => :i_v_agent,\n"
					+ "                                        i_v_language => :i_v_language,\n"
					+ "                                        i_v_user_name => :i_v_user_name,\n"
					+ "                                        i_v_user_role => :i_v_user_role,\n"
					+ "                                        o_c_user_file => :o_c_user_file,\n"
					+ "                                        o_c_user_process => :o_c_user_process,\n"
					+ "                                        o_v_response_code => :o_v_response_code,\n"
					+ "                                        o_v_response_description => :o_v_response_description);\n"
					+ "end;";
			cs = con.prepareCall(query);

			// Web service base input Parameters
			cs.setString(1, partnerCode);
			cs.setString(2, partnerUserName);
			cs.setString(3, "");
			cs.setString(4, "");
			cs.setString(5, channelCode);
			cs.setString(6, airlineCode);
			cs.setString(7, application);
			cs.setString(8, agent);
			cs.setString(9, language);

			// //////////////////////////////////
			// Process input parameters
			cs.setString(10, userLoginDetail.getUserName());
			cs.setString(11, userLoginDetail.getUserRole());
			// /////////////////////////

			// /////////////////////////
			// Process output parameters
			cs.registerOutParameter(12, OracleTypes.CURSOR);
			cs.registerOutParameter(13, OracleTypes.CURSOR);
			cs.registerOutParameter(14, java.sql.Types.VARCHAR); // O_V_RESPONSE_CODE
			cs.registerOutParameter(15, java.sql.Types.VARCHAR); // O_V_RESPONSE_DESCRIPTION
			// ///////////////////////////

			con.getData(cs);

			OracleResultSet rs = (OracleResultSet) cs.getObject(13);
			ArrayList<UserProcessRecord> userProcessList = new ArrayList<UserProcessRecord>();
			if (rs != null) {
				while (rs.next()) {
					UserProcessRecord userProcessRecord = new UserProcessRecord();
					userProcessRecord.setProcessCode(rs
							.getString("PROCESS_CODE"));
					userProcessList.add(userProcessRecord);
				}
			}
			// GET user info
			OracleResultSet userInfo = (OracleResultSet) cs.getObject(12);
			UserFileRecord userfileRecord = new UserFileRecord();
			if (userInfo != null) {
				while (userInfo.next()) {
					userfileRecord.setFullName(userInfo.getString("FULL_NAME"));
					userfileRecord.setUserIsn(userInfo.getString("USER_ISN"));
					userfileRecord.setUserName(userInfo.getString("USER_NAME"));
				}
			}
			// set process output parameters
			userLoginResult.setUserProcessList(userProcessList);
			userLoginResult.setUserfileRecord(userfileRecord);
			userLoginResult.setResultCode(cs.getString(14));
			userLoginResult.setResultDescription(cs.getString(15));
		} catch (Exception e) {
			logger.error("Error in qmp_pack_security_services.user_login "
					+ StringUtils.stack2string(e));
		} finally {
			try {
				cs.close();

			} catch (SQLException e) {
				logger.error("Error in " + ServiceName + " (SQLException) "
						+ StringUtils.stack2string(e));
			}

			con.disconnectDB();
		}

		return userLoginResult;
	}

}
