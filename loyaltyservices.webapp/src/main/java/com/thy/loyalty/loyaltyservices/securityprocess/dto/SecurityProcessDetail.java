package com.thy.loyalty.loyaltyservices.securityprocess.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SecurityProcessDetail")
public class SecurityProcessDetail {

	private int tableSeq;
	private String changeType;
	private String processCode;
	private String processExplanation;
	private String active;

	public int getTableSeq() {
		return tableSeq;
	}

	public void setTableSeq(int tableSeq) {
		this.tableSeq = tableSeq;
	}

	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getProcessExplanation() {
		return processExplanation;
	}

	public void setProcessExplanation(String processExplanation) {
		this.processExplanation = processExplanation;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
