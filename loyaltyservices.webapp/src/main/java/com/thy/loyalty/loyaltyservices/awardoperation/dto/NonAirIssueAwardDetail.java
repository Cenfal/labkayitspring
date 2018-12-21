package com.thy.loyalty.loyaltyservices.awardoperation.dto;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlRootElement(name = "NonAirIssueAwardDetail")
@XmlType(propOrder = { "memberId", "awardUnit", "quantity", "currency",
		"amount", "rate", "activityDate", "referenceNumber", "nPhaseId" })
public class NonAirIssueAwardDetail {

	private String memberId;
	private String awardUnit;
	private double quantity;
	private String currency;
	private double amount;
	private double rate;
	private Date activityDate;
	private String referenceNumber;
	private String nPhaseId;

	public NonAirIssueAwardDetail() {
		// TODO Auto-generated constructor stub
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAwardUnit() {
		return awardUnit;
	}

	public void setAwardUnit(String awardUnit) {
		this.awardUnit = awardUnit;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@XmlJavaTypeAdapter(XMLDateAdapter.class)
	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getnPhaseId() {
		return nPhaseId;
	}

	public void setnPhaseId(String nPhaseId) {
		this.nPhaseId = nPhaseId;
	}

	@Override
	public String toString() {
		return "AwardUnit : " + this.getAwardUnit() + " MemberId : "
				+ this.getMemberId() + " nPhaseId : " + this.getnPhaseId()
				+ " Quantity : " + this.getQuantity() + " ReferenceNumber : "
				+ this.getReferenceNumber() + " ActivityDate : "
				+ this.getActivityDate();
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}
