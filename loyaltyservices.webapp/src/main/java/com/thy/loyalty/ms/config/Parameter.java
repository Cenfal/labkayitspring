package com.thy.loyalty.ms.config;

/**
 * 
 * Created on 26-08-2010
 * 
 * @author htarhan
 * 
 * 		ms_web_parameters tablosundan gelen parametreleri tasiyan class
 * 
 */

public class Parameter {

	private String key;
	private String type;
	private String value;
	
	public Parameter(String key,String type,String value)
	{
		this.key = key;
		this.type = type;
		this.value = value;
	}

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
	
	
}
