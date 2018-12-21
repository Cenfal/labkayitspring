package com.thy.loyalty.loyaltyservices.securityprocess.service.impl;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jforce.connectors.oracle.Connector;
import com.thy.loyalty.loyaltyservices.securityprocess.dto.SecurityProcessDetail;
import com.thy.loyalty.loyaltyservices.securityprocess.dto.SecurityProcessResult;
import com.thy.loyalty.loyaltyservices.securityprocess.service.ISecurityProcessService;
import com.thy.loyalty.ms.config.CraneDb;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.loyalty.ms.utility.dto.Utils;
import com.thy.ws.header.request.RequestHeader;

/**
 * @author M_SET
 * 
 */

@Service
public class SecurityProcessServiceImpl implements ISecurityProcessService {

	private static Log logger = LogFactory
			.getLog(SecurityProcessServiceImpl.class);
	private static final String ServiceName = "qmpSecurityProcessService";

	@Override
	public SecurityProcessResult SecurityProcessOperation(
			RequestHeader requestHeader,
			SecurityProcessDetail securityProcessDetail) {

		SecurityProcessResult securityProcessResult = new SecurityProcessResult();
			String partnerCode 		= "";
			String partnerUserName 	= "";
			String channelCode 		= "";
			String airlineCode 		= "";
			String application 		= "";
			String agent 			= "";
			String language 		= "";

		logger.info("qmp_pack_security_services.security_process_operations has been called..");

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
					+ "  qmp_pack_security_services.security_process_operations(i_v_partner_code 		=> :i_v_partner_code,\n"
					+ "                                        				   	i_v_partner_user_name 	=> :i_v_partner_user_name,\n"
					+ "                                        				   	i_v_partner_password 	=> :i_v_partner_password,\n"
					+ "                                        				   	i_v_ip_address 			=> :i_v_ip_address,\n"
					+ "                                        				   	i_v_channel_code 		=> :i_v_channel_code,\n"
					+ "                                        				   	i_v_airline_code 		=> :i_v_airline_code,\n"
					+ "                                        				   	i_v_application 		=> :i_v_application,\n"
					+ "                                        				   	i_v_agent 				=> :i_v_agent,\n"
					+ "                                        				   	i_v_language 			=> :i_v_language,\n"
					+ "                                        				   	v_change_type 			=> :v_change_type,\n"
					+ "                                        				   	v_table_seq 			=> :v_table_seq,\n"
					+ "                                        				   	v_process_code 			=> :v_process_code,\n"
					+ "                                        				   	v_process_explanation 	=> :v_process_explanation,\n"
					+ "                                        				   	v_active 				=> :v_active,\n"
					+ "                                        				   	o_v_response_code 		=> :o_v_response_code,\n"
					+ "                                        				   	o_v_response_description=> :o_v_response_description);\n"
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
			cs.setString(10, securityProcessDetail.getChangeType());
			cs.setInt(11, securityProcessDetail.getTableSeq());
			cs.setString(12, securityProcessDetail.getProcessCode());
			cs.setString(13, securityProcessDetail.getProcessExplanation());
			cs.setString(14, securityProcessDetail.getActive());
			// /////////////////////////
			// Process output parameters
			cs.registerOutParameter(15, java.sql.Types.VARCHAR);
			cs.registerOutParameter(16, java.sql.Types.VARCHAR);
			// ///////////////////////////
			con.getData(cs);
			// //////////////////////////////////////
			// set process output parameters
			securityProcessResult.setResultCode(cs.getString(17));
			securityProcessResult.setResultDescription(cs.getString(18));
		} catch (Exception e) {
			logger.error("Error in qmp_pack_security_services.security_process_operations "
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
		return securityProcessResult;
	}

}
