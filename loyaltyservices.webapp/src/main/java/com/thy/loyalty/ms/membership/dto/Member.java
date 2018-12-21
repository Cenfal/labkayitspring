package com.thy.loyalty.ms.membership.dto;

public class Member {

	private String memberId;
	private String memberName;
	private String memberSurname;
	private String memberSex;
	private String memberIdentityCardNo;
	private String memberPrimaryEmailAdress;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberSurname() {
		return memberSurname;
	}
	public void setMemberSurname(String memberSurname) {
		this.memberSurname = memberSurname;
	}
	public String getMemberSex() {
		return memberSex;
	}
	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}
	public String getMemberIdentityCardNo() {
		return memberIdentityCardNo;
	}
	public void setMemberIdentityCardNo(String memberIdentityCardNo) {
		this.memberIdentityCardNo = memberIdentityCardNo;
	}
	public String getMemberPrimaryEmailAdress() {
		return memberPrimaryEmailAdress;
	}
	public void setMemberPrimaryEmailAdress(String memberPrimaryEmailAdress) {
		this.memberPrimaryEmailAdress = memberPrimaryEmailAdress;
	}
	
}
