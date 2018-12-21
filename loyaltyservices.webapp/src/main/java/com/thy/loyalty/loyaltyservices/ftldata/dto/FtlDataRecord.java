package com.thy.loyalty.loyaltyservices.ftldata.dto;

public class FtlDataRecord {

	private String pnrNo;
	private String sellingClass;
	private String ticketNumber;
	private String fqTv;
	
	public String getFqTv() {
		return fqTv;
	}

	public void setFqTv(String fqTv) {
		this.fqTv = fqTv;
	}

	public String getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}

	public String getSellingClass() {
		return sellingClass;
	}

	public void setSellingClass(String sellingClass) {
		this.sellingClass = sellingClass;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

}
