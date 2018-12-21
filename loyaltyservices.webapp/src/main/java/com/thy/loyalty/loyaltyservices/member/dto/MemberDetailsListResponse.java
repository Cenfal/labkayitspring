package com.thy.loyalty.loyaltyservices.member.dto;


import java.io.Serializable;
import java.util.Date;

import com.thy.loyalty.ms.utility.dto.ServiceResult;

public class MemberDetailsListResponse extends ServiceResult implements Serializable {
	private static final long serialVersionUID = -1591758825012794852L;

	private MemberDetailsList memberDetailsList;
	private String ffid;
	private String pinNumber;
	private String name;
	private String surname;
	private String sex;
	private String nationality;
	private String cardType;
	private String cardName;
	private String statusCode;
	private String passportNumber;
	private String identityCardNo;
	private String birthDate;
	private String hasCobrandedCard;
	private String primaryAddressType;
	private String primaryAddress;
	private String primaryCountry;
	private String primaryCity;
	private String primaryZipCode;
	private String communicationLanguage;
	private String primaryGsmNumber;
	private String primaryComTelNumber;
	private String primaryEmailAddr;
	private Integer bonusMiles;
	private Integer statusMiles;
	private Integer  totalMiles;
	private String groupCode;
	private Date membershipDate;
	
	public String getFfid() {
		return ffid;
	}

	public void setFfid(String ffid) {
		this.ffid = ffid;
	}

	public String getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getIdentityCardNo() {
		return identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getHasCobrandedCard() {
		return hasCobrandedCard;
	}

	public void setHasCobrandedCard(String hasCobrandedCard) {
		this.hasCobrandedCard = hasCobrandedCard;
	}

	public String getPrimaryAddressType() {
		return primaryAddressType;
	}

	public void setPrimaryAddressType(String primaryAddressType) {
		this.primaryAddressType = primaryAddressType;
	}

	public String getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public String getPrimaryCountry() {
		return primaryCountry;
	}

	public void setPrimaryCountry(String primaryCountry) {
		this.primaryCountry = primaryCountry;
	}

	public String getPrimaryCity() {
		return primaryCity;
	}

	public void setPrimaryCity(String primaryCity) {
		this.primaryCity = primaryCity;
	}

	public String getPrimaryZipCode() {
		return primaryZipCode;
	}

	public void setPrimaryZipCode(String primaryZipCode) {
		this.primaryZipCode = primaryZipCode;
	}

	public String getCommunicationLanguage() {
		return communicationLanguage;
	}

	public void setCommunicationLanguage(String communicationLanguage) {
		this.communicationLanguage = communicationLanguage;
	}

	public String getPrimaryGsmNumber() {
		return primaryGsmNumber;
	}

	public void setPrimaryGsmNumber(String primaryGsmNumber) {
		this.primaryGsmNumber = primaryGsmNumber;
	}

	public String getPrimaryComTelNumber() {
		return primaryComTelNumber;
	}

	public void setPrimaryComTelNumber(String primaryComTelNumber) {
		this.primaryComTelNumber = primaryComTelNumber;
	}

	public String getPrimaryEmailAddr() {
		return primaryEmailAddr;
	}

	public void setPrimaryEmailAddr(String primaryEmailAddr) {
		this.primaryEmailAddr = primaryEmailAddr;
	}

	public Integer getBonusMiles() {
		return bonusMiles;
	}

	public void setBonusMiles(Integer bonusMiles) {
		this.bonusMiles = bonusMiles;
	}

	public Integer getStatusMiles() {
		return statusMiles;
	}

	public void setStatusMiles(Integer statusMiles) {
		this.statusMiles = statusMiles;
	}

	public Integer getTotalMiles() {
		return totalMiles;
	}

	public void setTotalMiles(Integer totalMiles) {
		this.totalMiles = totalMiles;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public Date getMembershipDate() {
		return membershipDate;
	}

	public void setMembershipDate(Date membershipDate) {
		this.membershipDate = membershipDate;
	}

		public MemberDetailsListResponse() {
	}

	public MemberDetailsList getMemberDetailsList() {
		return memberDetailsList;
	}

	public void setMemberDetailsList(MemberDetailsList memberDetailsList) {
		this.memberDetailsList = memberDetailsList;
	}
	
	public void copyValuesFromGetMemberDetailsListResponse(GetMemberDetailsListResponse detailsList)
	{
		this.memberDetailsList = detailsList.getMemberDetailsList();
		setResultCode(detailsList.getErrorCode());
		setResultDescription(detailsList.getErrorDescription());
	}

}