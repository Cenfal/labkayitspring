package com.thy.loyalty.loyaltyservices.userroles.service;

import com.thy.loyalty.loyaltyservices.userroles.dto.UserRolesDetail;
import com.thy.loyalty.loyaltyservices.userroles.dto.UserRolesResult;
import com.thy.ws.header.request.RequestHeader;

public interface IUserRolesService {

	UserRolesResult UserRolesOperation(RequestHeader requestHeader,
			UserRolesDetail userRolesDetail);

}
