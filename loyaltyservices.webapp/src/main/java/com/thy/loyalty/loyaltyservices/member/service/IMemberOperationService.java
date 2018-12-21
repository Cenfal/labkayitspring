/**
 * 
 */
package com.thy.loyalty.loyaltyservices.member.service;

import com.thy.loyalty.loyaltyservices.member.dto.MembersTroyaUpdatePoolListDetail;
import com.thy.loyalty.loyaltyservices.member.dto.MembersTroyaUpdatePoolListResult;
import com.thy.loyalty.loyaltyservices.member.dto.TriggerTroyaCHIPDetail;
import com.thy.loyalty.loyaltyservices.member.dto.TriggerTroyaCHIPResult;
import com.thy.loyalty.loyaltyservices.member.dto.UpdateMemberStatusDetail;
import com.thy.loyalty.loyaltyservices.member.dto.UpdateMemberStatusResult;
import com.thy.loyalty.ms.dblog.DBLogRecord;
import com.thy.ws.header.request.RequestHeader;

/**
 * @author O_CETIN3
 *
 */
public interface IMemberOperationService {

	public TriggerTroyaCHIPResult triggerTroyaCHIP(RequestHeader requestHeader, TriggerTroyaCHIPDetail triggerTroyaCHIPDetail, DBLogRecord dbLog) throws Exception;
	public MembersTroyaUpdatePoolListResult membersTroyaUpdatePoolList(RequestHeader requestHeader, MembersTroyaUpdatePoolListDetail membersTroyaUpdatePoolListDetail, DBLogRecord dbLog) throws Exception;
	public UpdateMemberStatusResult updateMemberStatus(RequestHeader requestHeader, UpdateMemberStatusDetail updateMemberStatusDetail, DBLogRecord dbLog) throws Exception;
}
