package com.thy.loyalty.loyaltyservices.dictionaries.dto;

import java.util.ArrayList;

import com.thy.loyalty.ms.utility.dto.MethodResult;

public class MessageServiceResult extends MethodResult {

	private ArrayList<MessageRecord> getMessageList;

	public ArrayList<MessageRecord> getGetMessageList() {
		return getMessageList;
	}

	public void setGetMessageList(ArrayList<MessageRecord> getMessageList) {
		this.getMessageList = getMessageList;
	}
}
