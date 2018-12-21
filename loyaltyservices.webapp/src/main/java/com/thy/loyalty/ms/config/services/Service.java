package com.thy.loyalty.ms.config.services;

import java.util.ArrayList;

public class Service {

	private String name;
	private ArrayList<Method> methods = new ArrayList<Method>();

	public Service() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Method> getMethods() {
		return methods;
	}

	public void setMethods(ArrayList<Method> methods) {
		this.methods = methods;
	}
	
	
}
