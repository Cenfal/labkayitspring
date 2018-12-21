package com.thy.loyalty.loyaltyservices.awardoperation.dto;

import com.thy.loyalty.ms.ws.redemption.NonAirIssueAwardDetail;

public class NonAirIssueAwardWithTokenDetail extends NonAirIssueAwardDetail {
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}