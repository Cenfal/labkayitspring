package com.thy.loyalty.loyaltyservices.ftldata.dto;

public class FtlDataDetail {

	private String pnrNo;
	private String name;
	private String surname;
	private int flightNo;
	private int depDate;

	public int getDepDate() {
		return depDate;
	}

	public void setDepDate(int depDate) {
		this.depDate = depDate;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(String pnrNo) {
		this.pnrNo = pnrNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

}
