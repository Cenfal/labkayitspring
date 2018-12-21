package com.thy.loyalty.loyaltyservices.voluntaryobserver.dto;

import oracle.sql.BLOB;

public class MediaRecord {

	private int incidentId;
	private int mediaId;
	private String fileName;
	private String fileType;
	private BLOB media;
	private String updateDate;
	private String systemDate;
	
	public int getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}
	public int getMediaId() {
		return mediaId;
	}
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}	
	public BLOB getMedia() {
		return media;
	}
	public void setMedia(BLOB media) {
		this.media = media;
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
	
	

}
