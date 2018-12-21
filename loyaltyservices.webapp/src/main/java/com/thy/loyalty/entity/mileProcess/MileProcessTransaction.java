/**
 * 
 */
package com.thy.loyalty.entity.mileProcess;

import com.thy.loyalty.loyaltyservices.milesell.dto.MileSellTransactionStatus;
import com.thy.loyalty.loyaltyservices.milesell.dto.MileType;
import com.thy.loyalty.ms.config.CraneDb;

/**
 * @author O_CETIN3
 *
 */
public class MileProcessTransaction {
	
	private int id;
	private MileType mileType;
	private String nphaseID="";
	private String startDate="";
	private int approvalCode;
	private int clmApprovalCode;
	private int emdNumber;
	private int dblogProcessID;
	private String orderID="";
	private MileSellTransactionStatus status;

	public void insertRecord() throws Exception{
		 
		int seq = CraneDb.getSequence("MILE_PROCESS_TRANSACTION_S");
		setId(seq);
		
		String sql="insert into mile_process_transaction "
				 + "(id"
				 + ", operation_type"
				 + ", nphase_id"
				 + ", start_date"
				 + ", approval_code"
				 + ", clm_approval_code"
				 + ", emd_number"
				 + ", dblog_process_id"
				 + ", order_id"
				 + ") "
				 + "values "
				 + "( "+seq
				 + ", '"+ mileType.toString() +"'"
				 + ", '"+nphaseID+"'"
				 + ", sysdate"
				 + ", "+approvalCode
				 + ", "+clmApprovalCode
				 + ", "+emdNumber
				 + ", "+ dblogProcessID
				 + ", '"+orderID+"'"
				 + ")";
		
		CraneDb.executeQuery(sql);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MileType getMileType() {
		return mileType;
	}
	public void setMileType(MileType mileType) {
		this.mileType = mileType;
	}
	public String getNphaseID() {
		return nphaseID;
	}
	public void setNphaseID(String nphaseID) {
		this.nphaseID = nphaseID;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getApprovalCode() {
		return approvalCode;
	}
	public void setApprovalCode(int approvalCode) {
		this.approvalCode = approvalCode;
	}
	public int getClmApprovalCode() {
		return clmApprovalCode;
	}
	public void setClmApprovalCode(int clmApprovalCode) {
		this.clmApprovalCode = clmApprovalCode;
	}
	public int getEmdNumber() {
		return emdNumber;
	}
	public void setEmdNumber(int emdNumber) {
		this.emdNumber = emdNumber;
	}
	public int getDblogProcessID() {
		return dblogProcessID;
	}
	public void setDblogProcessID(int dblogProcessID) {
		this.dblogProcessID = dblogProcessID;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public MileSellTransactionStatus getStatus() {
		return status;
	}
	public void setStatus(MileSellTransactionStatus status) {
		this.status = status;
	}
}
