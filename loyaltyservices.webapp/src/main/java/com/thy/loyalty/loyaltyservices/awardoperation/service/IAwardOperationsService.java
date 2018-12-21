package com.thy.loyalty.loyaltyservices.awardoperation.service;

import com.thy.loyalty.loyaltyservices.awardoperation.dto.NonAirIssueAwardWithOrderIDDetail;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.NonAirIssueAwardWithOrderIDResult;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.NonAirIssueAwardWithTokenDetail;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.NonAirIssueAwardWithTokenResult;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.OnlineShoppingGetTokenIDDetail;
import com.thy.loyalty.loyaltyservices.awardoperation.dto.OnlineShoppingGetTokenIDResult;

public interface IAwardOperationsService {

	public NonAirIssueAwardWithTokenResult nonAirIssueAwardWithToken(
			String clientCode,
			String clientUserName,
			String channel,
			String airlineCode,
			String application,
			String agencyCode,
			String agent,
			String language,
			NonAirIssueAwardWithTokenDetail nonAirIssueAwardWithTokenDetail);

	public NonAirIssueAwardWithOrderIDResult nonAirIssueAwardWithOrderID(
			String clientCode,
			String clientUserName,
			String channel,
			String airlineCode,
			String application,
			String agencyCode,
			String agent,
			String language,
			NonAirIssueAwardWithOrderIDDetail nonAirIssueAwardWithOrderIDDetail)
			throws Exception;

	public OnlineShoppingGetTokenIDResult OnlineShoppingGetTokenID(
			String clientCode,
			String clientUserName,
			String channel,
			String airlineCode,
			String application,
			String agencyCode,
			String agent,
			String language,
			OnlineShoppingGetTokenIDDetail onlineShoppingGetTokenIDDetail);

}
