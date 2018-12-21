package com.thy.loyalty.loyaltyservices.awardoperation.dto;

import com.thy.loyalty.ms.ws.redemption.NonAirIssueAwardDetail;

public class NonAirIssueAwardWithOrderIDDetail extends NonAirIssueAwardDetail {

	private String orderID;
	private String operationCode;

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}
}
