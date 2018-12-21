package com.thy.loyalty.ms.config;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jforce.connectors.oracle.Connector;

public class CraneDButils {

	private static Log logger = LogFactory.getLog(CraneDButils.class);
	private static String defaultResultMessageChannel = "WEB" ;

	
	public static String getResultMessage(String code, String service_name,String language) {
		return getResultMessage(code, service_name, language, defaultResultMessageChannel);
	}
	
	public static String getResultMessage(String code, String serviceName, String methodName,String language) {
		return getResultMessage(code, serviceName, methodName, language, defaultResultMessageChannel);
	}

	public static String getResultMessage(String code, String serviceName, String methodName,String language, String channel) {

		String ResultStr = "";
		Connector con = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		logger.info("CraneDButils.getResultMessage method called for ResultMessage");

		try {
			con = CraneDb.getConnection();
			cs = con.prepareCall("select get_result_message(?,?,?,?,?) as result_str from dual");
			cs.setString(1, code);
			cs.setString(2, serviceName);
			cs.setString(3, methodName);
			cs.setString(4, channel);
			cs.setString(5, language);

			rs = cs.executeQuery();

			if (rs.next()) {
				ResultStr = rs.getNString(1);
			}

		} catch (Exception e) {

		} finally {

			try {	cs.close();	} 
			catch (Exception ex) {	}

			try {	con.disconnectDB();	} 
			catch (Exception ex) {	}

		}

		return ResultStr;
	}

	public static String isRequiredWebDropdownDataRefresh() {
		String ResultStr = "";
		Connector con = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		logger.info("CraneDButils.isRequiredWebDropdownData method called if updating dropdownlist data is required.");

		try {
			con = CraneDb.getConnection();
			cs = con.prepareCall("select t.value from MS_WEB_PARAMETERS t where key = 'REFRESH_WEB_DROPDOWN_DATA'");

			rs = cs.executeQuery();

			if (rs.next()) {
				ResultStr = rs.getNString(1);
			}

		} catch (Exception e) {
			logger.error(StringUtils.stack2string(e));
		} finally {

			try {
				cs.close();
			} catch (Exception ex) {
			}

			try {
				con.disconnectDB();
			} catch (Exception ex) {
			}

		}

		return ResultStr;
	}

	
}
