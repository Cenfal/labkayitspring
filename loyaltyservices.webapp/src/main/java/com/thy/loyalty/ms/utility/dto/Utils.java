package com.thy.loyalty.ms.utility.dto;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.thy.ws.header.request.ChannelType;
import com.thy.ws.header.request.LanguageCodeType;

public class Utils {
	
	
	private static final String HEADER_X_FORWARDED_FOR = "X-FORWARDED-FOR";
	private static final String ServiceDefaultLanguage = "EN";
	
	public Utils() {
		// TODO Auto-generated constructor stub
	}
	
	public static String getIpFromWebServiceContext(WebServiceContext wsContext )
	{
		String reqIp = getXForwardedIpFromWebServiceContext(wsContext);
		
		if (reqIp.equals(""))
		{
			MessageContext mc = wsContext.getMessageContext();
			HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
			reqIp = req.getRemoteAddr();
		}

		return reqIp;
	}
	
	public static String getIpFromMessageContext(MessageContext messageContext )
	{
		String reqIp = getXForwardedIpFromMessageContext(messageContext);
		
		if (reqIp.equals(""))
		{
			MessageContext mc = messageContext;
			HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
			reqIp = req.getRemoteAddr();
		}
		
		return reqIp;
	}
	
	public static String getXForwardedIpFromMessageContext(MessageContext messageContext )
	{
		MessageContext mc = messageContext;
		HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
		String reqIp = "";        
        String temp;        
        if ((temp = req.getHeader(HEADER_X_FORWARDED_FOR)) != null) {            
        	reqIp = temp;  
        // mil-304	System.out.println("HEADER_X_FORWARDED_FOR IP : " + temp);
        	int idx = reqIp.indexOf(',');            
        	if (idx > -1) {                
        		reqIp = reqIp.substring(0, idx);            
        	}        
        }        
        
        return reqIp;
	}

	public static String getXForwardedIpFromWebServiceContext(WebServiceContext wsContext )
	{
		MessageContext mc = wsContext.getMessageContext();
		HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST); 
		String reqIp = "";        
		String temp;        
		if ((temp = req.getHeader(HEADER_X_FORWARDED_FOR)) != null) {            
			reqIp = temp;  
			// mil-304 System.out.println("HEADER_X_FORWARDED_FOR IP : " + temp);
			int idx = reqIp.indexOf(',');            
			if (idx > -1) {                
				reqIp = reqIp.substring(0, idx);            
			}        
		}        
		
		return reqIp;
	}
	
	public static String generateGUID () {

        // Creating a random UUID (Universally unique identifier).
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        
        return randomUUIDString;

	 }
	
	public static String validateLanguage(String language)
	{
		if (language == null || language.trim().length() == 0)
		{
			return ServiceDefaultLanguage;
		}
		return language.toUpperCase();
	}

	public static String validateRequestLanguage(LanguageCodeType language)
	{
		String lang = "";

		if (language == null)
		{	lang = ServiceDefaultLanguage;	}
		else
		{	lang = language.value().toString();	}

		return lang.toUpperCase();
	}

	public static String validateChannelType(ChannelType channelType)
	{
		String channel = "";
		
		if (channelType == null)
		{	channel = null;	}
		else
		{	channel = channelType.value().toString();	}
		
		return channel.toUpperCase();
	}
	
    
    /**
     * Adds thousands separator to the input. 
     * If the input is not numeric, returns the input back.
     * @param input
     * @return
     */
    public static String formatCurrency(String input) {
		String output = "";
		String decimalPoints = "";
		String sign = "";
		
		if(input == null) {
			return "0";
		}
		
		//check if input is a number
		try {
			double check = Double.parseDouble(input);
		}catch (NumberFormatException e) {
			//if the input is not a number then return input;
			return input;
		}
		//keep the sign of the input
		if(input.substring(0,1).equals("+")||input.substring(0,1).equals("-")) {
			sign = input.substring(0,1);
			input = input.substring(1);
		}
		//keep the decimal points of the input
		if(input.indexOf(',')>0) {
			decimalPoints = input.substring(input.indexOf(","));
			input = input.substring(0, input.indexOf(","));
		}
		
		//if there is already points remove them
		String temp = "";
		if(input.indexOf(".") > 0) {
			for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i)!='.')
				temp += input.charAt(i);
			}
			input = temp;
		}
		
		//format input
		while(input.length()>0) {
			if(input.length() > 3) {
				if(input.length()%3==0) {
					output = output + input.substring(0, 3) + ".";
					input = input.substring(3);
				}else if(input.length()%3==1) {
					output = output + input.substring(0, 1) + ".";
					input = input.substring(1);
				}else if(input.length()%3==2) {
					output = output + input.substring(0, 2) + ".";
					input = input.substring(2);
				}
			}else {
				output = output + input;
				input = "";
			}
		}
		//add sign and decimal points again
		output = sign + output + decimalPoints;
		//return
		return output;
	}
    
    

}
