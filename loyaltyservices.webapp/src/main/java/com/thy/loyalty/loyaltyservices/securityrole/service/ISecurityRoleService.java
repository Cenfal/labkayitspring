package com.thy.loyalty.loyaltyservices.securityrole.service;

import com.thy.loyalty.loyaltyservices.securityrole.dto.SecurityRoleDetail;
import com.thy.loyalty.loyaltyservices.securityrole.dto.SecurityRoleResult;
import com.thy.ws.header.request.RequestHeader;

public interface ISecurityRoleService {

	SecurityRoleResult SecurityRoleOperation(RequestHeader requestHeader,
			SecurityRoleDetail securityRoleDetail);

}
