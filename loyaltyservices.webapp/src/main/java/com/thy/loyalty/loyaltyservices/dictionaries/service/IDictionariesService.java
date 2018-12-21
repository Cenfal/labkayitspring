package com.thy.loyalty.loyaltyservices.dictionaries.service;

import com.thy.loyalty.loyaltyservices.dictionaries.dto.MessageServiceDetail;
import com.thy.loyalty.loyaltyservices.dictionaries.dto.MessageServiceResult;
import com.thy.loyalty.loyaltyservices.dictionaries.dto.SaveMessageDetail;
import com.thy.loyalty.loyaltyservices.dictionaries.dto.SaveMessageResult;
import com.thy.loyalty.loyaltyservices.voluntaryobserver.dto.TypeServiceDetail;
import com.thy.loyalty.loyaltyservices.voluntaryobserver.dto.TypeServiceResult;
import com.thy.ws.header.request.RequestHeader;

public interface IDictionariesService {

	public MessageServiceResult getMessageList(
			MessageServiceDetail messageServiceDetail,
			RequestHeader requestHeader) throws Exception;

	public TypeServiceResult getTypeList(
			TypeServiceDetail typeServiceDetail,
			RequestHeader requestHeader) throws Exception;
	
	public TypeServiceResult getCategoryList(
			TypeServiceDetail typeServiceDetail,
			RequestHeader requestHeader) throws Exception;
	
	public TypeServiceResult getSubcategoryList(
			TypeServiceDetail typeServiceDetail,
			RequestHeader requestHeader) throws Exception;
	
	public SaveMessageResult saveMessage(
			SaveMessageDetail saveMessageDetail, RequestHeader requestHeader);
	
}
