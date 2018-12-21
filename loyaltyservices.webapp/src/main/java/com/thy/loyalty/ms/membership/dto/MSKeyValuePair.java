package com.thy.loyalty.ms.membership.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MSKeyValuePair implements Serializable {
	
	private static final long serialVersionUID = -6491082259820087581L;

	public final static String INTEGER = "INTEGER";
	public final static String FLOAT = "FLOAT";
	public final static String STRING = "STRING";
	public final static String DATE = "DATE";
	
	private String key;
	private String type;
	private String value;
	private String format;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getFormat() {
		return format;
	}
	

}
