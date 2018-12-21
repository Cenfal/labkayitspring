package com.thy.loyalty.loyaltyservices.mileredemption.dto;

public class CheckOrderIDDetail {
	private String orderID;
	private int redemMiles;
	private String operationCode;

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public int getRedemMiles() {
		return redemMiles;
	}

	public void setRedemMiles(int redemMiles) {
		this.redemMiles = redemMiles;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

}
