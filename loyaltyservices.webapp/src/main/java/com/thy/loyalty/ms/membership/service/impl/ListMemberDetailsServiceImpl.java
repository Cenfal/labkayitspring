package com.thy.loyalty.ms.membership.service.impl;

import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.thy.loyalty.ms.config.WsConfig;
import com.thy.loyalty.ms.membership.dto.GetMemberDetailsListResponse;
import com.thy.loyalty.ms.membership.dto.MSKeyValuePair;
import com.thy.loyalty.ms.membership.dto.MemberDetailsList;
import com.thy.loyalty.ms.membership.service.IListMemberDetailsService;
import com.thy.loyalty.ms.ws.w3.GetMemberDetailsDetail;
import com.thy.loyalty.ms.ws.w3.GetMemberDetailsResult;
import com.thy.loyalty.ms.ws.w3.MemberDetailsService;
import com.thy.loyalty.ms.ws.w3.MsKeyValuePairW3;
import com.thy.loyalty.ms.ws.w3.W3MemberDetailsService;
import com.thy.loyalty.ws.requestheader.ChannelType;
import com.thy.loyalty.ws.requestheader.RequestHeader;
import com.thy.loyalty.ws.responseheader.ResponseHeader;

@Service
public class ListMemberDetailsServiceImpl implements IListMemberDetailsService {
	
	private static org.apache.commons.logging.Log logger = LogFactory.getLog(ListMemberDetailsServiceImpl.class);

	@Override
	public GetMemberDetailsListResponse listMemberDetails(	String companyCode,
														String companyUsername, 
														String companyPassword, 
														String ip,
														String ffid,
														String pinNumber, 
														String name, 
														String surname, 
														String birthDate) {
		
		GetMemberDetailsListResponse response = new GetMemberDetailsListResponse();
		MemberDetailsList detailList = new MemberDetailsList();
		
		GetMemberDetailsResult result = new GetMemberDetailsResult();
		W3MemberDetailsService memberDetailService = new W3MemberDetailsService();
		MemberDetailsService memberDetailPort = memberDetailService
				.getMemberDetailsServicePort();

		BindingProvider bp = (BindingProvider) memberDetailPort;

		// servis bilgileri
		String endpointURL = WsConfig.getInstance().MEMBER_DETAILS_SERVICE_ENDPOINT;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				endpointURL);
		if ("FIREWALL".equals(WsConfig.getInstance().SERVICE_ACCESS_TYPE)) {
			bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
					WsConfig.getInstance().FIREWALL_USERNAME);
			bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
					WsConfig.getInstance().FIREWALL_PASSWORD);
		}

		List handlerChain = bp.getBinding().getHandlerChain();
		bp.getBinding().setHandlerChain(handlerChain);

		try {
			GetMemberDetailsDetail getMemberDetailsDetail = new GetMemberDetailsDetail();
			RequestHeader requestHeader = new RequestHeader();
			requestHeader.setLanguageCode("TR");
			requestHeader.setClientUsername(WsConfig.getInstance().WS_CLM_CLIENT_USERNAME);
			requestHeader.setClientCode(WsConfig.getInstance().WS_CLM_CLIENT_CODE);
			requestHeader.setChannel(ChannelType.WEB);
			requestHeader.setAirlineCode(WsConfig.getInstance().WS_AIRLINE_CODE);
			requestHeader.setAgent(WsConfig.getInstance().WS_HEADER_AGENT);
			requestHeader
					.setApplication(WsConfig.getInstance().WS_HEADER_APPLICATION);
			requestHeader.setClientTransactionId((new java.rmi.server.UID())
					.toString());


			getMemberDetailsDetail.setFfid(ffid);

			Holder<ResponseHeader> responseHeader = new Holder<ResponseHeader>();
			result = memberDetailPort.getMemberDetails(requestHeader,
					getMemberDetailsDetail, responseHeader);
			
			//RESPONSEHEADER DA HATA KONTROLU YAP
			if(!"MS01102200".equals(responseHeader.value.getMessages().get(0).getMessageCode()))
			{
				result.getMemberDataKVPair().clear();
			}
			String errorCode = responseHeader.value.getMessages().get(0).getMessageCode();
			response.setErrorCode(errorCode.substring(errorCode.length()-2, errorCode.length()));
			
		} catch (Exception e) {
			logger.error("Error at getMemberDetails(): " + e.getMessage());
		}

		if (result.getMemberDataKVPair() != null) {
			for(MsKeyValuePairW3 key : result.getMemberDataKVPair())
			{
				MSKeyValuePair item = new MSKeyValuePair();
				item.setFormat(key.getFormat());
				item.setKey(key.getKey());
				item.setType(key.getType());
				item.setValue(key.getValue());
				detailList.addKVListItem(item);
			}
			response.setMemberDetailsList(detailList);
		}
				
		
		/*Connector con = null;
		
		CallableStatement cs = null;
		
		String getMemberDetailsQuery = "";
		
		try {
		    con = CraneDb.getConnection();

			getMemberDetailsQuery = "BEGIN " +
											"ms_pack_esb_membership.ms_list_member_details(  ?," + //1-p_in_partner_code
											"?," + //2-p_in_username
											"?," + //3-p_in_password
											"?," + //4-p_in_ip_address
											"?," + //5-p_in_ffid
											"?," + //6-p_in_pinnumber
											"?," + //7-p_in_name 
											"?," + //8-p_in_surname
											"?," + //9-p_in_birth_date
											"?," + //10-p_out_member_details_cursor
											"?," + //11-p_out_parameter_header_seq
											"?," + //12-p_out_response_code
											"?); " + //13-p_out_response_description
									"END;";
			
			cs = con.prepareCall(getMemberDetailsQuery);
			
			cs.setString(1, companyCode); //1-p_in_partner_code
			cs.setString(2, companyUsername); //2-p_in_username
			cs.setString(3, companyPassword); //3-p_in_password
			cs.setString(4, ip); //4-p_in_ip_address
			cs.setString(5, ffid); //5-p_in_ffid
			cs.setString(6, pinNumber); //6-p_in_pinnumber
			cs.setString(7, name); //7-p_in_name
			cs.setString(8, surname); //8-p_in_surname
			cs.setString(9, birthDate); //9-p_birth_date
			
			cs.registerOutParameter(10, OracleTypes.CURSOR); //10-p_out_member_details_cursor
			cs.registerOutParameter(11, java.sql.Types.NUMERIC); //11-p_out_parameter_header_seq
			cs.registerOutParameter(12, java.sql.Types.VARCHAR); //12-p_out_response_code
			cs.registerOutParameter(13, java.sql.Types.VARCHAR); //13-p_out_response_description
			
			con.getData(cs);
			
			ResultSet rs = null; 
			try { rs = (ResultSet)cs.getObject(10); }catch (SQLException e) {	}
			
			if(rs != null)
				response.setMemberDetailsList(CraneDButils.transposeResultSet(rs));
			
			//System.out.println(cs.getInt(11));
			
			response.setErrorCode(cs.getString(12));
			response.setErrorDescription(" "); */
		
			return response;

		/*} catch (Exception e) {

			logger.error(e);
			
			logger.error(StringUtils.stack2string(e));
			
			response.setErrorCode("04");
			response.setErrorDescription(e.getMessage());
			
			return response;
			
		} finally {
			
			try { cs.close(); } catch (Exception e2) {}

			if(con != null)
				con.disconnectDB();
			
		}*/
	}
}
