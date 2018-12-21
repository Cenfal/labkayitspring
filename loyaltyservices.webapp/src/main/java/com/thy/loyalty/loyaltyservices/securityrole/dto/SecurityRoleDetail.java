package com.thy.loyalty.loyaltyservices.securityrole.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SecurityRoleDetail")
public class SecurityRoleDetail {

	private int tableSeq;
	private String changeType;
	private String roleCode;
	private String roleExplanation;

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

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleExplanation() {
		return roleExplanation;
	}

	public void setRoleExplanation(String roleExplanation) {
		this.roleExplanation = roleExplanation;
	}

}
