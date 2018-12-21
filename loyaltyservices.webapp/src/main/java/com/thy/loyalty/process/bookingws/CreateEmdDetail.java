/**
 * 
 */
package com.thy.loyalty.process.bookingws;

import java.math.BigDecimal;

import com.thy.loyalty.loyaltyservices.member.dto.Member;
import com.thy.loyalty.loyaltyservices.milesell.dto.MileType;
import com.thy.loyalty.loyaltyservices.milesell.dto.PaymentType;

/**
 * @author O_CETIN3
 *
 */
public class CreateEmdDetail {
	
	private String currency;
	private MileType mileType;
	private int mileAmount;
	private BigDecimal tax;
	private BigDecimal price;
	private CreditCard creditCard;
	private String orderId;
	private double currencyRate;
	private String nPhaseId;
	private String emdNumber;
	private PaymentType paymentType;
	private Member member;
	private int approvalCode;

	public String getEmdNumber() {
		return emdNumber;
	}
	public void setEmdNumber(String emdNumber) {
		this.emdNumber = emdNumber;
	}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public MileType getMileType() {
		return mileType;
	}
	public void setMileType(MileType mileType) {
		this.mileType = mileType;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public double getCurrencyRate() {
		return currencyRate;
	}
	public void setCurrencyRate(double currencyRate) {
		this.currencyRate = currencyRate;
	}
	public String getnPhaseId() {
		return nPhaseId;
	}
	public void setnPhaseId(String nPhaseId) {
		this.nPhaseId = nPhaseId;
	}
	public int getApprovalCode() {
		return approvalCode;
	}
	public void setApprovalCode(int approvalCode) {
		this.approvalCode = approvalCode;
	}
	public int getMileAmount() {
		return mileAmount;
	}
	public void setMileAmount(int mileAmount) {
		this.mileAmount = mileAmount;
	}
}
