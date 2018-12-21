package com.thy.loyalty.loyaltyservices.mileredemption.dto;

import com.thy.loyalty.ms.utility.dto.MethodResult;

public class GetOrderIDResult extends MethodResult {
	private String orderID;
	private String memberVerifyOtpOnce;

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getMemberVerifyOtpOnce() {
		return memberVerifyOtpOnce;
	}

	public void setMemberVerifyOtpOnce(String memberVerifyOtpOnce) {
		this.memberVerifyOtpOnce = memberVerifyOtpOnce;
	}
}
