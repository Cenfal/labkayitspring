package com.thy.loyalty.loyaltyservices.member.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="GetMemberExchageMieInfoDetails")
@XmlType (propOrder={"ffID"})
public class GetMemberExchageMileInfoDetails {
	private String ffID;

public String getFfID() {
	return ffID;
}

public void setFfID(String ffID) {
	this.ffID = ffID;
}
}
