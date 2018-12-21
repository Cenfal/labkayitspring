package com.thy.loyalty.ms.config;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.jforce.connectors.oracle.Connector;

/**
 * 
 * Created on 26-08-2010
 * 
 * @author htarhan
 * 
 * 		ms_web_parameters tablosundan parametreleri alir, keys Hashtable'ina atar.
 * 
 * 		getString,
 * 		getInteger,
 * 		getBoolean,
 * 		getDate fonksiyonlari parametre olarak KEY alir, KEY karsiligi VALUE dondurur.
 */

public class Parameters {
	
	private static Log logger = LogFactory
			.getLog(Parameters.class);

	public static Parameters instance = null; 
	public static Hashtable keys;
	public static ArrayList paramList = null;

	public Parameters()
	{
		initialize();
	}

	private static void initialize() {
		// TODO Auto-generated method stub
		Connector con = null;
		try {

			keys = new Hashtable();
			paramList = new ArrayList();
			con = CraneDb.getConnection();
			ResultSet rs = con.getResultSet("SELECT * FROM ms_web_parameters" );

			while (rs.next()) {

				Object [] parameterRecord = new Object[2];
				parameterRecord[0] = rs.getString(1);
				if (rs.getString(2).equals("CHAR"))
				{
					parameterRecord[1] = rs.getString(3);
					keys.put(parameterRecord[0], parameterRecord[1]);
					paramList.add(new Parameter(rs.getString(1), rs.getString(2),rs.getString(3)));
				}
				else if (rs.getString(2).equals("NUMBER"))
				{
					parameterRecord[1] = Integer.valueOf(rs.getString(3));
					keys.put(parameterRecord[0], parameterRecord[1]);
					paramList.add(new Parameter(rs.getString(1), rs.getString(2),rs.getString(3)));
				}
				else if (rs.getString(2).equals("BOOLEAN"))
				{
					parameterRecord[1] = Boolean.valueOf(rs.getString(3));
					keys.put(parameterRecord[0], parameterRecord[1]);
					paramList.add(new Parameter(rs.getString(1), rs.getString(2),rs.getString(3)));
				}
				else if (rs.getString(2).equals("DATE"))
				{
				    Date date = Date.valueOf( rs.getString(3).substring(6, 10)+"-"+rs.getString(3).substring(3, 5)+"-"+rs.getString(3).substring(0, 2) );

				    keys.put(parameterRecord[0], date);
				    paramList.add(new Parameter(rs.getString(1), rs.getString(2),rs.getString(3)));
				}
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			logger.error(StringUtils.stack2string(e)) ;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			logger.error(StringUtils.stack2string(e)) ;

		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	System.out.println(e.getMessage());
			logger.error(e.getMessage());
		}
		finally
		{	
			if (con != null)
				con.disconnectDB();
		}

	}

	public static Parameters getInstance() {
		if (instance == null)
		{
			paramList = new ArrayList();
			instance = new Parameters();
		}
		return instance;
	}
	
	public static void reloadParameters()
	{
		initialize();
	}
	
	public static String getString(String key)
	{
		try {
			Object o = Parameters.getKeys().get(key);
			if(o.getClass().toString().indexOf("String")>0) 
			{
				return o.toString();
			}
			else
				return null;

		} catch (NullPointerException e) {
			//System.out.println("getString key : " +key);
			//e.printStackTrace();
			return null;
		}
		catch (RuntimeException e) {
			// TODO Auto-generated catch block
			//System.out.println("getString key : " +key);
			//e.printStackTrace();
			return null;
		}
	}
	
	public static Integer getInteger(String key)
	{
		Object o = Parameters.getKeys().get(key);
		if (o.getClass().toString().indexOf("Integer")>0)
		{
			return Integer.valueOf(o.toString());
		}
		else
			return null;
	}
	
	public static Boolean getBoolean(String key)
	{
		Object o = Parameters.getKeys().get(key);
		if (o.getClass().toString().indexOf("Boolean")>0)
		{
			return Boolean.valueOf(o.toString());
		}
		else
			return null;
	}

	public static Date getDate(String key)
	{
		Object o = Parameters.getKeys().get(key);
		if (o.getClass().toString().indexOf("Date")>0)
		{
			return (Date)o;
		}
		else
			return null;
	}

	public static Hashtable getKeys() {
		return getInstance().keys;
	}

	public static void setKeys(Hashtable keys) {
		Parameters.keys = keys;
	}

	public static ArrayList getParamList() {
		return paramList;
	}

	public static void setParamList(ArrayList paramList) {
		Parameters.paramList = paramList;
	}

	//	Application Freezed ise Exception atar
	public static void checkApplicationStatus() throws RuntimeException 
	{
		if (Parameters.getBoolean("APP_FREEZED").booleanValue())
		{
			throw new RuntimeException();
		}
	}

}
