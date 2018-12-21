package com.thy.loyalty.loyaltyservices.securitymatrix.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SecurityMatrixDetail")
public class SecurityMatrixDetail {

	private int tableSeq;
	private String changeType;
	private String roleCode;
	private String processCode;

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

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

}
