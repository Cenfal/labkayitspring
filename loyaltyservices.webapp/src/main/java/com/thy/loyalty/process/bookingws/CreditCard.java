package com.thy.loyalty.process.bookingws;

import com.jforce.tools.SimpleDate;

public class CreditCard {
	
	private String authCode;
	private String bankCode;
	private String cardNumber;
	private String cardType;
	private SimpleDate expireDate;
	private String hostDate;
	private boolean virtualCard = false;
	
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public SimpleDate getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(SimpleDate expireDate) {
		this.expireDate = expireDate;
	}
	public String getHostDate() {
		return hostDate;
	}
	public void setHostDate(String hostDate) {
		this.hostDate = hostDate;
	}
	public boolean isVirtualCard() {
		return virtualCard;
	}
	public void setVirtualCard(boolean virtualCard) {
		this.virtualCard = virtualCard;
	}
}
