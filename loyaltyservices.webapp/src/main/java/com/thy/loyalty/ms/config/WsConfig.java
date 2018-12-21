/*
 * Created on Jun 20, 2003
 *
 * 
 * 
 */
package com.thy.loyalty.ms.config;

import java.io.File;

import com.jforce.util.ClassInitiator;

public class WsConfig extends ClassInitiator {

	public static WsConfig instance = new WsConfig();

	public static String MEMBER_DETAILS_SERVICE_ENDPOINT;
	public static String MEMBER_CREDENTIALS_SERVICE_ENDPOINT;
	public static String AWARD_OPERATION_SERVICE_ENDPOINT;
	public static String GARANTI_SERVICE_ENDPOINT;

	// BookingWS EMDService Parameters
	public static String EMDSERVICE_ENDPOINT;
	public static String EMDSERVICE_SERVERACCESSTYPE;
	public static String EMDSERVICE_FIREWALLUSERNAME;
	public static String EMDSERVICE_FIREWALLPASSWORD;
	public static String EMDSERVICE_USERNAME;
	public static String EMDSERVICE_CLIENT_CODE;
	public static String EMDSERVICE_EXTRAPARAMETER_KEY;
	public static String EMDSERVICE_EXTRAPARAMETER_VALUE;
	public static String EMDSERVICE_TIMEOUT_IN_SECS;
	public static String SERVICE_ACCESS_TYPE;
	public static String FIREWALL_USERNAME;
	public static String FIREWALL_PASSWORD;

	public static String WS_CLIENT_USERNAME;
	public static String WS_CLIENT_CODE;
	public static String WS_AIRLINE_CODE;
	public static String WS_HEADER_AGENT;
	public static String WS_HEADER_APPLICATION;

	public static String WS_CLM_CLIENT_CODE;
	public static String WS_CLM_CLIENT_USERNAME;

	public static String CLM_SERVICE_ENDPOINT;
	public static String CLM_CLIENT_CODE;
	public static String CLM_CLIENT_USERNAME;

	public static String MEMBEROPERATION_SERVICE_MEMBER_ENDDAY;
	public static String MEMBEROPERATION_SERVICE_MEMBER_THRESHOLDTIME;

	// W3CalculateFlightMilesService Parameters
	public static String W3CALCULATE_FLIGHT_MILES_ENDPOINT_URL;
	public static String W3CALCULATE_FLIGHT_MILES_SERVICE_ACCESS_TYPE;
	public static String W3CALCULATE_FLIGHT_MILES_FIREWALL_USERNAME;
	public static String W3CALCULATE_FLIGHT_MILES_FIREWALL_PASSWORD;

	public static String W3CALCULATE_FLIGHT_MILES_CLIENT_CODE;
	public static String W3CALCULATE_FLIGHT_MILES_CLIENT_USERNAME;
	// - //

	public static String GARANTI_FIREWALL_USERNAME;
	public static String GARANTI_FIREWALL_PASSWORD;
	public static String GARANTI_PLATFORM_TYPE;
	public static String GARANTI_HDR_USERID;
	public static String GARANTI_HDR_PASSWORD;

	// Address Service parameters

	public static String WS_ADDRESS_SECRET;
	public static String WS_ADDRESS_APP_ID;
	public static String WS_ADDRESS_PARAGON_API_URL;

	public WsConfig() {
		init();
	}

	public void init() {
		try {

			String appDir = System.getProperty("thy.appdir");

			// C:\thy\loyaltyservices\conf\wsparam.txt
			String appparam = "loyaltyservices" + File.separator + "conf" + File.separator + "wsparam.txt";
			String tmpPath = appDir + File.separator + appparam;
			initiate(new File(tmpPath));

		} catch (Exception ex) {

		}

	}

	/**
	 * Returns the instance.
	 * 
	 * @return ENTRY
	 */
	public static WsConfig getInstance() {
		return instance;
	}
}