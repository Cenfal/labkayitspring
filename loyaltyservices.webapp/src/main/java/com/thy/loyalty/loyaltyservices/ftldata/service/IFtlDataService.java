package com.thy.loyalty.loyaltyservices.ftldata.service;

import com.thy.loyalty.loyaltyservices.ftldata.dto.FtlDataDetail;
import com.thy.loyalty.loyaltyservices.ftldata.dto.FtlDataResult;
import com.thy.ws.header.request.RequestHeader;

public interface IFtlDataService {

	public FtlDataResult getFtlDataList(FtlDataDetail ftlDataDetail,
			RequestHeader requestHeader) throws Exception;
}
