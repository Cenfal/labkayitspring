package com.thy.loyalty.loyaltyservices.member.dto;

import com.thy.loyalty.ms.utility.dto.ServiceResult;

	public class MemberDetailsResult extends ServiceResult {

		private String ffid;
		private String pinNumber;
		private String name;
		private String surname;
		private String mergedId;
		private String sex;
		private String nationality;
		private String cardType;
		private String cardName;
		private String statusCode;
		private String identityCardNo;
		private String passportNumber;
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
		private Integer  bonusMiles;
		private Integer  statusMiles;
		private Integer  totalMiles;

		/**
		 * @param ffid the ffid to set
		 */
		public void setFfid(String ffid) {
			this.ffid = ffid;
		}

		/**
		 * @return the ffid
		 */
		public String getFfid() {
			
			if(ffid == null)
				
				return " ";
			
			else
				
				return ffid;
			
		}

		/**
		 * @param pinNumber the pinNumber to set
		 */
		public void setPinNumber(String pinNumber) {
			this.pinNumber = pinNumber;
		}

		/**
		 * @return the pinNumber
		 */
		public String getPinNumber() {
			
			if (pinNumber == null)
				
				return " ";
			
			else
				
				return pinNumber;
			
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			
			if (name == null)
				
				return " ";
			
			else
				
				return name;
		}

		/**
		 * @param surname the surname to set
		 */
		public void setSurname(String surname) {
			this.surname = surname;
		}

		/**
		 * @return the surname
		 */
		public String getSurname() {
			
			if (surname == null)
				
				return " ";
			
			else
				
				return surname;
		}

		/**
		 * @param mergedId the mergedId to set
		 */
		public void setMergedId(String mergedId) {
			this.mergedId = mergedId;
		}

		/**
		 * @return the mergedId
		 */
		public String getMergedId() {
			
			if (mergedId == null)
				
				return " ";
			
			else
				
				return mergedId;
		}

		/**
		 * @param sex the sex to set
		 */
		public void setSex(String sex) {
			this.sex = sex;
		}

		/**
		 * @return the sex
		 */
		public String getSex() {
			
			if (sex == null)
				
				return " ";
			
			else
				
				return sex;
		}

		/**
		 * @param nationality the nationality to set
		 */
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}

		/**
		 * @return the nationality
		 */
		public String getNationality() {
			
			if (nationality == null)
				
				return " ";
			
			else
				
				return nationality;
		}

		/**
		 * @param cardType the cardType to set
		 */
		public void setCardType(String cardType) {
			this.cardType = cardType;
		}

		/**
		 * @return the cardType
		 */
		public String getCardType() {
			
			if (cardType == null)
				
				return " ";
			
			else
				
				return cardType;
		}

		/**
		 * @param cardName the cardName to set
		 */
		public void setCardName(String cardName) {
			this.cardName = cardName;
		}

		/**
		 * @return the cardName
		 */
		public String getCardName() {
			
			if (cardName == null)
				
				return " ";
			
			else
			
				return cardName;
		}

		/**
		 * @param statusCode the statusCode to set
		 */
		public void setStatusCode(String statusCode) {
			this.statusCode = statusCode;
		}

		/**
		 * @return the statusCode
		 */
		public String getStatusCode() {
			
			if (statusCode == null)
				
				return " ";
			
			else
				
				return statusCode;
		}

		/**
		 * @param identityCardNo the identityCardNo to set
		 */
		public void setIdentityCardNo(String identityCardNo) {
			this.identityCardNo = identityCardNo;
		}

		/**
		 * @return the identityCardNo
		 */
		public String getIdentityCardNo() {
			
			if (identityCardNo == null)
				
				return " ";
			
			else
				
				return identityCardNo;

		}

		/**
		 * @param passportNumber the passportNumber to set
		 */
		public void setPassportNumber(String passportNumber) {
			this.passportNumber = passportNumber;
		}

		/**
		 * @return the passportNumber
		 */
		public String getPassportNumber() {
			
			if (passportNumber == null)
				
				return " ";
			
			else
				
				return passportNumber;

		}

		/**
		 * @param birthDate the birthDate to set
		 */
		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}

		/**
		 * @return the birthDate
		 */
		public String getBirthDate() {
			
			if (birthDate == null)
				
				return " ";
			
			else
				
				return birthDate;
			
		}

		/**
		 * @param hasCobrandedCard the hasCobrandedCard to set
		 */
		public void setHasCobrandedCard(String hasCobrandedCard) {
			this.hasCobrandedCard = hasCobrandedCard;
		}

		/**
		 * @return the hasCobrandedCard
		 */
		public String getHasCobrandedCard() {
			
			if (hasCobrandedCard == null)
				
				return " ";
			
			else
				
				return hasCobrandedCard;
			
		}

		/**
		 * @param primaryAddressType the primaryAddressType to set
		 */
		public void setPrimaryAddressType(String primaryAddressType) {
			this.primaryAddressType = primaryAddressType;
		}

		/**
		 * @return the primaryAddressType
		 */
		public String getPrimaryAddressType() {
			
			if (primaryAddressType == null)
				
				return " ";
			
			else
				
				return primaryAddressType;

		}

		/**
		 * @param primaryAddress the primaryAddress to set
		 */
		public void setPrimaryAddress(String primaryAddress) {
			this.primaryAddress = primaryAddress;
		}

		/**
		 * @return the primaryAddress
		 */
		public String getPrimaryAddress() {
			
			if (primaryAddress == null)
				
				return " ";
			
			else
				
				return primaryAddress;

		}

		/**
		 * @param primaryCountry the primaryCountry to set
		 */
		public void setPrimaryCountry(String primaryCountry) {
			this.primaryCountry = primaryCountry;
		}

		/**
		 * @return the primaryCountry
		 */
		public String getPrimaryCountry() {
			
			if (primaryCountry == null)
				
				return " ";
			
			else
				
				return primaryCountry;

		}

		/**
		 * @param primaryCity the primaryCity to set
		 */
		public void setPrimaryCity(String primaryCity) {
			this.primaryCity = primaryCity;
		}

		/**
		 * @return the primaryCity
		 */
		public String getPrimaryCity() {
			
			if (primaryCity == null)
				
				return " ";
			
			else
				
				return primaryCity;
			
		}

		/**
		 * @param primaryZipCode the primaryZipCode to set
		 */
		public void setPrimaryZipCode(String primaryZipCode) {
			this.primaryZipCode = primaryZipCode;
		}

		/**
		 * @return the primaryZipCode
		 */
		public String getPrimaryZipCode() {
			
			if (primaryZipCode == null)
				
				return " ";
			
			else
				
				return primaryZipCode;
			
		}

		/**
		 * @param communicationLanguage the communicationLanguage to set
		 */
		public void setCommunicationLanguage(String communicationLanguage) {
			this.communicationLanguage = communicationLanguage;
		}

		/**
		 * @return the communicationLanguage
		 */
		public String getCommunicationLanguage() {
			
			if (communicationLanguage == null)
				
				return " ";
			
			else
				
				return communicationLanguage;

		}

		/**
		 * @param primaryGsmNumber the primaryGsmNumber to set
		 */
		public void setPrimaryGsmNumber(String primaryGsmNumber) {
			this.primaryGsmNumber = primaryGsmNumber;
		}

		/**
		 * @return the primaryGsmNumber
		 */
		public String getPrimaryGsmNumber() {
			
			if (primaryGsmNumber == null)
				
				return " ";
			
			else
				
				return primaryGsmNumber;

		}

		/**
		 * @param primaryComTelNumber the primaryComTelNumber to set
		 */
		public void setPrimaryComTelNumber(String primaryComTelNumber) {
			this.primaryComTelNumber = primaryComTelNumber;
		}

		/**
		 * @return the primaryComTelNumber
		 */
		public String getPrimaryComTelNumber() {
			
			if (primaryComTelNumber == null)
				
				return " ";
			
			else
				
				return primaryComTelNumber;

		}

		/**
		 * @param primaryEmailAddr the primaryEmailAddr to set
		 */
		public void setPrimaryEmailAddr(String primaryEmailAddr) {
			this.primaryEmailAddr = primaryEmailAddr;
		}

		/**
		 * @return the primaryEmailAddr
		 */
		public String getPrimaryEmailAddr() {
			
			if (primaryEmailAddr == null)
				
				return " ";
			
			else
				
				return primaryEmailAddr;

		}

		/**
		 * @param bonusMiles the bonusMiles to set
		 */
		public void setBonusMiles(Integer bonusMiles) {
			this.bonusMiles = bonusMiles;
		}

		/**
		 * @return the bonusMiles
		 */
		public Integer getBonusMiles() {
			
			if (bonusMiles == null)
				
				return 0;
			
			else
				
				return bonusMiles;
			
		}

		/**
		 * @param statusMiles the statusMiles to set
		 */
		public void setStatusMiles(Integer statusMiles) {
			this.statusMiles = statusMiles;
		}

		/**
		 * @return the statusMiles
		 */
		public Integer getStatusMiles() {
			
			if (statusMiles == null)
				
				return 0;
			
			else
				
				return statusMiles;
			
		}

		/**
		 * @param totalMiles the totalMiles to set
		 */
		public void setTotalMiles(Integer totalMiles) {
			this.totalMiles = totalMiles;
		}

		/**
		 * @return the totalMiles
		 */
		public Integer getTotalMiles() {
			
			if (totalMiles == null)
				
				return 0;
			
			else
				
				return totalMiles;
			
		}
		


		public MemberDetailsResult(MemberDetails details)
		{
			copyValuesFromMemberDetails(details);
		}
		
		public MemberDetailsResult()
		{
		}
		
		public void copyValuesFromMemberDetails(MemberDetails details)
		{
				this.birthDate = details.getBirthDate();
				this.bonusMiles = details.getBonusMiles();
				this.cardName = details.getCardName();
				this.cardType = details.getCardType();
				this.communicationLanguage = details.getCommunicationLanguage();
				this.ffid = details.getFfid();
				this.hasCobrandedCard = details.getHasCobrandedCard();
				this.identityCardNo = details.getIdentityCardNo();
				this.mergedId = details.getMergedId();
				this.name = details.getName();
				this.nationality = details.getNationality();
				this.passportNumber = details.getPassportNumber();
				this.pinNumber = details.getPinNumber();
				this.primaryAddress = details.getPrimaryAddress();
				this.primaryAddressType = details.getPrimaryAddressType();
				this.primaryCity = details.getPrimaryCity();
				this.primaryComTelNumber = details.getPrimaryComTelNumber();
				this.primaryCountry = details.getPrimaryCountry();
				this.primaryEmailAddr = details.getPrimaryEmailAddr();
				this.primaryGsmNumber = details.getPrimaryGsmNumber();
				this.primaryZipCode = details.getPrimaryZipCode();
				this.sex = details.getSex();
				this.statusCode = details.getStatusCode();
				this.statusMiles = details.getStatusMiles();
				this.surname = details.getSurname();
				this.totalMiles = details.getTotalMiles();

				this.setResultCode(details.getErrorCode());
				this.setResultDescription(details.getErrorDescription());

		}

	}

