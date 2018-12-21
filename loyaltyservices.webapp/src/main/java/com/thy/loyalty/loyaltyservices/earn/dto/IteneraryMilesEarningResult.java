package com.thy.loyalty.loyaltyservices.earn.dto;

import java.util.ArrayList;

public class IteneraryMilesEarningResult {
	
	private int iteneraryIndex;
	
	private int segmentCount;
	
	private int baseMiles;
	private int promoMiles;
	private int totalMiles;
	
	private int basePoint;
	private int promoPoints;
	private int totalPoints;
	
	private ArrayList<ItenerarySegmentResult> itenerarySegmentResultList;
	
	private boolean showItenarary;
	

	public int getIteneraryIndex() {
		return iteneraryIndex;
	}

	public void setIteneraryIndex(int iteneraryIndex) {
		this.iteneraryIndex = iteneraryIndex;
	}

	public int getSegmentCount() {
		return segmentCount;
	}

	public void setSegmentCount(int segmentCount) {
		this.segmentCount = segmentCount;
	}

	public int getBaseMiles() {
		return baseMiles;
	}

	public void setBaseMiles(int baseMiles) {
		this.baseMiles = baseMiles;
	}

	public int getPromoMiles() {
		return promoMiles;
	}

	public void setPromoMiles(int promoMiles) {
		this.promoMiles = promoMiles;
	}

	public int getTotalMiles() {
		return totalMiles;
	}

	public void setTotalMiles(int totalMiles) {
		this.totalMiles = totalMiles;
	}

	public int getBasePoint() {
		return basePoint;
	}

	public void setBasePoint(int basePoint) {
		this.basePoint = basePoint;
	}

	public int getPromoPoints() {
		return promoPoints;
	}

	public void setPromoPoints(int promoPoints) {
		this.promoPoints = promoPoints;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public ArrayList<ItenerarySegmentResult> getItenerarySegmentResultList() {
		return itenerarySegmentResultList;
	}

	public void setItenerarySegmentResultList(
			ArrayList<ItenerarySegmentResult> itenerarySegmentResultList) {
		this.itenerarySegmentResultList = itenerarySegmentResultList;
	}

	public boolean getShowItenarary() {
		return showItenarary;
	}

	public void setShowItenarary(boolean showItenarary) {
		this.showItenarary = showItenarary;
	}
	
		
		
}
