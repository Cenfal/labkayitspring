package com.thy.loyalty.loyaltyservices.voluntaryobserver.dto;

public class MediaServiceDetail {
	
	
    private MediaRecord mediaRecord;
    private String roleCode;
    private String processCode;

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

	public MediaRecord getMediaRecord() {
		return mediaRecord;
	}

	public void setMediaRecord(MediaRecord mediaRecord) {
		this.mediaRecord = mediaRecord;
	}
    
	
}
