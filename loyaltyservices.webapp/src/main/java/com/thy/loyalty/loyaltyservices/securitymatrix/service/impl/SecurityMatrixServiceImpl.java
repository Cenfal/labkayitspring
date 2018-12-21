package com.thy.loyalty.loyaltyservices.securitymatrix.service.impl;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jforce.connectors.oracle.Connector;
import com.thy.loyalty.loyaltyservices.securitymatrix.dto.SecurityMatrixDetail;
import com.thy.loyalty.loyaltyservices.securitymatrix.dto.SecurityMatrixResult;
import com.thy.loyalty.loyaltyservices.securitymatrix.service.ISecurityMatrixService;
import com.thy.loyalty.ms.config.CraneDb;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.loyalty.ms.utility.dto.Utils;
import com.thy.ws.header.request.RequestHeader;

/**
 * @author M_SET
 * 
 */

@Service
public class SecurityMatrixServiceImpl implements ISecurityMatrixService {

	private static Log logger = LogFactory
			.getLog(SecurityMatrixServiceImpl.class);
	private static final String ServiceName = "qmpSecurityMatrixService";

	@Override
	public SecurityMatrixResult SecurityMatrixOperation(
			RequestHeader requestHeader,
			SecurityMatrixDetail securityMatrixDetail) {

		SecurityMatrixResult securityMatrixResult = new SecurityMatrixResult();
		String partnerCode 		= "";
		String partnerUserName 	= "";
		String channelCode 		= "";
		String airlineCode 		= "";
		String application 		= "";
		String agent 			= "";
		String language 		= "";

		logger.info("qmp_pack_security_services.security_matrix_operations has been called..");

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
					+ "  qmp_pack_security_services.security_matrix_operations(i_v_partner_code 		=> :i_v_partner_code,\n"
					+ "                                        				   i_v_partner_user_name 	=> :i_v_partner_user_name,\n"
					+ "                                        				   i_v_partner_password 	=> :i_v_partner_password,\n"
					+ "                                        				   i_v_ip_address 			=> :i_v_ip_address,\n"
					+ "                                        				   i_v_channel_code 		=> :i_v_channel_code,\n"
					+ "                                        				   i_v_airline_code 		=> :i_v_airline_code,\n"
					+ "                                        				   i_v_application 			=> :i_v_application,\n"
					+ "                                        				   i_v_agent 				=> :i_v_agent,\n"
					+ "                                        				   i_v_language 			=> :i_v_language,\n"
					+ "                                        				   v_change_type 			=> :v_change_type,\n"
					+ "                                        				   v_table_seq 				=> :v_table_seq,\n"
					+ "                                        				   v_role_code 				=> :v_role_code,\n"
					+ "                                        				   v_process_code 			=> :v_process_code,\n"
					+ "                                        				   o_v_response_code 		=> :o_v_response_code,\n"
					+ "                                        				   o_v_response_description => :o_v_response_description);\n"
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
			cs.setString(10, securityMatrixDetail.getChangeType());
			cs.setInt(11, securityMatrixDetail.getTableSeq());
			cs.setString(12, securityMatrixDetail.getRoleCode());
			cs.setString(13, securityMatrixDetail.getProcessCode());
			// /////////////////////////
			// Process output parameters
			cs.registerOutParameter(14, java.sql.Types.VARCHAR);
			cs.registerOutParameter(15, java.sql.Types.VARCHAR);
			// ///////////////////////////
			con.getData(cs);
			// //////////////////////////////////////
			// set process output parameters
			securityMatrixResult.setResultCode(cs.getString(16));
			securityMatrixResult.setResultDescription(cs.getString(17));
		} catch (Exception e) {
			logger.error("Error in qmp_pack_security_services.security_matrix_operations "
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
		return securityMatrixResult;
	}

}
