package com.thy.loyalty.loyaltyservices.mileredemption.service;


import com.thy.loyalty.loyaltyservices.mileredemption.dto.CheckOrderIDDetail;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.CheckOrderIDResult;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.GetOrderIDDetail;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.GetOrderIDResult;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.GetParametersDetail;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.GetParametersResult;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.MrglogDetail;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.MrglogResult;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.OrderValuesDetail;
import com.thy.loyalty.loyaltyservices.mileredemption.dto.OrderValuesResult;
import com.thy.ws.header.request.RequestHeader;


public interface IMileRedemptionGatewayService {
	
	public GetOrderIDResult GetOrderID(RequestHeader requestHeader,GetOrderIDDetail getOrderIDDetail) throws Exception;
	
	public GetParametersResult getParameters(RequestHeader requestHeader,GetParametersDetail getParametersDetail) throws Exception;
	
	public OrderValuesResult OrderValues(RequestHeader requestHeader,OrderValuesDetail orderValuesDetail) throws Exception;
	
	public MrglogResult Mrglog(RequestHeader requestHeader,MrglogDetail mrglogDetail) throws Exception;
	
	public CheckOrderIDResult CheckOrderID(RequestHeader requestHeader,CheckOrderIDDetail checkOrderIDDetail) throws Exception;


}

