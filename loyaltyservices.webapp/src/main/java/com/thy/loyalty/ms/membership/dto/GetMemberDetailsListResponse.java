package com.thy.loyalty.ms.membership.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


//XmlRootElement olarak isaretliyoruz.
@XmlRootElement
@XmlType(propOrder = {"memberDetailsList", "errorCode", "errorDescription"})
public class GetMemberDetailsListResponse implements Serializable {

	// Private tanimlayip , public getter-setter yapiyoruz
	//ikisi de public olursa asagidakine benzer hata veriyor.
	//	Caused by: com.sun.xml.bind.v2.runtime.IllegalAnnotationsException: 1 counts of IllegalAnnotationExceptions
	//	Class has two properties of the same name "resultCode"

	/**
	 * 
	 */
	private static final long serialVersionUID = -1591758825012794852L;
	
	private String errorCode;
	private String errorDescription;
	
	private MemberDetailsList memberDetailsList;

	public GetMemberDetailsListResponse() {
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public MemberDetailsList getMemberDetailsList() {
		return memberDetailsList;
	}

	public void setMemberDetailsList(MemberDetailsList memberDetailsList) {
		this.memberDetailsList = memberDetailsList;
	}

}

