package com.thy.loyalty.loyaltyservices.useroperations.service;

import com.thy.loyalty.loyaltyservices.useroperations.dto.UserLoginDetail;
import com.thy.loyalty.loyaltyservices.useroperations.dto.UserLoginResult;
import com.thy.ws.header.request.RequestHeader;

public interface IUserOperationsService {

	
	UserLoginResult userLogin(RequestHeader requestHeader,
			UserLoginDetail userLoginDetail);
}
