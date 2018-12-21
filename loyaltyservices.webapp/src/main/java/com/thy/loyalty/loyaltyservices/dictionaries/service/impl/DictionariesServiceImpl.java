package com.thy.loyalty.loyaltyservices.dictionaries.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jforce.connectors.DBResultSet;
import com.jforce.connectors.oracle.Connector;
import com.thy.loyalty.loyaltyservices.dictionaries.dto.MessageRecord;
import com.thy.loyalty.loyaltyservices.dictionaries.dto.MessageServiceDetail;
import com.thy.loyalty.loyaltyservices.dictionaries.dto.MessageServiceResult;
import com.thy.loyalty.loyaltyservices.dictionaries.dto.SaveMessageDetail;
import com.thy.loyalty.loyaltyservices.dictionaries.dto.SaveMessageResult;
import com.thy.loyalty.loyaltyservices.dictionaries.service.IDictionariesService;
import com.thy.loyalty.loyaltyservices.voluntaryobserver.dto.TypeRecord;
import com.thy.loyalty.loyaltyservices.voluntaryobserver.dto.TypeServiceDetail;
import com.thy.loyalty.loyaltyservices.voluntaryobserver.dto.TypeServiceResult;
import com.thy.loyalty.ms.config.CraneDButils;
import com.thy.loyalty.ms.config.CraneDb;
import com.thy.loyalty.ms.config.DataCache;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.loyalty.ms.utility.dto.CredentialChecker;
import com.thy.loyalty.ms.utility.dto.Utils;
import com.thy.ws.header.request.RequestHeader;

@Service
public class DictionariesServiceImpl implements IDictionariesService {
	private static Log logger = LogFactory
			.getLog(DictionariesServiceImpl.class);

	@Override
	public MessageServiceResult getMessageList(
			MessageServiceDetail messageServiceDetail,
			RequestHeader requestHeader) throws Exception {

		String serviceName = "qmpMessageServices";
		String methodName = "getMessageList";
		String language = (requestHeader.getLanguageCode() == null) ? "EN"
				: Utils.validateRequestLanguage(requestHeader.getLanguageCode());
		DataCache.getInstance().forceUpdate();
		MessageServiceResult messageServiceResult = new MessageServiceResult();
		ArrayList<MessageRecord> messageList = new ArrayList<MessageRecord>();

		if (!CredentialChecker.check(requestHeader.getClientCode(),
				requestHeader.getClientUsername(), null, null, serviceName)) {
			messageServiceResult.setResultCode("03");
			messageServiceResult.setResultDescription(CraneDButils
					.getResultMessage(messageServiceResult.getResultCode(),
							serviceName, methodName, language));
			logger.info(messageServiceResult.getResultDescription());
		}

		DBResultSet ds = DataCache.getInstance().getMessages();
		for (int i = 0; i < ds.getRowCount(); i++) {
			MessageRecord messageRecord = new MessageRecord();
			messageRecord.setKey(ds.getField(i, "KEY"));
			messageRecord.setLanguage(ds.getField(i, "LANG"));
			messageRecord.setMessage(ds.getField(i, "MESSAGE"));
			messageList.add(messageRecord);
		}
		messageServiceResult.setGetMessageList(messageList);
		messageServiceResult.setResultCode("00");
		messageServiceResult.setResultDescription(CraneDButils
				.getResultMessage(messageServiceResult.getResultCode(),
						serviceName, methodName, language));
		return messageServiceResult;
	}
	
	@Override
	public TypeServiceResult getTypeList(
			TypeServiceDetail typeServiceDetail,
			RequestHeader requestHeader) throws Exception {

		String serviceName = "qmpMessageServices";
		String methodName = "getTypeList";
		String language = (requestHeader.getLanguageCode() == null) ? "EN"
				: Utils.validateRequestLanguage(requestHeader.getLanguageCode());
		DataCache.getInstance().forceUpdate();
		TypeServiceResult typeServiceResult = new TypeServiceResult();
		ArrayList<TypeRecord> typeList = new ArrayList<TypeRecord>();

		if (!CredentialChecker.check(requestHeader.getClientCode(),
				requestHeader.getClientUsername(), null, null, serviceName)) {
			typeServiceResult.setResultCode("03");
			typeServiceResult.setResultDescription(CraneDButils
					.getResultMessage(typeServiceResult.getResultCode(),
							serviceName, methodName, language));
			logger.info(typeServiceResult.getResultDescription());
		}

		DBResultSet ds = new DBResultSet(); // DataCache.getInstance().getTypes();
		for (int i = 0; i < ds.getRowCount(); i++) {
			TypeRecord typeRecord = new TypeRecord();
			typeRecord.setId(ds.getFieldInt(i, 1));
			typeRecord.setName(ds.getField(i, 2));
			typeList.add(typeRecord);
		}
		typeServiceResult.setTypeList(typeList);
		typeServiceResult.setResultCode("00");
		typeServiceResult.setResultDescription(CraneDButils
				.getResultMessage(typeServiceResult.getResultCode(),
						serviceName, methodName, language));
		return typeServiceResult;
	}
	
	@Override
	public TypeServiceResult getCategoryList(
			TypeServiceDetail typeServiceDetail,
			RequestHeader requestHeader) throws Exception {

		String serviceName = "qmpMessageServices";
		String methodName = "getCategoryList";
		String language = (requestHeader.getLanguageCode() == null) ? "EN"
				: Utils.validateRequestLanguage(requestHeader.getLanguageCode());
		DataCache.getInstance().forceUpdate();
		TypeServiceResult typeServiceResult = new TypeServiceResult();
		ArrayList<TypeRecord> categoryList = new ArrayList<TypeRecord>();

		if (!CredentialChecker.check(requestHeader.getClientCode(),
				requestHeader.getClientUsername(), null, null, serviceName)) {
			typeServiceResult.setResultCode("03");
			typeServiceResult.setResultDescription(CraneDButils
					.getResultMessage(typeServiceResult.getResultCode(),
							serviceName, methodName, language));
			logger.info(typeServiceResult.getResultDescription());
		}

		DBResultSet ds = new DBResultSet(); //DataCache.getInstance().getCategories();
		for (int i = 0; i < ds.getRowCount(); i++) {
			TypeRecord categoryRecord = new TypeRecord();
			categoryRecord.setId(ds.getFieldInt(i, 1));
			categoryRecord.setName(ds.getField(i, 2));
			categoryList.add(categoryRecord);
		}
		typeServiceResult.setTypeList(categoryList);
		typeServiceResult.setResultCode("00");
		typeServiceResult.setResultDescription(CraneDButils
				.getResultMessage(typeServiceResult.getResultCode(),
						serviceName, methodName, language));
		return typeServiceResult;
	}

	@Override
	public TypeServiceResult getSubcategoryList(
			TypeServiceDetail typeServiceDetail,
			RequestHeader requestHeader) throws Exception {

		String serviceName = "qmpMessageServices";
		String methodName = "getSubcategoryList";
		String language = (requestHeader.getLanguageCode() == null) ? "EN"
				: Utils.validateRequestLanguage(requestHeader.getLanguageCode());
		DataCache.getInstance().forceUpdate();
		TypeServiceResult typeServiceResult = new TypeServiceResult();
		ArrayList<TypeRecord> subcategoryList = new ArrayList<TypeRecord>();

		if (!CredentialChecker.check(requestHeader.getClientCode(),
				requestHeader.getClientUsername(), null, null, serviceName)) {
			typeServiceResult.setResultCode("03");
			typeServiceResult.setResultDescription(CraneDButils
					.getResultMessage(typeServiceResult.getResultCode(),
							serviceName, methodName, language));
			logger.info(typeServiceResult.getResultDescription());
		}

		DBResultSet ds = new DBResultSet();//DataCache.getInstance().getSubcategories();
		for (int i = 0; i < ds.getRowCount(); i++) {
			TypeRecord subcategoryRecord = new TypeRecord();
			subcategoryRecord.setId(ds.getFieldInt(i, 1));
			subcategoryRecord.setName(ds.getField(i, 2));
			subcategoryList.add(subcategoryRecord);
		}
		typeServiceResult.setTypeList(subcategoryList);
		typeServiceResult.setResultCode("00");
		typeServiceResult.setResultDescription(CraneDButils
				.getResultMessage(typeServiceResult.getResultCode(),
						serviceName, methodName, language));
		return typeServiceResult;
	}

	@Override
	public SaveMessageResult saveMessage(
			SaveMessageDetail saveMessageDetail, RequestHeader requestHeader) {
		SaveMessageResult saveMessageResult = new SaveMessageResult();
		
		String ServiceName = "qmpMessageServices";
		String partnerCode = "";
		String partnerUserName = "";
		String channelCode = "";
		String airlineCode = "";
		String application = "";
		String agent = "";
		String language = "";

		logger.info("qmp_pack_messages.insert_message has been called..");

		Connector con = null;
		java.sql.CallableStatement cs = null;

		try {
			partnerCode = requestHeader.getClientCode();
			partnerUserName = requestHeader.getClientUsername();
			channelCode = (requestHeader.getChannel() == null) ? "" : Utils
					.validateChannelType(requestHeader.getChannel());
			airlineCode = requestHeader.getAirlineCode();
			application = requestHeader.getApplication();
			agent = requestHeader.getAgent();
			language = (requestHeader.getLanguageCode() == null) ? "EN" : Utils
					.validateRequestLanguage(requestHeader.getLanguageCode());

			con = CraneDb.getConnection();

			String query = "begin\n"
					+ "  -- Call the procedure\n"
					+ "  qmp_pack_messages.insert_message(i_v_partner_code => :i_v_partner_code,\n"
					+ "                                   i_v_partner_user_name => :i_v_partner_user_name,\n"
					+ "                                   i_v_partner_password => :i_v_partner_password,\n"
					+ "                                   i_v_ip_address => :i_v_ip_address,\n"
					+ "                                   i_v_channel_code => :i_v_channel_code,\n"
					+ "                                   i_v_airline_code => :i_v_airline_code,\n"
					+ "                                   i_v_application => :i_v_application,\n"
					+ "                                   i_v_agent => :i_v_agent,\n"
					+ "                                   i_v_language => :i_v_language,\n"
					+ "                                   i_v_key => :i_v_key,\n"
					+ "                                   i_v_lang => :i_v_lang,\n"
					+ "                                   i_v_message => :i_v_message,\n"
					+ "                                   o_v_response_code => :o_v_response_code,\n"
					+ "                                   o_v_response_description => :o_v_response_description);\n"
					+ "end;";

			cs = con.prepareCall(query);
			// Web service base input Parameters
			cs.setString(1, partnerCode);
			cs.setString(2, partnerUserName);
			cs.setString(3, "");
			cs.setString(4, "");
			cs.setString(5, channelCode);
			cs.setString(6, airlineCode);
			cs.setString(7, application);
			cs.setString(8, agent);
			cs.setString(9, language);
			// //////////////////////////////////
			// Process input parameters
			cs.setString(10, saveMessageDetail.getKey());
			cs.setString(11, saveMessageDetail.getLang());
			cs.setString(12, saveMessageDetail.getMessage());

			// /////////////////////////
			// Process output parameters
			cs.registerOutParameter(13, java.sql.Types.VARCHAR);
			cs.registerOutParameter(14, java.sql.Types.VARCHAR);
			// ///////////////////////////
			con.getData(cs);
			// //////////////////////////////////////
			// set process output parameters
			saveMessageResult.setResultCode(cs.getString(13));
			saveMessageResult.setResultDescription(cs.getString(14));
		} catch (Exception e) {
			logger.error("Error in qmp_pack_messages.insert_message "
					+ StringUtils.stack2string(e));
		}finally {
			try {
				cs.close();

			} catch (SQLException e) {
				logger.error("Error in " + ServiceName + " (SQLException) "
						+ StringUtils.stack2string(e));
			}

			con.disconnectDB();
		}

		return saveMessageResult;
	}
}
