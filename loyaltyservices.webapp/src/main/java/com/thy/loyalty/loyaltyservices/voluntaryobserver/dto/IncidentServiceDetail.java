package com.thy.loyalty.loyaltyservices.voluntaryobserver.dto;

public class IncidentServiceDetail {
	
	
    private IncidentRecord incidentRecord;
    private String roleCode;
    private String processCode;

	public IncidentRecord getIncidentRecord() {
		return incidentRecord;
	}

	public void setIncidentRecord(IncidentRecord incidentRecord) {
		this.incidentRecord = incidentRecord;
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
