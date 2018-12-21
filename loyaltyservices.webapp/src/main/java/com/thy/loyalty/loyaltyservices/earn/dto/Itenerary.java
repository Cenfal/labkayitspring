package com.thy.loyalty.loyaltyservices.earn.dto;

import java.util.ArrayList;

public class Itenerary {
	
	private int iteneraryIndex;
	private ArrayList<ItenerarySegment> itenerarySegmentsList;
	
	public int getIteneraryIndex() {
		return iteneraryIndex;
	}
	public void setIteneraryIndex(int iteneraryIndex) {
		this.iteneraryIndex = iteneraryIndex;
	}
	public ArrayList<ItenerarySegment> getItenerarySegmentsList() {
		return itenerarySegmentsList;
	}
	public void setItenerarySegmentsList(
			ArrayList<ItenerarySegment> itenerarySegmentsList) {
		this.itenerarySegmentsList = itenerarySegmentsList;
	}

	
	


}
