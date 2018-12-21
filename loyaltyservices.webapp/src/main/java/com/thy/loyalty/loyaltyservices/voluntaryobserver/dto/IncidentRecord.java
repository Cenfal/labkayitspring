package com.thy.loyalty.loyaltyservices.voluntaryobserver.dto;

public class IncidentRecord {

	private int incidentId;
	private String memberId;
	private int typeId;
	private int categoryId;
	private int subCategoryId;
	private String state;
	private String cxUsername;
	private String updateUsername;
	private String observerText;
	private String cxText;
	private String departmentText;
	private String updateDate;
	private String systemDate;
	private String flightNumber;
	private String flightDate;
	
	public int getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCxUsername() {
		return cxUsername;
	}
	public void setCxUsername(String cxUsername) {
		this.cxUsername = cxUsername;
	}
	public String getUpdateUsername() {
		return updateUsername;
	}
	public void setUpdateUsername(String updateUsername) {
		this.updateUsername = updateUsername;
	}
	public String getObserverText() {
		return observerText;
	}
	public void setObserverText(String observerText) {
		this.observerText = observerText;
	}
	public String getCxText() {
		return cxText;
	}
	public void setCxText(String cxText) {
		this.cxText = cxText;
	}
	public String getDepartmentText() {
		return departmentText;
	}
	public void setDepartmentText(String departmentText) {
		this.departmentText = departmentText;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getSystemDate() {
		return systemDate;
	}
	public void setSystemDate(String systemDate) {
		this.systemDate = systemDate;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
}
