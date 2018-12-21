package com.thy.loyalty.loyaltyservices.securityprocess.service;

import com.thy.loyalty.loyaltyservices.securityprocess.dto.SecurityProcessDetail;
import com.thy.loyalty.loyaltyservices.securityprocess.dto.SecurityProcessResult;
import com.thy.ws.header.request.RequestHeader;

public interface ISecurityProcessService {

	SecurityProcessResult SecurityProcessOperation(RequestHeader requestHeader,
			SecurityProcessDetail securityProcessDetail);

}
