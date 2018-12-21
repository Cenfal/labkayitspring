package com.thy.loyalty.loyaltyservices.awardoperation.dto;

import com.thy.loyalty.ms.utility.dto.MethodResult;

public class OnlineShoppingGetTokenIDResult extends MethodResult {
	private String token;
	private int tokenExpireMinute;
	private String memberStatus;
	private String validationStatus;
	private int totalMiles;
	private String tier;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getTokenExpireMinute() {
		return tokenExpireMinute;
	}

	public void setTokenExpireMinute(int tokenExpireMinute) {
		this.tokenExpireMinute = tokenExpireMinute;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public String getValidationStatus() {
		return validationStatus;
	}

	public void setValidationStatus(String validationStatus) {
		this.validationStatus = validationStatus;
	}

	public int getTotalMiles() {
		return totalMiles;
	}

	public void setTotalMiles(int totalMiles) {
		this.totalMiles = totalMiles;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}
}
