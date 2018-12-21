package com.thy.loyalty.loyaltyservices.useroperations.dto;

import java.util.ArrayList;

import com.thy.loyalty.ms.utility.dto.MethodResult;

public class UserLoginResult extends MethodResult {
	private String userIsn;
	private String userName;
	private String userSrIsn;
	private ArrayList<UserProcessRecord> userProcessList;
	private UserFileRecord userfileRecord;

	public String getUserIsn() {
		return userIsn;
	}

	public void setUserIsn(String userIsn) {
		this.userIsn = userIsn;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSrIsn() {
		return userSrIsn;
	}

	public void setUserSrIsn(String userSrIsn) {
		this.userSrIsn = userSrIsn;
	}

	public ArrayList<UserProcessRecord> getUserProcessList() {
		return userProcessList;
	}

	public void setUserProcessList(ArrayList<UserProcessRecord> userProcessList) {
		this.userProcessList = userProcessList;
	}

	public UserFileRecord getUserfileRecord() {
		return userfileRecord;
	}

	public void setUserfileRecord(UserFileRecord userfileRecord) {
		this.userfileRecord = userfileRecord;
	}

}
