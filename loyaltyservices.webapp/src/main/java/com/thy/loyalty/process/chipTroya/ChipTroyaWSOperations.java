package com.thy.loyalty.process.chipTroya;

import java.util.ArrayList;
import java.util.List;

import com.thy.loyalty.loyaltyservices.member.dto.MembersTroyaUpdatePoolDto;
import com.thy.loyalty.loyaltyservices.member.service.impl.MemberOperationServiceDAO;

public class ChipTroyaWSOperations {


	public static List<String> getMembersTroyaUpdatePoolListByMemberId(String memberId) {

		List<String> returnList = new ArrayList<String>();
		List<MembersTroyaUpdatePoolDto> list = MemberOperationServiceDAO.getMembersTroyaUpdatePoolListByMemberId(memberId);
		for (MembersTroyaUpdatePoolDto membersTroyaUpdatePoolDto : list) {
			returnList.add(membersTroyaUpdatePoolDto.getMemberId());
		}
		
		return returnList;
	}

	public static List<String> getMembersTroyaUpdatePoolListByStatus(List<String> statusList) {

		List<String> returnList = new ArrayList<String>();
		List<MembersTroyaUpdatePoolDto> listMembersTroyaUpdatePool = MemberOperationServiceDAO.getMembersTroyaUpdatePoolListByStatus(statusList);
		
		for (MembersTroyaUpdatePoolDto membersTroyaUpdatePoolDto : listMembersTroyaUpdatePool) {
			returnList.add(membersTroyaUpdatePoolDto.getMemberId());
		}
		
		return returnList;
	}

	public static Integer insertMember(String memberId) throws Exception{
		
		int seq = MemberOperationServiceDAO.insertMember(memberId);
		
		return seq;
	}

	public static void updateMemberStatus(String memberId, String status, String message) throws Exception{
		
		MemberOperationServiceDAO.updateMemberStatus(memberId, status, message);
		
	}

}
