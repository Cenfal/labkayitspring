package com.thy.loyalty.loyaltyservices.member.service.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jforce.connectors.oracle.Connector;
import com.thy.loyalty.loyaltyservices.member.dto.MembersTroyaUpdatePoolDto;
import com.thy.loyalty.loyaltyservices.member.dto.MembersTroyaUpdatePoolStatus;
import com.thy.loyalty.ms.config.CraneDb;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.loyalty.ms.config.WsConfig;

public class MemberOperationServiceDAO {

	public static List<MembersTroyaUpdatePoolDto> getMembersTroyaUpdatePoolListByMemberId(String memberId) {

		List<MembersTroyaUpdatePoolDto> listMembersTroyaUpdatePool = new ArrayList<MembersTroyaUpdatePoolDto>();
		Connector con = null;
		ResultSet rs = null;
		try {
		    String sql = "SELECT Id,Member_Id,Insert_Date,Process_Date,Status, TRUNC((Sysdate-Insert_Date)*1440) Insert_Time " +
					"FROM Members_Troya_Update_Pool " +
				"WHERE Member_Id = '"+ memberId+"' " +
				  "AND Status in ('"+MembersTroyaUpdatePoolStatus.NEW+"','"+MembersTroyaUpdatePoolStatus.FAILURE+"')";
		    
			con = CraneDb.getConnection();
			rs = con.getResultSet(sql);

			while (rs.next()) {
				MembersTroyaUpdatePoolDto membersTroyaUpdatePool = new MembersTroyaUpdatePoolDto();

				membersTroyaUpdatePool.setId(new Integer(rs.getString(1)));
				membersTroyaUpdatePool.setMemberId(rs.getString(2));
				membersTroyaUpdatePool.setInsertDate(rs.getString(3));
				membersTroyaUpdatePool.setProcessDate(rs.getString(4));
				membersTroyaUpdatePool.setStatus(rs.getString(5));
				membersTroyaUpdatePool.setInsertTime(new Long(rs.getString(6)));
				
				listMembersTroyaUpdatePool.add(membersTroyaUpdatePool);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(StringUtils.stack2string(e));
		}finally {
	          try { 
	        	  rs.close();
	        	  con.disconnectDB();
	          } catch (Exception ignore) { }
	    } 
		
		return listMembersTroyaUpdatePool;
	}

	public static List<MembersTroyaUpdatePoolDto> getMembersTroyaUpdatePoolListByStatus(List<String> statusList) {

		List<MembersTroyaUpdatePoolDto> listMembersTroyaUpdatePool = new ArrayList<MembersTroyaUpdatePoolDto>();
		
		String endTime = "30";
		if (WsConfig.getInstance().MEMBEROPERATION_SERVICE_MEMBER_ENDDAY!=null) {
			endTime = WsConfig.getInstance().MEMBEROPERATION_SERVICE_MEMBER_ENDDAY;
		}
		
		String status ="";
		for (String string : statusList) {
			status = status+string+"','";
		}
		
		Connector con = null;
		ResultSet rs = null;
		
		try {
			con = CraneDb.getConnection();
			rs = con.getResultSet(  "SELECT id                                                      			  \n" +
									"      ,member_id                                                             \n" + 
									"      ,insert_date                                                           \n" + 
									"      ,process_date                                                          \n" + 
									"      ,status                                                                \n" + 
									"      ,insert_time                                                           \n" + 
									"FROM   (SELECT MIN(id) id                                                    \n" + 
									"              ,member_id                                                     \n" + 
									"              ,MIN(insert_date) insert_date                                  \n" + 
									"              ,MIN(process_date) process_date                                \n" + 
									"              ,MAX(status) status                                            \n" + 
									"              ,trunc((SYSDATE - MIN(insert_date)) * 1440) insert_time        \n" + 
									"        FROM   loyaltydb.members_troya_update_pool                           \n" + 
									"        WHERE  status IN ('" + status + "')                                  \n" + 
									"        GROUP  BY member_id                                                  \n" + 
									"        HAVING trunc((SYSDATE - MAX(insert_date))) <= " + endTime + "        \n" + 
									"        ORDER  BY insert_date)                                               \n" + 
									"WHERE  rownum < 1000"
								);

			while (rs.next()) {
				MembersTroyaUpdatePoolDto membersTroyaUpdatePool = new MembersTroyaUpdatePoolDto();
				
				membersTroyaUpdatePool.setId(new Integer(rs.getString(1)));
				membersTroyaUpdatePool.setMemberId(rs.getString(2));
				membersTroyaUpdatePool.setInsertDate(rs.getString(3));
				membersTroyaUpdatePool.setProcessDate(rs.getString(4));
				membersTroyaUpdatePool.setStatus(rs.getString(5));
				membersTroyaUpdatePool.setInsertTime(new Long(rs.getString(6)));
				
				listMembersTroyaUpdatePool.add(membersTroyaUpdatePool);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
	          try { 
	        	  rs.close();
	        	  con.disconnectDB();
	          } catch (Exception ignore) { }
	    }
		
		return listMembersTroyaUpdatePool;
	}

	public static Integer insertMember(String memberId) throws Exception{
		 
		int seq = CraneDb.getSequence("MEMBERS_TROYA_UPDATE_POOL_S");
		
		String sql="INSERT INTO Members_Troya_Update_Pool "
				 + "(Id"
				 + ", Member_Id"
				 + ", Insert_Date"
				 + ", Process_Date"
				 + ", Status"
				 + ") "
				 + "values "
				 + "( "+seq
				 + ", '"+ memberId +"'"
				 + ", sysdate"
				 + ", null"
				 + ", '"+ MembersTroyaUpdatePoolStatus.NEW +"'"
				 + ")";
		
		CraneDb.executeQuery(sql);
		
		return seq;
	}

	public static void updateMemberStatus(String memberId, String status, String message) throws Exception{
		
		String sql="UPDATE Members_Troya_Update_Pool "
				 + "SET Status ='"+status+"',Message = '"+message+"', Process_Date = Sysdate "
				 + "WHERE Member_Id ='"+ memberId +"' AND Status <> 'SUCCESS'";
		
		CraneDb.executeQuery(sql);
		
	}

}
