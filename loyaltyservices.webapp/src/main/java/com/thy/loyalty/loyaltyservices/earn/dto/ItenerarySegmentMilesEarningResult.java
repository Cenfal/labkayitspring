package com.thy.loyalty.loyaltyservices.earn.dto;

import javax.xml.bind.annotation.XmlTransient;

public class ItenerarySegmentMilesEarningResult {
	
	private int segmentIndex;
	
	private int baseMiles;
	private int promoMiles;
	
	private int basePoint;
	private int promoPoints;
	
	private String resultCode;
	private String resultDescription;
	
	private boolean isErrorOccured = false;
	
	
	public int getSegmentIndex() {
		return segmentIndex;
	}
	public void setSegmentIndex(int segmentIndex) {
		this.segmentIndex = segmentIndex;
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
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultDescription() {
		return resultDescription;
	}
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}
	
	@XmlTransient
	public boolean getIsErrorOccured() {
		return isErrorOccured;
	}
	@XmlTransient
	public void setIsErrorOccured(boolean isErrorOccured) {
		this.isErrorOccured = isErrorOccured;
	}

	
	
	
}
