package com.thy.loyalty.entity.mileProcess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.jforce.connectors.oracle.Connector;
import com.thy.loyalty.loyaltyservices.milesell.dto.MileSellTransactionStatus;
import com.thy.loyalty.loyaltyservices.milesell.dto.MileType;
import com.thy.loyalty.ms.config.CraneDb;

public class MileProcessTransactionDAO {


	public static void updateEmdNumber(String emdNumber, int id) throws Exception{
		
		CraneDb.executeQuery("Update mile_process_transaction Set emd_number = '" + emdNumber + "' Where Id = " +id);
	}

	public static void updateClmApprovalCode(int clmApprovalCode, int id) throws Exception{
		
		CraneDb.executeQuery("Update mile_process_transaction Set clm_approval_code = " + clmApprovalCode + " Where Id = " +id);
	}

	public static void updateStatus(MileSellTransactionStatus status, int id) throws Exception{
		
		CraneDb.executeQuery("Update mile_process_transaction Set status = '" + status + "' Where Id = " +id);
	}
	
	public static List<MileProcessTransaction> getMileProcessTransactionList(String nphaseId) {

		List<MileProcessTransaction> listMileProcessTransaction = null;
		
		try {
			Connector con = CraneDb.getConnection();
			ResultSet rs = con.getResultSet("SELECT Approval_Code,Clm_Approval_Code,Dblog_Process_Id,Emd_Number,Id,Operation_Type,Order_Id,Start_Date,Status " +
					"FROM Mile_Process_Transaction Where nphase_id = '"+ nphaseId+"'");

			while (rs.next()) {
				MileProcessTransaction mileProcessTransaction = new MileProcessTransaction();
				
				mileProcessTransaction.setApprovalCode(new Integer(rs.getString(1)));
				mileProcessTransaction.setClmApprovalCode(new Integer(rs.getString(2)));
				mileProcessTransaction.setDblogProcessID(new Integer(rs.getString(3)));
				mileProcessTransaction.setEmdNumber(new Integer(rs.getString(4)));
				mileProcessTransaction.setId(new Integer(rs.getString(5)));
				mileProcessTransaction.setMileType(convertStringToMileType(rs.getString(6)));
				mileProcessTransaction.setOrderID(rs.getString(7));
				mileProcessTransaction.setStartDate(rs.getString(8));
				mileProcessTransaction.setStatus(convertStringToMileSellTransactionStatus(rs.getString(9)));
				
				listMileProcessTransaction.add(mileProcessTransaction);
			}
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listMileProcessTransaction;
	}

	private static MileSellTransactionStatus convertStringToMileSellTransactionStatus( String status) {
	
		if ("COMPLETED".equals(status)) {
			return MileSellTransactionStatus.COMPLETED;
		}else if ("FAILED".equals(status)) {
			return MileSellTransactionStatus.FAILED;
		}else if ("INPROGRESS".equals(status)) {
			return MileSellTransactionStatus.INPROGRESS;
		}else if ("ROLLBACK".equals(status)) {
			return MileSellTransactionStatus.ROLLBACK;
		}else if ("STARTED".equals(status)) {
			return MileSellTransactionStatus.STARTED;
		}
		return null;	
	}
	
	private static MileType convertStringToMileType( String mileType) {
	
		if ("bonus".equals(mileType)) {
			return MileType.bonus;
		}else if ("expireMileReaktivate".equals(mileType)) {
			return MileType.expireMileReaktivate;
		}else if ("mileReaktivate".equals(mileType)) {
			return MileType.mileReaktivate;
		}else if ("mileTransfer".equals(mileType)) {
			return MileType.mileTransfer;
		}else if ("statu".equals(mileType)) {
			return MileType.statu;
		}else if ("upgrade".equals(mileType)) {
			return MileType.upgrade;
		}
		return null;	
	}
}
