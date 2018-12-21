package com.thy.loyalty.loyaltyservices.securitymatrix.service;

import com.thy.loyalty.loyaltyservices.securitymatrix.dto.SecurityMatrixDetail;
import com.thy.loyalty.loyaltyservices.securitymatrix.dto.SecurityMatrixResult;
import com.thy.ws.header.request.RequestHeader;

public interface ISecurityMatrixService {

	SecurityMatrixResult SecurityMatrixOperation(RequestHeader requestHeader,
			SecurityMatrixDetail securityMatrixDetail);

}
