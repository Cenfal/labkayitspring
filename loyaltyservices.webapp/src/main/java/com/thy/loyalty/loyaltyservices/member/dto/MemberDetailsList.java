package com.thy.loyalty.loyaltyservices.member.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MemberDetailsList {
	
	private ArrayList<MSKeyValuePair> memberDataKVPair;
	
	public boolean isEmpty() {
		if(memberDataKVPair==null)
			return true;
		else if(memberDataKVPair.size()==0)
			return true;
		else
			return false;
	}
	
	public int getSize() {
		if(memberDataKVPair==null)
			return 0;
		else 
			return memberDataKVPair.size();
		
	}
	
	public void addKVListItem(MSKeyValuePair item) {
		if (isEmpty())
			this.memberDataKVPair = new ArrayList<MSKeyValuePair>();
		
		this.memberDataKVPair.add(item);
	}

	public ArrayList<MSKeyValuePair> getMemberDataKVPair() {
		return memberDataKVPair;
	}

	public void setMemberDataKVPair(ArrayList<MSKeyValuePair> memberDataKVPair) {
		this.memberDataKVPair = memberDataKVPair;
	}

}

