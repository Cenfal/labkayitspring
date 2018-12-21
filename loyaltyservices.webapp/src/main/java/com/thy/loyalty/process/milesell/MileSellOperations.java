/**
 * 
 */
package com.thy.loyalty.process.milesell;

import com.thy.loyalty.ms.config.CraneDb;

/**
 * @author O_CETIN3
 *
 */
public class MileSellOperations {
	
	public static int generateApprovalCode(){
		
		int approvalCode=0;
		
		approvalCode = CraneDb.getSequence("MILE_PROCESS_APPROVAL_CODE_S");
		
		return approvalCode;
	}
}
