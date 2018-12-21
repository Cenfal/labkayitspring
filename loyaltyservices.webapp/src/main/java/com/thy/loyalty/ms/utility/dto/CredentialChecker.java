package com.thy.loyalty.ms.utility.dto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.thy.loyalty.ms.config.CraneDb;
import com.thy.loyalty.ms.config.StringUtils;

public class CredentialChecker {

	private static Log logger = LogFactory.getLog(CredentialChecker.class);

	public static boolean check(String partnerCode, String partnerUserName,
			String partnerPassword, String partnerIP, String serviceName) {
		com.jforce.connectors.oracle.Connector c = null;

		try {

			c = CraneDb.getConnection();

			java.sql.CallableStatement cs = c
					.prepareCall("BEGIN MS_PACK_ESB_ENGINE.PROC_CHECK_PERMIT_TO_REQUEST(?,?,?,?,?,?,?,?);END;");

			cs.setString(1, partnerCode);
			cs.setString(2, partnerUserName);
			cs.setString(3, partnerPassword);
			cs.setString(4, serviceName);
			cs.setString(5, partnerIP);

			cs.registerOutParameter(6, java.sql.Types.INTEGER);
			cs.registerOutParameter(7, java.sql.Types.VARCHAR);
			cs.registerOutParameter(8, java.sql.Types.VARCHAR);

			c.getData(cs);

			String responseCode = cs.getString(7);

			if (!StringUtils.isEmptyString(responseCode)
					&& responseCode.trim().equals("00"))
				return true;
			else
				return false;

		} catch (Exception e) {

			logger.info("CredentialChecker.check got error : " + e.getMessage());
			return false;

		} finally {

			c.disconnectDB();
		}
	}
}
