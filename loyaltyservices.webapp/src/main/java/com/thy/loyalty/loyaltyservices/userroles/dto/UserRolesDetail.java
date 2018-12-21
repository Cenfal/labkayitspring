package com.thy.loyalty.loyaltyservices.userroles.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserRolesDetail")
public class UserRolesDetail {

	private int tableSeq;
	private String changeType;
	private String roleCode;
	private String userIsn;

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

	public String getUserIsn() {
		return userIsn;
	}

	public void setUserIsn(String userIsn) {
		this.userIsn = userIsn;
	}

}
