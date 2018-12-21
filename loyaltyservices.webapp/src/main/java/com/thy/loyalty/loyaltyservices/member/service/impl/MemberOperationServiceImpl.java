/**
 * 
 */
package com.thy.loyalty.loyaltyservices.member.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thy.loyalty.loyaltyservices.member.dto.MembersTroyaUpdatePoolDto;
import com.thy.loyalty.loyaltyservices.member.dto.MembersTroyaUpdatePoolListDetail;
import com.thy.loyalty.loyaltyservices.member.dto.MembersTroyaUpdatePoolListResult;
import com.thy.loyalty.loyaltyservices.member.dto.MembersTroyaUpdatePoolStatus;
import com.thy.loyalty.loyaltyservices.member.dto.TriggerTroyaCHIPDetail;
import com.thy.loyalty.loyaltyservices.member.dto.TriggerTroyaCHIPResult;
import com.thy.loyalty.loyaltyservices.member.dto.UpdateMemberStatusDetail;
import com.thy.loyalty.loyaltyservices.member.dto.UpdateMemberStatusResult;
import com.thy.loyalty.loyaltyservices.member.service.IMemberOperationService;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.loyalty.ms.config.WsConfig;
import com.thy.loyalty.ms.dblog.DBLogRecord;
import com.thy.ws.header.request.RequestHeader;

/**
 * @author O_CETIN3
 *
 */
@Service
public class MemberOperationServiceImpl implements IMemberOperationService {

	/* (non-Javadoc)
	 * @see com.thy.entrychannel.loyaltyservices.member.service.IMemberOperationService#triggerTroyaCHIP(com.thy.ws.header.request.RequestHeader, com.thy.entrychannel.loyaltyservices.member.dto.TriggerTroyaCHIPDetail, com.thy.entrychannel.ms.dblog.DBLogRecord)
	 */
	@Override
	public TriggerTroyaCHIPResult triggerTroyaCHIP(RequestHeader requestHeader,
			TriggerTroyaCHIPDetail triggerTroyaCHIPDetail, DBLogRecord dbLog) throws Exception {

		dbLog.InsertComment("triggerTroyaCHIP has been called. Member Id:"+triggerTroyaCHIPDetail.getMemberID());
		TriggerTroyaCHIPResult triggerTroyaCHIPResult = new TriggerTroyaCHIPResult();
		
		boolean existsNewRecord = false;
		
		String thresholdTime = "10";
		if (WsConfig.getInstance().MEMBEROPERATION_SERVICE_MEMBER_THRESHOLDTIME!=null) {
			thresholdTime = WsConfig.getInstance().MEMBEROPERATION_SERVICE_MEMBER_THRESHOLDTIME;
		}
		
		try {
			List<MembersTroyaUpdatePoolDto> listMembersTroyaUpdatePoolList = MemberOperationServiceDAO.getMembersTroyaUpdatePoolListByMemberId(triggerTroyaCHIPDetail.getMemberID());
			if (listMembersTroyaUpdatePoolList!=null) {
				for (MembersTroyaUpdatePoolDto membersTroyaUpdatePoolDto : listMembersTroyaUpdatePoolList) {
//					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
//					long diff = Calendar.getInstance().getTimeInMillis() - df.parse(membersTroyaUpdatePoolDto.getInsertDate()).getTime();
					// Server saati ile veritabaný saati arasýnda fark olunca sorun oluyor, o yüzden server saati deðil veritabaný saati alýndý
					if ((new Long(thresholdTime)).compareTo(membersTroyaUpdatePoolDto.getInsertTime())==1) { // 10 dk
						existsNewRecord = true;
						break;
					}
				}
			}
			
			if (!existsNewRecord) {

				int id = MemberOperationServiceDAO.insertMember(triggerTroyaCHIPDetail.getMemberID());
				dbLog.InsertComment("Member has been inserted, id: "+id);
				
			}else {
				dbLog.InsertComment("Member already has an unsent record");
			}

			triggerTroyaCHIPResult.setResultCode("00");
			triggerTroyaCHIPResult.setResultDescription("SUCCESS");
			dbLog.InsertComment("triggerTroyaCHIP has returned success. Member Id:"+triggerTroyaCHIPDetail.getMemberID());
			
		} catch (Exception e) {
			triggerTroyaCHIPResult.setResultCode("09");
			triggerTroyaCHIPResult.setResultDescription(StringUtils.stack2string(e));
			dbLog.InsertComment("Exception : " + StringUtils.stack2string(e));
			return triggerTroyaCHIPResult;
		}
		
		return triggerTroyaCHIPResult;
	}

	@Override
	public MembersTroyaUpdatePoolListResult membersTroyaUpdatePoolList(
			RequestHeader requestHeader,
			MembersTroyaUpdatePoolListDetail membersTroyaUpdatePoolListDetail,
			DBLogRecord dbLog) throws Exception {

		MembersTroyaUpdatePoolListResult membersTroyaUpdatePoolListResult = new MembersTroyaUpdatePoolListResult();
		List<String> listMemberId = new ArrayList<String>();
		
		List<String> statusList = new ArrayList<String>();
		statusList.add(MembersTroyaUpdatePoolStatus.NEW.toString());
		statusList.add(MembersTroyaUpdatePoolStatus.FAILURE.toString());

		try {
			List<MembersTroyaUpdatePoolDto> listMembersTroyaUpdatePool = MemberOperationServiceDAO.getMembersTroyaUpdatePoolListByStatus(statusList);
			
			for (MembersTroyaUpdatePoolDto membersTroyaUpdatePoolDto : listMembersTroyaUpdatePool) {
				listMemberId.add(membersTroyaUpdatePoolDto.getMemberId());
			}

			membersTroyaUpdatePoolListResult.setListMemberId(listMemberId);
			
			membersTroyaUpdatePoolListResult.setResultCode("00");
			membersTroyaUpdatePoolListResult.setResultDescription("SUCCESS");
			dbLog.InsertComment("membersTroyaUpdatePoolList has returned success. Member count:"+membersTroyaUpdatePoolListResult.getListMemberId().size());
		} catch (Exception e) {
			membersTroyaUpdatePoolListResult.setResultCode("09");
			membersTroyaUpdatePoolListResult.setResultDescription(StringUtils.stack2string(e));
			dbLog.InsertComment("Exception : " + StringUtils.stack2string(e));
			return membersTroyaUpdatePoolListResult;
		}
		
		return membersTroyaUpdatePoolListResult;
	}

	@Override
	public UpdateMemberStatusResult updateMemberStatus(
			RequestHeader requestHeader,
			UpdateMemberStatusDetail updateMemberStatusDetail, DBLogRecord dbLog)
			throws Exception {

		UpdateMemberStatusResult updateMemberStatusResult = new UpdateMemberStatusResult();

		try {
			MemberOperationServiceDAO.updateMemberStatus(updateMemberStatusDetail.getMemberId(), updateMemberStatusDetail.getStatus(), updateMemberStatusDetail.getMessage());
			
			updateMemberStatusResult.setResultCode("00");
			updateMemberStatusResult.setResultDescription("SUCCESS");
			dbLog.InsertComment("updateMemberStatus has returned success.");
		} catch (Exception e) {
			updateMemberStatusResult.setResultCode("09");
			updateMemberStatusResult.setResultDescription(StringUtils.stack2string(e));
			dbLog.InsertComment("Exception : " + StringUtils.stack2string(e));
			return updateMemberStatusResult;
		}

		return updateMemberStatusResult;
	}

}
