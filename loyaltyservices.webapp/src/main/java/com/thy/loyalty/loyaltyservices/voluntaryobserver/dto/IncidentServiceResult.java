package com.thy.loyalty.loyaltyservices.voluntaryobserver.dto;

import java.util.ArrayList;

import com.thy.loyalty.ms.utility.dto.MethodResult;

public class IncidentServiceResult extends MethodResult {

	private ArrayList<IncidentRecord> incidentList;
	
	private int incidentId;

	public ArrayList<IncidentRecord> getIncidentList() {
		return incidentList;
	}

	public void setIncidentList(ArrayList<IncidentRecord> incidentList) {
		this.incidentList = incidentList;
	}

	public int getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}

}
