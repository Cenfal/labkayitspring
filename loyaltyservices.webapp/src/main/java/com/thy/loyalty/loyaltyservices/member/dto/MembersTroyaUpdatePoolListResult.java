package com.thy.loyalty.loyaltyservices.member.dto;

import java.util.List;

import com.thy.loyalty.ms.utility.dto.MethodResult;

public class MembersTroyaUpdatePoolListResult extends MethodResult {

	private List<String> listMemberId;

	public List<String> getListMemberId() {
		return listMemberId;
	}

	public void setListMemberId(List<String> listMemberId) {
		this.listMemberId = listMemberId;
	}

}
