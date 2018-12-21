package com.thy.loyalty.loyaltyservices.couponoperation.service;

import com.thy.loyalty.loyaltyservices.couponoperation.dto.CouponOperationDetail;
import com.thy.loyalty.loyaltyservices.couponoperation.dto.CouponOperationResult;
import com.thy.ws.header.request.RequestHeader;

public interface ICouponOperationService {

	public CouponOperationResult lyCreateLoungePromo(CouponOperationDetail couponDetail,
			RequestHeader requestHeader) throws Exception;
	
	public CouponOperationResult useCouponExt(CouponOperationDetail couponDetail,
			RequestHeader requestHeader) throws Exception;
	
	public CouponOperationResult lyCancelCoupon(CouponOperationDetail couponDetail,
			RequestHeader requestHeader) throws Exception;
}
