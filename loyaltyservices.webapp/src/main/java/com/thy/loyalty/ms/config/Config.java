/*
 * Created on Jun 20, 2003
 *
 * 
 * 
 */
package com.thy.loyalty.ms.config;

import java.io.File;

import com.jforce.util.ClassInitiator;


public class Config extends ClassInitiator{
	

	public static Config instance = new Config();
	
	public String LOYALTYSERVICES_DATASOURCE_IP;	
	public String LOYALTYSERVICES_DATASOURCE_NAME;
	public String TROPHYSERVICES_DATASOURCE_IP;
	public String TROPHYSERVICES_DATASOURCE_NAME;
	public String CONNECTION_TYPE;
	public String MSSERVICES_DATASOURCE_IP;	
	public String MSSERVICES_DATASOURCE_NAME;
	
	
	public Config()
	{
	    init();
	}
	
	
	public void init()
	{
		try
		{

			String appDir = System.getProperty("thy.appdir");
			//D:\thy\msservices\conf\appparam.txt
			String  appparam= "loyaltyservices"+File.separator+"conf"+File.separator+"appparam.txt";
			String tmpPath = appDir + File.separator + appparam;
			//mil-304	System.out.println(tmpPath);
			initiate(new File(tmpPath));
	
			//mil-304 System.out.println("MILESANDSMILESDATASOURCENAME :"+MILESANDSMILESDATASOURCENAME);
			//mil-304 System.out.println(" MSServices Config Parameter initiation completed");

		}
		catch (Exception ex)
		{


			
		}
		//DataCache.getInstance();

	}

	/**
	 * Returns the instance.
	 * @return ENTRY
	 */
	public static Config getInstance()
	{
		return instance;
	}
}