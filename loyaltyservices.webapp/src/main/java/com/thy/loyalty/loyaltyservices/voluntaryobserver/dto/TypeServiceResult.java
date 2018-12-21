package com.thy.loyalty.loyaltyservices.voluntaryobserver.dto;

import java.util.ArrayList;

import com.thy.loyalty.ms.utility.dto.MethodResult;

public class TypeServiceResult extends MethodResult {

	private ArrayList<TypeRecord> typeList;

	public ArrayList<TypeRecord> getTypeList() {
		return typeList;
	}

	public void setTypeList(ArrayList<TypeRecord> typeList) {
		this.typeList = typeList;
	}
}
