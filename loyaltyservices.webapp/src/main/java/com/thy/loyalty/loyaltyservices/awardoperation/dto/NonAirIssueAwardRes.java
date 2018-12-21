package com.thy.loyalty.loyaltyservices.awardoperation.dto;

import com.thy.loyalty.ms.utility.dto.MethodResult;
import com.thy.loyalty.ms.ws.redemption.NonAirIssueAwardResult;

public class NonAirIssueAwardRes extends MethodResult {

	
	public NonAirIssueAwardRes() {
		// TODO Auto-generated constructor stub
	}

	private NonAirIssueAwardResult nonAirIssueAwardResult;

	public NonAirIssueAwardResult getNonAirIssueAwardResult() {
		return nonAirIssueAwardResult;
	}

	public void setNonAirIssueAwardResult(
			NonAirIssueAwardResult nonAirIssueAwardResult) {
		this.nonAirIssueAwardResult = nonAirIssueAwardResult;
	}
	

}