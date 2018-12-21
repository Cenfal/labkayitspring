package com.thy.loyalty.loyaltyservices.voluntaryobserver.dto;

import java.util.ArrayList;

import com.thy.loyalty.ms.utility.dto.MethodResult;

public class MediaServiceResult extends MethodResult {

	private ArrayList<MediaRecord> mediaList;

	public ArrayList<MediaRecord> getMediaList() {
		return mediaList;
	}

	public void setMediaList(ArrayList<MediaRecord> mediaList) {
		this.mediaList = mediaList;
	}
}
