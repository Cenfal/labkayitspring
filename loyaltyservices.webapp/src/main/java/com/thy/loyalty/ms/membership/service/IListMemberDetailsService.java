package com.thy.loyalty.ms.membership.service;

import com.thy.loyalty.ms.membership.dto.GetMemberDetailsListResponse;

public interface IListMemberDetailsService {
	
	public GetMemberDetailsListResponse listMemberDetails(	String companyCode,
														String companyUsername, 
														String companyPassword, 
														String ip,
														String ffid,
														String pinNumber, 
														String name, 
														String surname, 
														String birthDate);

}
