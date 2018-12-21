package com.thy.loyalty.loyaltyservices.earn.service;

import com.thy.loyalty.loyaltyservices.earn.dto.CalculateFlightMilesMultipleSegmentDetail;
import com.thy.loyalty.loyaltyservices.earn.dto.CalculateFlightMilesMultipleSegmentResult;
import com.thy.ws.header.request.RequestHeader;

public interface ICalculateFlightMilesService {

	public CalculateFlightMilesMultipleSegmentResult calculateFlightMilesMultipleSegment(RequestHeader requestHeader,CalculateFlightMilesMultipleSegmentDetail calculateFlightMilesMultipleSegmentDetail);

}
