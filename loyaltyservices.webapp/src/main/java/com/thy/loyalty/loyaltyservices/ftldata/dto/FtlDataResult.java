package com.thy.loyalty.loyaltyservices.ftldata.dto;

import java.util.ArrayList;

import com.thy.loyalty.ms.utility.dto.ServiceResult;

public class FtlDataResult extends ServiceResult {

	private ArrayList<FtlDataRecord> getFtlDataList;

	public ArrayList<FtlDataRecord> getGetFtlDataList() {
		return getFtlDataList;
	}

	public void setGetFtlDataList(ArrayList<FtlDataRecord> getFtlDataList) {
		this.getFtlDataList = getFtlDataList;
	}

}
