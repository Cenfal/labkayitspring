package com.thy.loyalty.ms.config.services;

import java.util.ArrayList;

public class Method {

	private String name;
	private String transactionIdUsage;
	private String transactionIdParamName;
	private String transactionIdPosition;
	private String transactionIdNotExistingAction;
	
//	<transactionIdNotExistingAction>Reject|Generate</transactionIdNotExistingAction>
//	<transactionIdUsage>Mandatory|Optional</transactionIdUsage>
//	<transactionIdParamName>transactionId|ReqSeq</transactionIdParamName>
//	<transactionIdPosition>Body|Header</transactionIdPosition>

	private ArrayList<Parameter> parameters = new ArrayList<Parameter>();

	public Method() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Parameter> parameters) {
		this.parameters = parameters;
	}

	public String getTransactionIdUsage() {
		return transactionIdUsage;
	}

	public void setTransactionIdUsage(String transactionIdUsage) {
		this.transactionIdUsage = transactionIdUsage;
	}

	public String getTransactionIdParamName() {
		return transactionIdParamName;
	}

	public void setTransactionIdParamName(String transactionIdParamName) {
		this.transactionIdParamName = transactionIdParamName;
	}

	public String getTransactionIdPosition() {
		return transactionIdPosition;
	}

	public void setTransactionIdPosition(String transactionIdPosition) {
		this.transactionIdPosition = transactionIdPosition;
	}

	public String getTransactionIdNotExistingAction() {
		return transactionIdNotExistingAction;
	}

	public void setTransactionIdNotExistingAction(
			String transactionIdNotExistingAction) {
		this.transactionIdNotExistingAction = transactionIdNotExistingAction;
	}

}
