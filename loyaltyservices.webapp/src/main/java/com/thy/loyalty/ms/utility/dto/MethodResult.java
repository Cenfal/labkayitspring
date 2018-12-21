package com.thy.loyalty.ms.utility.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MethodResult")

public class MethodResult {

	private String resultCode;
	private String resultDescription;

	public MethodResult() {
		
	}

	// #Tip# WebService den disari acilmasini istemedigimiz propertyleri XmlTransient olarak isaretliyoruz
	@XmlTransient
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	@XmlTransient
	public String getResultDescription() {
		return resultDescription;
	}
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

}
