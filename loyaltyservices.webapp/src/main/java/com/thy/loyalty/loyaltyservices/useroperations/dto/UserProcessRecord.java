package com.thy.loyalty.loyaltyservices.useroperations.dto;

public class UserProcessRecord {

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	private String processCode;
	private String roleCode;
}
