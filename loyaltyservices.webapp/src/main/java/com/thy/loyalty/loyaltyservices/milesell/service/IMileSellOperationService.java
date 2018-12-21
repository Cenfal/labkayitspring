package com.thy.loyalty.loyaltyservices.milesell.service;

import com.thy.loyalty.loyaltyservices.milesell.dto.MileSellProcessDetail;
import com.thy.loyalty.loyaltyservices.milesell.dto.MileSellProcessResult;
import com.thy.loyalty.loyaltyservices.milesell.dto.UndoMileSellProcessDetail;
import com.thy.loyalty.loyaltyservices.milesell.dto.UndoMileSellProcessResult;
import com.thy.loyalty.ms.dblog.DBLogRecord;
import com.thy.ws.header.request.RequestHeader;

public interface IMileSellOperationService {
	
	public MileSellProcessResult mileSellProcess(RequestHeader requestHeader, MileSellProcessDetail mileSellProcessDetail, DBLogRecord dbLog) throws Exception;
	
	public UndoMileSellProcessResult undoMileSellProcess(RequestHeader requestHeader, UndoMileSellProcessDetail undoMileSellProcessDetail, DBLogRecord dbLog);
	
}
