package com.thy.loyalty.loyaltyservices.milesell.dto;

/**
 * @author O_CETIN3
 *
 */
public class MileSellProcessDetail {
	
	private String nPhaseId;
	private String orderID;
	
	private String sponsorFFid;
	private String targetFFid;
	private MileType mileType;
	private double mileAmount;
	
	// EMD - VPOS - fare
	private double emdPrice;    // emd de amount olarak geçiyor
	private String emdCurrency;  // emd de currency olarak geçiyor
	private double currencyRate;
	private String bankAuthentiactionCode; // emd de authCode -- PG Sell
	private String bankCode;			   // emd de bankCode -- PG Sell
	private String hostDate;			   // PG Sell
	private String cardNumber;
	private int cardExpireDate;
	private String cardType;
	private String virtualCard;
	
	private PaymentType paymentType;
	
	public String getnPhaseId() {
		return nPhaseId;
	}
	public void setnPhaseId(String nPhaseId) {
		this.nPhaseId = nPhaseId;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getSponsorFFid() {
		return sponsorFFid;
	}
	public void setSponsorFFid(String sponsorFFid) {
		this.sponsorFFid = sponsorFFid;
	}
	public String getTargetFFid() {
		return targetFFid;
	}
	public void setTargetFFid(String targetFFid) {
		this.targetFFid = targetFFid;
	}
	public MileType getMileType() {
		return mileType;
	}
	public void setMileType(MileType mileType) {
		this.mileType = mileType;
	}
	public double getMileAmount() {
		return mileAmount;
	}
	public void setMileAmount(double mileAmount) {
		this.mileAmount = mileAmount;
	}
	public double getEmdPrice() {
		return emdPrice;
	}
	public void setEmdPrice(double emdPrice) {
		this.emdPrice = emdPrice;
	}
	public String getEmdCurrency() {
		return emdCurrency;
	}
	public void setEmdCurrency(String emdCurrency) {
		this.emdCurrency = emdCurrency;
	}
	public double getCurrencyRate() {
		return currencyRate;
	}
	public void setCurrencyRate(double currencyRate) {
		this.currencyRate = currencyRate;
	}
	public String getBankAuthentiactionCode() {
		return bankAuthentiactionCode;
	}
	public void setBankAuthentiactionCode(String bankAuthentiactionCode) {
		this.bankAuthentiactionCode = bankAuthentiactionCode;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getHostDate() {
		return hostDate;
	}
	public void setHostDate(String hostDate) {
		this.hostDate = hostDate;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCardExpireDate() {
		return cardExpireDate;
	}
	public void setCardExpireDate(int cardExpireDate) {
		this.cardExpireDate = cardExpireDate;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getVirtualCard() {
		return virtualCard;
	}
	public void setVirtualCard(String virtualCard) {
		this.virtualCard = virtualCard;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
}
