package com.thy.loyalty.ms.config.services;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;

import com.thy.loyalty.ms.config.StringUtils;

public class MSServiceHolder {
	
	private static Log logger = LogFactory
			.getLog(MSServiceHolder.class);

	private static ArrayList<Service> services = new ArrayList<Service>();
	
	private static MSServiceHolder instance;
	
	private MSServiceHolder()
	{
		
	}
	
	private static void initialize()
	{
		String appDir = System.getProperty("thy.appdir");
		String  serviceXml= "loyaltyservices"+File.separator+"conf"+File.separator+"serviceHandlerParameterMapping.xml";
		String serviceXmlPath = appDir + File.separator + serviceXml;
		ServiceHandlerParameterReader parameterReader = new ServiceHandlerParameterReader();

		// mil 304 System.out.println("MSServiceHolder initializing ...");

		try 
		{
			parameterReader.readXml(serviceXmlPath);
		} 
		catch (ParserConfigurationException e) 
		{
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			logger.error(StringUtils.stack2string( e ) );
		} catch (SAXException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			logger.error(StringUtils.stack2string( e ) );
		}

		//mil-304 System.out.println("MSServiceHolder initialized ...");
		

	}

	public static MSServiceHolder getInstance()
	{
		if (instance == null)
		{
			instance = new MSServiceHolder();
			initialize();
			return instance;
		}
		else
			return instance;
	}
	
	public static void addService(Service s)
	{
		getInstance().services.add(s);
	}
	
	public static void removeService(Service s)
	{
		getInstance().services.remove(s);
	}
	
	public static ArrayList<Service> getServices()
	{
		return getInstance().services;
	}

	public static String getParamColumnMapping(String serviceName,String methodName,String columnName)
	{
		String nameOnMethod = "";
		
		for(Service service : getInstance().getServices())
		{
			if (service.getName().equals(serviceName))
			{
				for (Method m : service.getMethods())
				{
					if (m.getName().equals(methodName))
					{
						for (Parameter p : m.getParameters())
						{
							if(columnName.equals(p.getNameOnTable()))
							{
								nameOnMethod = p.getNameOnMethod();
								break;								
							}
						}
					}
				}
			}
		}

		return nameOnMethod;
	}
	
	public static Method getServiceMethod(String serviceName,String methodName)
	{
		Method tempMethod = null;
		
		for(Service service : getInstance().getServices())
		{
			if (service.getName().equals(serviceName))
			{
				for (Method m : service.getMethods())
				{
					if (m.getName().equals(methodName))
					{
						tempMethod= m;
						break;
					}
				}
			}
		}
		
		return tempMethod;

	}
}
