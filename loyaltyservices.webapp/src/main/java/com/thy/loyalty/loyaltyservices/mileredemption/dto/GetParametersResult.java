package com.thy.loyalty.loyaltyservices.mileredemption.dto;

import java.util.ArrayList;

import com.thy.loyalty.ms.utility.dto.MethodResult;

public class GetParametersResult extends MethodResult {
	private ArrayList<Parameter> parameterList;

	public ArrayList<Parameter> getParameterList() {
		return parameterList;
	}

	public void setParameterList(ArrayList<Parameter> parameterList) {
		this.parameterList = parameterList;
	}
}