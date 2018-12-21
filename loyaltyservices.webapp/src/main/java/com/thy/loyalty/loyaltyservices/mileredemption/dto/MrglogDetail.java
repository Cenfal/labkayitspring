package com.thy.loyalty.loyaltyservices.mileredemption.dto;

public class MrglogDetail {
	private int operation_id;
	private String operation_code;
	private String clientTransactionId;
	private String log;

	public int getOperation_id() {
		return operation_id;
	}

	public void setOperation_id(int operation_id) {
		this.operation_id = operation_id;
	}

	public String getOperation_code() {
		return operation_code;
	}

	public void setOperation_code(String operation_code) {
		this.operation_code = operation_code;
	}

	public String getClientTransactionId() {
		return clientTransactionId;
	}

	public void setClientTransactionId(String clientTransactionId) {
		this.clientTransactionId = clientTransactionId;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
}
