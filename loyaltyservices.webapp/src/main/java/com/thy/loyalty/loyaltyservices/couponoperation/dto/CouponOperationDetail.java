package com.thy.loyalty.loyaltyservices.couponoperation.dto;

public class CouponOperationDetail {
	
	private Long accountId;
	private String memberId;
	private Long couponCode;
	private String couponType;
	private String partner;
	private String partnerTransactionNo;
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Long getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(Long couponCode) {
		this.couponCode = couponCode;
	}
	public String getCouponType() {
		return couponType;
	}
	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getPartnerTransactionNo() {
		return partnerTransactionNo;
	}
	public void setPartnerTransactionNo(String partnerTransactionNo) {
		this.partnerTransactionNo = partnerTransactionNo;
	}
	
}
