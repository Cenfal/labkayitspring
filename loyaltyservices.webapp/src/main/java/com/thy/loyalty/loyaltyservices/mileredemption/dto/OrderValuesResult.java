package com.thy.loyalty.loyaltyservices.mileredemption.dto;

import java.util.ArrayList;

import com.thy.loyalty.ms.utility.dto.MethodResult;

public class OrderValuesResult extends MethodResult {
	private ArrayList<KeyValue> orderIdValues;
	private ArrayList<Parameter> partnerParameterList;

	public ArrayList<KeyValue> getOrderIdValues() {
		return orderIdValues;
	}

	public void setOrderIdValues(ArrayList<KeyValue> orderIdValues) {
		this.orderIdValues = orderIdValues;
	}

	public ArrayList<Parameter> getPartnerParameterList() {
		return partnerParameterList;
	}

	public void setPartnerParameterList(
			ArrayList<Parameter> partnerParameterList) {
		this.partnerParameterList = partnerParameterList;
	}
}
