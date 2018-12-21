package com.thy.loyalty.loyaltyservices.common.service;

public interface IRefreshApplicationCacheService {

	/**
	 * Refreshes parameters cached from db .
	 * Username and password is required. (IN MS_WEB_PARAMETERS)
	 * 
	 * @param user (ADMIN_MEMBER in MS_WEB_PARAMETERS)
	 * @param pass (ADMIN_PASS in MS_WEB_PARAMETERS)
	 * @return String
	 */
	public String refreshApplicationDataCache(String user, String pass);
}
