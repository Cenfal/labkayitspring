package com.thy.loyalty.ms.dblog;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.jforce.connectors.oracle.Connector;
import com.thy.loyalty.ms.config.CraneDb;
import com.thy.loyalty.ms.config.Parameters;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.loyalty.ms.utility.dto.Utils;
import com.thy.ws.header.request.RequestHeader;

public class DBLogWriter {
	private static Log logger = LogFactory
			.getLog(DBLogWriter.class);

	public static void addDBLog(RequestHeader requestHeader, String totalTime,
			String serviceName, String webMethodName, String responseCode,String logMessage,String flyerID,Long processID) {
		
		if(Parameters.getString("LOG_RETRO_WEB_SERVICE_DETAIL")!=null && Parameters.getString("LOG_RETRO_WEB_SERVICE_DETAIL").equalsIgnoreCase("T")){
		
		String partnerCode = requestHeader.getClientCode();
		String partnerUserName = requestHeader.getClientUsername();
		String channelCode = requestHeader.getChannel()+"";
		String airlineCode = requestHeader.getAirlineCode();
		String application = requestHeader.getApplication();
		String agent = requestHeader.getAgent();
		String language = Utils.validateRequestLanguage(requestHeader
				.getLanguageCode());
		String clientTransactionId = requestHeader.getClientTransactionId();
		
		Connector con = null;
		java.sql.CallableStatement cs = null;

		try {

			con = CraneDb.getConnection();

			String query = "begin\n"
					+ "  insert_to_dblog_for_webservice(v_partner_code 			=> ?,\n"  //1
					+ "                                 v_partner_username 		=> ?,\n"  //2
					+ "                                 v_channel_code 			=> ?,\n"  //3
					+ "                                 v_airline_code 			=> ?,\n"  //4
					+ "                                 v_application 			=> ?,\n"  //5
					+ "                                 v_agent 				=> ?,\n"  //6
					+ "                                 v_language 				=> ?,\n"  //7
					+ "                                 v_client_transaction_id => ?,\n"  //8
					+ "                                 v_service_name 			=> ?,\n"  //9
					+ "                                 v_webmethod_name 		=> ?,\n"  //10
					+ "                                 v_log_message 			=> ?,\n"  //11
					+ "                                 v_response_code 		=> ?,\n"  //12
					+ "                                 v_total_time 			=> ?,\n"  //13
					+ "                                 i_v_flyer_id 			=> ?,\n"  //14
					+ "                                 i_n_process_id 			=> ?\n"  //15
					+ ");\n"
					+ "end;";

			cs = con.prepareCall(query);

			// Web service base input Parameters
			cs.setString(1, partnerCode);
			cs.setString(2, partnerUserName);
			cs.setString(3, channelCode);
			cs.setString(4, airlineCode);
			cs.setString(5, application);
			cs.setString(6, agent);
			cs.setString(7, language);
			cs.setString(8, clientTransactionId);
			cs.setString(9, serviceName);
			cs.setString(10, webMethodName);
			cs.setString(11, logMessage);
			cs.setString(12, responseCode);
			cs.setString(13, totalTime);
			cs.setString(14, flyerID);
			cs.setLong(15, processID);
			// //////////////////////////////////
			con.getData(cs);

		} catch (Exception e) {
			//System.out.println(StringUtils.stack2string(e));
		} finally {
			try {
				cs.close();
			} catch (SQLException e) {
				//System.out.println(StringUtils.stack2string(e));
				logger.error(StringUtils.stack2string(e)) ;
			}
			con.disconnectDB();
		}
		}

	}

	public static void addDBLog_detail(Long processID,int step,String request, String response, Date requestTime, Date responseTime, String log,String processGroupID) {
		
		if(Parameters.getString("LOG_RETRO_WEB_SERVICE_DETAIL")!=null && Parameters.getString("LOG_RETRO_WEB_SERVICE_DETAIL").equalsIgnoreCase("T")){
		
	    String logSubStr = log.length()>3990 ? log.substring(0, 3990) : log;
	    
	    if (request != null) {
	    	request = request.length()>3990 ? request.substring(0, 3990) : request;
	    }
	    
	    if (response != null) {
	    	response = response.length()>3990 ? response.substring(0, 3990) : response;
	    }
	    		
		Connector con = null;
		java.sql.CallableStatement cs = null;

		try {

			con = CraneDb.getConnection();

			String query = "begin\n"
					+ "  insert_to_dblog_for_ws_detail(i_n_process_id 		=> ?,\n"  //1
					+ "                                 i_n_step 			=> ?,\n"  //2
					+ "                                 i_v_request 		=> ?,\n"  //3
					+ "                                 i_v_response 		=> ?,\n"  //4
					+ "                                 i_d_request_time 	=> ?,\n"  //5
					+ "                                 i_d_response_time 	=> ?,\n"  //6
					+ "                                 i_v_log 			=> ?,\n"  //7
					+ "                                 i_v_process_group_id=> ?\n"   //8
					+ ");\n"
					+ "end;";

			cs = con.prepareCall(query);
			
			//System.out.println(requestTime);
			
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
			String requestTimeStr=df.format(requestTime);
			String responseTimeStr=df.format(responseTime);
			
			//System.out.println(requestTimeStr);

			// Web service base input Parameters
			cs.setLong(1, processID);
			cs.setInt(2, step);
			cs.setString(3, request);
			cs.setString(4, response);
			cs.setString(5, requestTimeStr);
			cs.setString(6, responseTimeStr);
			cs.setString(7, logSubStr);
			cs.setString(8, processGroupID);
			// //////////////////////////////////
			con.getData(cs);

		} catch (Exception e) {
			//System.out.println(StringUtils.stack2string(e));
		} finally {
			try {
				cs.close();
			} catch (SQLException e) {
				//System.out.println(StringUtils.stack2string(e));
				logger.error(StringUtils.stack2string(e)) ;
			}
			con.disconnectDB();
		}
		}

	}

	public static void finishDBLog(Long processID,String totalTime,String responseCode,String logMessage,String flyerID) throws Exception{
		Connector con = null;
		
		try {

			con = CraneDb.getConnection();

			String query = "update DBLOG_FOR_WEBSERVICES l " +
						   "set    l.response_code='" +responseCode+"' "+
						   		  ",l.total_time='" +totalTime+"' "+
						   		  ",l.flyer_id='" +flyerID+"' "+
						   		  ",l.log_message = l.log_message || ' - '|| '" +logMessage +"' "+
						   "where  l.process_id=" +Long.toString(processID);
			
			con.setData(query);

			con.commit();

		} catch (Exception e) {
			//System.out.println(StringUtils.stack2string(e));
			logger.error(StringUtils.stack2string(e)) ;
			con.rollback();
		} finally {
//			try {
//				ps.close();
//			} catch (SQLException e) {
//				System.out.println(StringUtils.stack2string(e));
//			}
			
			con.disconnectDB();
		}
	}

}
