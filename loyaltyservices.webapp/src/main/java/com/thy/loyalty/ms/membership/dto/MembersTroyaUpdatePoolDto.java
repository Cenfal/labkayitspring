package com.thy.loyalty.ms.membership.dto;



public class MembersTroyaUpdatePoolDto {

	private Integer id;
	private String memberId;
	private String insertDate;
	private Long insertTime;
	private String processDate;
	private String status;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public Long getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Long insertTime) {
		this.insertTime = insertTime;
	}
	public String getProcessDate() {
		return processDate;
	}
	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
