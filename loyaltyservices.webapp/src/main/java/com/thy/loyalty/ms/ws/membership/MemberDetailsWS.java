package com.thy.loyalty.ms.ws.membership;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.thy.loyalty.ms.dblog.DBLogRecord;
import com.thy.loyalty.ms.membership.dto.GetMemberDetailsListResponse;
import com.thy.loyalty.ms.membership.dto.MemberDetailsListResponse;
import com.thy.loyalty.ms.membership.service.IListMemberDetailsService;
import com.thy.loyalty.ms.utility.dto.ResponseHeaderManager;
import com.thy.loyalty.ms.utility.dto.Utils;
import com.thy.ws.header.request.RequestHeader;
import com.thy.ws.header.response.Message;
import com.thy.ws.header.response.ResponseHeader;
import com.thy.ws.header.response.StatusCode;


@WebService(serviceName="MemberDetailsWS")
@Service(value="MemberDetailsWS")
public class MemberDetailsWS extends SpringBeanAutowiringSupport
{
	private static Log logger = LogFactory.getLog(MemberDetailsWS.class);
	
	private static final String ServiceName="msMemberDetails";

//	@Autowired
//	private IMemberDetailsService memberDetailsService;

	@Autowired
	private IListMemberDetailsService listMemberDetailsService;

	/**
	 * This method returns membership details as a list by key value pairs, sample data listed below
	 * @param requestHeader {@see com.thy.ws.header.request.RequestHeader}
	 * @param ffid Miles & Smiles membership ID  (Format : TK#########)  - Mandatory
	 * @param pinNumber Pin number which defined to membership for login. - Mandatory
	 * @param name Name of member - Optional
	 * @param surname Surname of member - Optional
	 * @param birthDate Birth date of member (Format : dd.MM.yyyy)  - Optional
	 * @param responseHeader {@see com.thy.ws.header.response.ResponseHeader}
	 * @return MemberDetailsResult
	 *//*
	@WebMethod
	public MemberDetailsResult msMemberDetails( @WebParam(name="requestHeader")		RequestHeader requestHeader, 
										   @WebParam(name = "ffid")					String ffid,
										   @WebParam(name = "pinNumber")			String pinNumber,
										   @WebParam(name = "name")					String name,
										   @WebParam(name = "surname")				String surname,
										   @WebParam(name = "birthDate")			String birthDate,
										   @WebParam(name="responseHeader",mode=javax.jws.WebParam.Mode.OUT) javax.xml.ws.Holder<ResponseHeader> responseHeader) {
		
		MemberDetailsResult memberDetailsResult =  new MemberDetailsResult();
		MemberDetails memberDetails = new MemberDetails();
		DBLogRecord dbLog = new DBLogRecord(requestHeader, ServiceName, "msMemberDetails");

		try {
			
			//log input data
			logger.info("MemberDetailsWS.getMemberDetails method started with parameters :" +
					"requestHeader.setClientCode  : " + requestHeader.getClientCode() + ", " + 
					"requestHeader.setClientUsername  : " + requestHeader.getClientUsername() + ", " +  
					"ffid : " + ffid + ", " + 
					"pinNumber : " + "*****" + ", " +//pinNmber
					"name : " + name + ", " + 
					"surname : " + surname + ", " + 
					"birthDate : " + birthDate);

		    //call member details procedure...
		    memberDetails = memberDetailsService.getMemberDetails( requestHeader.getClientCode() , requestHeader.getClientUsername(), null, null, ffid, pinNumber, name, surname, birthDate);

			// Mevcut servislerin donus class larini bozmamak icin bu yapildi.
		    memberDetailsResult.copyValuesFromMemberDetails(memberDetails);

			ResponseHeaderManager.setResponseHeader(memberDetailsResult, requestHeader,responseHeader);

		    //return 
			dbLog.finish(memberDetailsResult.getResultCode());
		    return memberDetailsResult;
			
		} catch (Exception e) {
			logger.info("Error in -> MemberDetailsWS.msMemberDetails Error Message: " + e.getMessage());

			List<Message> messages = ResponseHeaderManager.getSimpleMessageList(ServiceName,Utils.validateRequestLanguage(requestHeader.getLanguageCode()),"04");
			ResponseHeaderManager.setResponseHeader(memberDetailsResult, requestHeader,responseHeader, StatusCode.FAILURE,messages);

			dbLog.finish(memberDetailsResult.getResultCode());
			return memberDetailsResult;

		} finally {

		}
	
	}
*/
	/**
	 * This method returns membership details as a list by key value pairs, sample data listed below
	 * @param requestHeader {@see com.thy.ws.header.request.RequestHeader}
	 * @param ffid Miles & Smiles membership ID  (Format : TK#########)  - Mandatory
	 * @param pinNumber Pin number which defined to membership for login. - Mandatory
	 * @param name Name of member - Optional
	 * @param surname Surname of member - Optional
	 * @param birthDate Birth date of member (Format : dd.MM.yyyy)  - Optional
	 * @param responseHeader {@see com.thy.ws.header.response.ResponseHeader}
	 * @return MemberDetailsListResponse
	 * <ul>
	 * <li>Key : D_OUT_TITLE 		- Value : Mr.</li>
	 * <li>Key : D_OUT_NAME 		- Value : FRANZ</li>
	 * <li>Key : D_OUT_SURNAME 		- Value : TESTER</li>
	 * <li>Key : D_OUT_FFID 		- Value : TK123456789</li>
	 * <li>Key : D_OUT_BIRTH_DATE 	- Value : 20.01.2001</li>
	 * <li>Key : D_OUT_HOME_PHONE 	- Value : 071176111111</li>
	 * <li>...</li>
	 * </ul>
	 */
	@WebMethod
	public MemberDetailsListResponse msMemberDetailsByList(@WebParam(name="requestHeader")RequestHeader requestHeader, 
											   @WebParam(name = "ffid")						String ffid,
											   @WebParam(name = "pinNumber")				String pinNumber,
											   @WebParam(name = "name")						String name,
											   @WebParam(name = "surname")					String surname,
											   @WebParam(name = "birthDate")				String birthDate,
											   @WebParam(name="responseHeader",mode=javax.jws.WebParam.Mode.OUT) javax.xml.ws.Holder<ResponseHeader> responseHeader) {
		

		GetMemberDetailsListResponse response = new GetMemberDetailsListResponse();
		MemberDetailsListResponse detailsListResponse = new MemberDetailsListResponse();
		DBLogRecord dbLog = new DBLogRecord(requestHeader, ServiceName, "msMemberDetailsByList");

		try {
			
			//log input data
			logger.info("ListMemberDetailsWebService.listMemberDetails method started with parameters :" +
						"requestHeader.setClientCode  : " + requestHeader.getClientCode() + ", " + 
						"requestHeader.setClientUsername  : " + requestHeader.getClientUsername() + ", " +  
						"ffid : " + ffid + 
						"pinNumber : " +"******"+//+ pinNumber + 
						"name : " + name +
						"surname : " + surname +
						"birthDate : " + birthDate);

			response = listMemberDetailsService.listMemberDetails(requestHeader.getClientCode(), requestHeader.getClientUsername(), null, null, ffid, pinNumber, name, surname, birthDate);

			// Mevcut servislerin donus class larini bozmamak icin bu yapildi.
			detailsListResponse.copyValuesFromGetMemberDetailsListResponse(response);

			ResponseHeaderManager.setResponseHeader(detailsListResponse, requestHeader,responseHeader);

			dbLog.finish(detailsListResponse.getResultCode());
			return detailsListResponse;
		    			
		} catch (Exception e) {
			logger.info("Error in -> MemberDetailsWS.msMemberDetailsByList Error Message: " + e.getMessage());

			List<Message> messages = ResponseHeaderManager.getSimpleMessageList(ServiceName,Utils.validateRequestLanguage(requestHeader.getLanguageCode()),"04");
			ResponseHeaderManager.setResponseHeader(detailsListResponse, requestHeader,responseHeader, StatusCode.FAILURE,messages);

			dbLog.finish(detailsListResponse.getResultCode());
			return detailsListResponse;

		} finally {
			
		}
	
	}
}
