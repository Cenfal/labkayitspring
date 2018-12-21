package com.thy.loyalty.ms.utility.dto;

import java.util.ArrayList;
import java.util.List;

import com.thy.loyalty.ms.config.CraneDButils;
import com.thy.ws.header.request.RequestHeader;
import com.thy.ws.header.response.Message;
import com.thy.ws.header.response.MessageType;
import com.thy.ws.header.response.ResponseHeader;
import com.thy.ws.header.response.StatusCode;


public class ResponseHeaderManager {

	public static <E extends ServiceResult> void setResponseHeader(E object,
																   RequestHeader requestHeader,
																   javax.xml.ws.Holder<ResponseHeader> responseHeader)
	{

		String serverTransactionId = Utils.generateGUID();

		ResponseHeader responseH = new ResponseHeader();
		responseHeader.value = responseH;

		if (requestHeader.getClientTransactionId() != null)
			responseH.setClientTransactionId(requestHeader.getClientTransactionId());

		responseH.setServerTransactionId(serverTransactionId);
		
		if (object.getResultCode() != null && (object.getResultCode().equals("00") || object.getResultCode().toUpperCase().equals("OK")))
		{	
			responseH.setStatusCode(StatusCode.SUCCESS);	

			Message m = new Message();
			m.setMessageType(MessageType.INFO);
			m.setMessageCode(object.getResultCode());
			m.setLocalizedDescription(object.getResultDescription());

			responseH.getMessages().add(m);
		}
		else 
		{	
			responseH.setStatusCode(StatusCode.FAILURE);

			Message m = new Message();
			m.setMessageType(MessageType.WARNING);
			m.setMessageCode(object.getResultCode());
			m.setReason(object.getResultDescription());

			responseH.getMessages().add(m);
		}

	}

	public static <E extends ServiceResult> void setResponseHeader(E object,RequestHeader requestHeader,javax.xml.ws.Holder<ResponseHeader> responseHeader,StatusCode statusCode,List<Message> messageList)
	{

		String serverTransactionId = Utils.generateGUID();
		
		ResponseHeader responseH = new ResponseHeader();
		responseHeader.value = responseH;

		responseH.setClientTransactionId(requestHeader.getClientTransactionId());
		responseH.setServerTransactionId(serverTransactionId);

		responseH.setStatusCode(statusCode);

		for (Message m : messageList)
		{
			responseH.getMessages().add(m);
		}

	}
	
	public static <E extends MethodResult> void setResponseHeader(E object,
			RequestHeader requestHeader,
			javax.xml.ws.Holder<ResponseHeader> responseHeader)
	{
		
		String serverTransactionId = Utils.generateGUID();
		
		ResponseHeader responseH = new ResponseHeader();
		responseHeader.value = responseH;
		
		if (requestHeader.getClientTransactionId() != null)
			responseH.setClientTransactionId(requestHeader.getClientTransactionId());
		
		responseH.setServerTransactionId(serverTransactionId);
		
		if (object.getResultCode() != null && (object.getResultCode().equals("00") || object.getResultCode().toUpperCase().equals("OK") ))
		{	
			responseH.setStatusCode(StatusCode.SUCCESS);	
			
			Message m = new Message();
			m.setMessageType(MessageType.INFO);
			m.setMessageCode(object.getResultCode());
			m.setLocalizedDescription(object.getResultDescription());
			m.setReason(object.getResultDescription());

			responseH.getMessages().add(m);
		}
		else 
		{	
			responseH.setStatusCode(StatusCode.FAILURE);
			
			Message m = new Message();
			m.setMessageType(MessageType.WARNING);
			m.setMessageCode(object.getResultCode());
			m.setReason(object.getResultDescription());
			m.setLocalizedDescription(object.getResultDescription());

			responseH.getMessages().add(m);
		}
		
	}
	
	public static <E extends MethodResult> void setResponseHeader(E object,RequestHeader requestHeader,javax.xml.ws.Holder<ResponseHeader> responseHeader,StatusCode statusCode,List<Message> messageList)
	{
		
		String serverTransactionId = Utils.generateGUID();
		
		ResponseHeader responseH = new ResponseHeader();
		responseHeader.value = responseH;
		
		responseH.setClientTransactionId(requestHeader.getClientTransactionId());
		responseH.setServerTransactionId(serverTransactionId);
		
		responseH.setStatusCode(statusCode);
		
		for (Message m : messageList)
		{
			responseH.getMessages().add(m);
		}
		
	}

	public static List<Message> getSimpleMessageList(String serviceName,String language,String errorCode)
	{
		Message m = new Message();
		m.setMessageCode(errorCode);
		m.setReason(CraneDButils.getResultMessage(errorCode, serviceName, language));
		m.setMessageType(MessageType.ERROR);

		List<Message> messages = new ArrayList<Message>();
		messages.add(m);
		
		return messages;
	}

	public static List<Message> getSimpleMessageList(String messageCode,String message)
	{

		Message m = new Message();
		m.setMessageCode(messageCode);
		m.setReason(message);
		m.setMessageType(MessageType.ERROR);
		
		List<Message> messages = new ArrayList<Message>();
		messages.add(m);
		
		return messages;
	}


}
