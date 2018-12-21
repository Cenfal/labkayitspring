package com.thy.loyalty.ms.dblog;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Date;

import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jforce.connectors.Connector;
import com.thy.loyalty.ms.config.CraneDb;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.ws.header.request.ChannelType;
import com.thy.ws.header.request.LanguageCodeType;
import com.thy.ws.header.request.RequestHeader;

public class DBLogRecord {
	
	private static Log logger = LogFactory
			.getLog(DBLogRecord.class);

	private static String success = "SUCCESS !! ";
	private static String failed = "FAILED !! ";
	private static String nullResultCode = " ResultCode is NULL or EMPTY ";

	private RequestHeader requestHeader;
	private String serviceName;
	private String methodName;
	private long lStartTime;
	private long lEndTime;
	private long differenceTime;

	protected String clientCode;
	protected String clientUsername;
	protected ChannelType channel;
	protected String airlineCode;
	protected String application;
	protected String agent;
	protected String clientTransactionId;
	protected LanguageCodeType languageCode;

	private String flyerID = "";
	private int step = 0;
	private Date lStepStartTime;
	private Date lStepEndTime;
	
	private String processGroupID="";
	private long processId;

	public DBLogRecord(RequestHeader requestHeader, String serviceName,
			String methodName) {
		init(requestHeader, serviceName, methodName, "");
	}

	public DBLogRecord(RequestHeader requestHeader, String serviceName,
			String methodName, String flyerID) {
		init(requestHeader, serviceName, methodName, flyerID);
	}

	public DBLogRecord(String clientCode, String clientUsername,
			String channel, String airlineCode, String application,
			String agent, String clientTransactionId, String languageCode,
			String serviceName, String methodName, String flyerID) {

		requestHeader = new RequestHeader();
		//
		requestHeader.setClientCode(clientCode);
		requestHeader.setClientUsername(clientUsername);

		if (!("MOBILE".equals(channel) || "WEB".equals(channel)
				|| "KIOSK".equals(channel) || "STAND_ALONE".equals(channel) || "TKAPP"
					.equals(channel)))
			channel = "WEB";

		ChannelType c = ChannelType.valueOf(channel);
		requestHeader.setChannel(c);

		requestHeader.setAirlineCode(airlineCode);
		requestHeader.setApplication(application);
		requestHeader.setAgent(agent);
		requestHeader.setClientTransactionId(clientTransactionId);

		if ("DE".equalsIgnoreCase(languageCode)) {
			requestHeader.setLanguageCode(LanguageCodeType.GERMAN);

		} else if ("EN".equalsIgnoreCase(languageCode)) {
			requestHeader.setLanguageCode(LanguageCodeType.ENGLISH);
		} else {
			requestHeader.setLanguageCode(LanguageCodeType.TURKISH);
		}

		init(requestHeader, serviceName, methodName, flyerID);
	}

	public void init(RequestHeader requestHeader, String serviceName,
			String methodName, String flyerID) {
		this.requestHeader = requestHeader;
		this.serviceName = serviceName;
		this.methodName = methodName;
		this.lStartTime = new Date().getTime();
		this.flyerID = flyerID;

		this.processId = getProcessIdFromSeq();
		
		start();
	}

	public void start() {
		try {
			String content = "BEGIN";

			DBLogWriter.addDBLog(requestHeader, "", this.serviceName,
					this.methodName, "", content, flyerID, processId);
		} catch (Exception e) {
			//System.out.println(StringUtils.stack2string(e));
			logger.error(StringUtils.stack2string(e)) ;
			
		}
	}

	public void StartStep() {
		try {
			this.lStepStartTime = new Date();

		} catch (Exception e) {
			//System.out.println(StringUtils.stack2string(e));
			logger.error(StringUtils.stack2string(e)) ;
		}
	}

	// public void EndStep(String resultCode, Object obj){
	// try{
	// String explanation= generatelog(obj);
	// EndStep(resultCode,explanation);
	//
	// }catch (Exception e) {
	// System.out.println(StringUtils.stack2string(e));
	// }
	// }
	//
	public void InsertComment(String log) {
		try {
			DBLogWriter.addDBLog_detail(processId, getStep(), "", "",new Date(), new Date(), log,processGroupID);

		} catch (Exception e) {
			//System.out.println(StringUtils.stack2string(e));
			logger.error(StringUtils.stack2string(e)) ;
		}
	}

	public void InsertComment(String log, Object request, Object response) {
		try {
			DBLogWriter.addDBLog_detail(processId, getStep(),generatelog(request), generatelog(response), new Date(),new Date(), log,processGroupID);

		} catch (Exception e) {
			//System.out.println(StringUtils.stack2string(e));
			logger.error(StringUtils.stack2string(e)) ;
		}
	}
	
	public void InsertCommentString(String log, String request, String response) {
		try {
			DBLogWriter.addDBLog_detail(processId, getStep(),request, response, new Date(),new Date(), log,processGroupID);

		} catch (Exception e) {
			//System.out.println(StringUtils.stack2string(e));
			logger.error(StringUtils.stack2string(e)) ;
		}
	}

	public void EndStep(String resultCode, Object request, Object response,String log) {
		try {

			this.lStepEndTime = new Date();
			DBLogWriter.addDBLog_detail(processId, getStep(),generatelog(request), generatelog(response),lStepStartTime, lStepEndTime, log,processGroupID);

		} catch (Exception e) {
			//System.out.println(StringUtils.stack2string(e));
			logger.error(StringUtils.stack2string(e)) ;
		}
	}

	public void EndStepString(String resultCode, String request,
			String response, String log) {
		try {

			this.lStepEndTime = new Date();
			DBLogWriter.addDBLog_detail(processId, getStep(), request,response, lStepStartTime, lStepEndTime, log,processGroupID);

		} catch (Exception e) {
//			System.out.println(StringUtils.stack2string(e));
			logger.error(StringUtils.stack2string(e)) ;
		}
	}

	
	public void EndStepStringWithTime(String log) {
		try {

			this.lStepEndTime = new Date();
			
			long tempDifferenceTime = lStepEndTime.getTime() - lStepStartTime.getTime();
			DecimalFormat df = new DecimalFormat("###0.0000");
			String differenceTimeAsString = df.format(tempDifferenceTime
					/ new Double(1000));
			
			
			DBLogWriter.addDBLog_detail(processId, getStep(), null,
					null, lStepStartTime, lStepEndTime, log + " - Time : " + differenceTimeAsString,this.processGroupID);

		} catch (Exception e) {
			//System.out.println(StringUtils.stack2string(e));
			logger.error(StringUtils.stack2string(e)) ;
		}
	}
	

	public void finish(String resultCode) {
		try {
			this.lEndTime = new Date().getTime();

			this.differenceTime = lEndTime - lStartTime;
			DecimalFormat df = new DecimalFormat("###0.0000");
			String differenceTimeAsString = df.format(this.differenceTime
					/ new Double(1000));

			String content = "end of process";

			if (resultCode == null || resultCode.equals(""))
				content = getNullResultCode() + content;
			else if (resultCode.equals("00") || resultCode.equals("OK") || resultCode.equals("C00"))
				content = getSuccess() + content;
			else
				content = getFailed() + content;

			//DBLogWriter.addDBLog(requestHeader, differenceTimeAsString,this.serviceName, this.methodName, resultCode, content,flyerID, lStartTime);
			DBLogWriter.finishDBLog(processId, differenceTimeAsString, resultCode, content, this.flyerID);
			
		} catch (Exception e) {
			//System.out.println(StringUtils.stack2string(e));
			logger.error(StringUtils.stack2string(e)) ;
		}
	}

	public static String generatelog(Object obj) {
		String log = "";
		String textToBeMasked="#CreditCardNumber#PinNumber#cc_card_number#cc_cvc#cc_expireDate";
		String filedValue="";

		try {
			if (obj != null) {
				java.lang.reflect.Field[] fields = obj.getClass()
						.getDeclaredFields();

				for (int i = 0; i < fields.length; i++) {
					try {
						fields[i].setAccessible(true);

						if (
								//(((java.lang.reflect.Field) fields[i]).get(obj) != null) && 
								!(((java.lang.reflect.Field) fields[i]).getName().equalsIgnoreCase("serialVersionUID"))) {

							filedValue="";
							
							if (((java.lang.reflect.Field) fields[i]).get(obj) != null) {
								filedValue = ((java.lang.reflect.Field) fields[i]).get(obj).toString();
							}
							
							
							if (textToBeMasked.toLowerCase().contains(((java.lang.reflect.Field) fields[i]).getName().toLowerCase()) && ((java.lang.reflect.Field) fields[i]).get(obj) != null)
							{
								filedValue=String.format("%"+filedValue.length()+"s", "").replace(' ', '*');
							}
							
							log = log + ((java.lang.reflect.Field) fields[i]).getName() 
									  + " = "
									  + filedValue
									  + "\n";

							// System.out.print(((java.lang.reflect.Field)
							// fields[i])+ " = "); // field type
							// System.out.print(((java.lang.reflect.Field)
							// fields[i]).getName() + " / "); // field name
							// System.out.println(((java.lang.reflect.Field)
							// fields[i]).get(obj)); // field value

						}
					} catch (IllegalAccessException e) {
						return e.getStackTrace().toString();
					}
				}
			}
			else{
				log="";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log="*****Exception in DBLogRecord.java generatelog method..";
		}
		
		
		return log;
	}
	
	public static String ExceptionTracetoStr(Exception e){
		String str="";
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		str=sw.toString(); // stack trace as a string
		
		if(str.length()>3908){
			str=str.substring(1,3908);
		}
		
		return str;
	}
	

	public int getStep() {
		step = step + 1;
		return step;
	}

	public static String getSuccess() {
		return success;
	}

	public static String getFailed() {
		return failed;
	}

	public static String getNullResultCode() {
		return nullResultCode;
	}

	public static void setNullResultCode(String nullResultCode) {
		DBLogRecord.nullResultCode = nullResultCode;
	}

	public String getApplication() {
		return this.requestHeader.getApplication();
	}

	public long getlStartTime() {
		return lStartTime;
	}

	public String getClientTransactionId() {
		return this.requestHeader.getClientTransactionId();
	}
	public String getProcessGroupID() {
		return processGroupID;
	}

	public void setProcessGroupID(String processGroupID) {
		this.processGroupID = processGroupID;
	}
	
	/* 27.01.2016 - e_akyildiz - get process id from db sequence */
	private long getProcessIdFromSeq(){
		long returnValue = 0;
		
		Connector con = null;
    	String sql = "SELECT dblog_for_ws_processid_seq.nextval FROM dual";
    	
    	try {
    		con = CraneDb.getConnection();
    		Statement stmt = con.conn.createStatement();
    		ResultSet rs = stmt.executeQuery(sql);
    		
    		if(rs.next()) {
    			returnValue = rs.getLong(1);
    		}
    		
    		con.disconnectDB();
    		
    	} catch (ArrayIndexOutOfBoundsException aioobe) {
    		returnValue = -1;
    	} catch (SQLException e) {
    		returnValue = -2;
    	} catch (NamingException e) {
    		returnValue = -3;
		} finally {
    		con.disconnectDB();
    	}
		
		return returnValue;
	}

	public long getProcessId() {
		return processId;
	}

	public void setProcessId(long processId) {
		this.processId = processId;
	}

	public void setFlyerID(String flyerID) {
		this.flyerID = flyerID;
	}
	
	
}
