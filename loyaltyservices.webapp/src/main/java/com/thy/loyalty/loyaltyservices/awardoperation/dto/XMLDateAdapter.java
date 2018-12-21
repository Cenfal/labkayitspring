package com.thy.loyalty.loyaltyservices.awardoperation.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class XMLDateAdapter extends XmlAdapter<String, Date> {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"dd.MM.yyyy");

	@Override
	public String marshal(Date arg0) throws Exception {
		// TODO Auto-generated method stub
		return dateFormat.format(arg0);
	}

	@Override
	public Date unmarshal(String arg0) throws Exception {
		// TODO Auto-generated method stub
		return new java.sql.Date(dateFormat.parse(arg0).getTime());
	}

}
