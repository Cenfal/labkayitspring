package com.thy.loyalty.ms.config;

import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jforce.connectors.DBResultSet;

public class DataCache {
	private static DataCache instance = new DataCache();
	private static Log logger = LogFactory.getLog(DataCache.class);
	
	public static DataCache getInstance() {
		return instance;
	}
	
	private DataCache() {
		try {
			initialize();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	public void forceUpdate() throws java.sql.SQLException, NamingException {
		if (CraneDButils.isRequiredWebDropdownDataRefresh().trim()
				.equalsIgnoreCase("T")) {
			initialize();
			CraneDb.executeQuery("UPDATE MS_WEB_PARAMETERS SET VALUE='F' WHERE KEY='REFRESH_WEB_DROPDOWN_DATA'");
		}
	}

	// listeler
	private DBResultSet messages = null;
	/*private DBResultSet types = null;
	private DBResultSet categories = null;
	private DBResultSet subcategories = null;*/


	private void initialize() throws java.sql.SQLException, NamingException {
		
		messages = CraneDb.getResultSet("SELECT SEQ,KEY,LANG,MESSAGE FROM MESSAGES");
		/*types = CraneDb.getResultSet("SELECT OBSERVER_INCIDENT_TYPE_ID, OBSERVER_INCIDENT_TYPE_NAME FROM OBSERVER_INCIDENT_TYPE");
		categories = CraneDb.getResultSet("SELECT OBSERVER_INCIDENT_CATEGORY_ID, INCIDENT_CATEGORY_NAME FROM OBSERVER_INCIDENT_CATEGORY");
		subcategories = CraneDb.getResultSet("SELECT INCIDENT_SUBCATEGORY_ID, INCIDENT_SUBCATEGORY_NAME FROM OBSERVER_INCIDENT_SUBCATEGORY");*/
	}

	public DBResultSet getMessages() {
		return messages;
	}
	
	/*public DBResultSet getTypes() {
		return types;
	}
	
	public DBResultSet getCategories() {
		return categories;
	}
	
	public DBResultSet getSubcategories() {
		return subcategories;
	}*/

	/**
	 * 
	 * @param user
	 * @param pass
	 * @return String (Possible return values : SUCCESS, NO_GRANT, EXCEPTION)
	 */
	public static String reLoad(String user, String pass) {

		try {
			String adminUserName = Parameters.getString("ADMIN_MEMBER");
			String adminPassword = Parameters.getString("ADMIN_PASS");

			if (!StringUtils.isEmptyString(user)
					&& !StringUtils.isEmptyString(adminUserName)
					&& !StringUtils.isEmptyString(pass)
					&& !StringUtils.isEmptyString(adminPassword)
					&& user.equals(adminUserName) && pass.equals(adminPassword)) {

				Config.instance = new Config();
				logger.debug("DataCache.debug Config reinitialized.");

//				WsConfig.instance = new WsConfig();
//				logger.debug("DataCache.debug WSConfig reinitialized.");

				Parameters.reloadParameters();
				logger.debug("DataCache.debug Parameters reloaded.");

				DataCache.instance = new DataCache();
				logger.debug("DataCache.debug DataCache reinitialized.");

				return "SUCCESS";

			} else {

				return "NO_GRANT";

			}
		} catch (Exception e) {

			logger.error("DataCache.reLoad has exception !", e);

			return "EXCEPTION";
		}
	}
}
