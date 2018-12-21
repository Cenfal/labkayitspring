package com.thy.loyalty.loyaltyservices.earn.dto;

public class ItenerarySegment {
	
	private int segmentIndex;
	
	private String origin; 
	private String destination;
	
	private String cabinCode;
	private String flightDate;
	
	private String operatingClassCode;
	private String marketingClassCode;
	private String operatingFlightNumber;
	private String marketingFlightNumber;
	
	private String memberCardType;
	
	
	

	public int getSegmentIndex() {
		return segmentIndex;
	}

	public void setSegmentIndex(int segmentIndex) {
		this.segmentIndex = segmentIndex;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCabinCode() {
		return cabinCode;
	}

	public void setCabinCode(String cabinCode) {
		this.cabinCode = cabinCode;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getOperatingClassCode() {
		return operatingClassCode;
	}

	public void setOperatingClassCode(String operatingClassCode) {
		this.operatingClassCode = operatingClassCode;
	}

	public String getMarketingClassCode() {
		return marketingClassCode;
	}

	public void setMarketingClassCode(String marketingClassCode) {
		this.marketingClassCode = marketingClassCode;
	}

	public String getOperatingFlightNumber() {
		return operatingFlightNumber;
	}

	public void setOperatingFlightNumber(String operatingFlightNumber) {
		this.operatingFlightNumber = operatingFlightNumber;
	}

	public String getMarketingFlightNumber() {
		return marketingFlightNumber;
	}

	public void setMarketingFlightNumber(String marketingFlightNumber) {
		this.marketingFlightNumber = marketingFlightNumber;
	}

	public String getMemberCardType() {
		return memberCardType;
	}

	public void setMemberCardType(String memberCardType) {
		this.memberCardType = memberCardType;
	}
	
	

}
