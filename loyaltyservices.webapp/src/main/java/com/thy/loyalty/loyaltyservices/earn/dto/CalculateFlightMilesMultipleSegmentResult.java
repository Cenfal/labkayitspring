package com.thy.loyalty.loyaltyservices.earn.dto;

import java.util.ArrayList;

import com.thy.loyalty.ms.utility.dto.MethodResult;

public class CalculateFlightMilesMultipleSegmentResult extends MethodResult {
	
	private ArrayList<IteneraryMilesEarningResult> iteneraryMilesEarningResultsList;

	public ArrayList<IteneraryMilesEarningResult> getIteneraryMilesEarningResultsList() {
		return iteneraryMilesEarningResultsList;
	}

	public void setIteneraryMilesEarningResultsList(
			ArrayList<IteneraryMilesEarningResult> iteneraryMilesEarningResultsList) {
		this.iteneraryMilesEarningResultsList = iteneraryMilesEarningResultsList;
	}
	
	
	
}
