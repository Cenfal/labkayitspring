package com.thy.loyalty.loyaltyservices.couponoperation.service.impl;

import gtesb.bc1c2850response.WsServiceResponse;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.jforce.connectors.oracle.Connector;
import com.thy.loyalty.loyaltyservices.couponoperation.dto.CouponOperationDetail;
import com.thy.loyalty.loyaltyservices.couponoperation.dto.CouponOperationResult;
import com.thy.loyalty.loyaltyservices.couponoperation.service.ICouponOperationService;
import com.thy.loyalty.ms.config.CraneDb;
import com.thy.loyalty.ms.config.StringUtils;
import com.thy.loyalty.ms.utility.dto.Utils;
import com.thy.ws.header.request.RequestHeader;

@Service
public class CouponOperationServiceImpl implements ICouponOperationService {

	private static Log logger = LogFactory.getLog(CouponOperationServiceImpl.class);
	private static final String ServiceName = "CouponOperationService";

	@Override
	public CouponOperationResult lyCreateLoungePromo(CouponOperationDetail couponDetail,
			RequestHeader requestHeader) throws Exception{

		CouponOperationResult result = new CouponOperationResult();

		String partnerCode = "";
		String partnerUserName = "";
		String channelCode = "";
		String airlineCode = "";
		String application = "";
		String agent = "";
		String language = "";

		logger.info("insert_to_cip_coupon has been called..");
		Connector con = null;
		java.sql.CallableStatement cs = null;
		try {
			partnerCode = requestHeader.getClientCode();
			partnerUserName = requestHeader.getClientUsername();
			channelCode = (requestHeader.getChannel() == null) ? "" : Utils
					.validateChannelType(requestHeader.getChannel());
			airlineCode = requestHeader.getAirlineCode();
			application = requestHeader.getApplication();
			agent = requestHeader.getAgent();
			language = (requestHeader.getLanguageCode() == null) ? "EN" : Utils
					.validateRequestLanguage(requestHeader.getLanguageCode());

			logger.info("Start CraneDb.getMSPoolConnection()");
			con = CraneDb.getMSPoolConnection();
			logger.info("End CraneDb.getMSPoolConnection()");

			if(couponDetail.getCouponCode() != null){

				String query =  "begin\n" +
						"  -- Call the procedure\n" + 
						"  insert_to_cip_coupon(i_v_member_id => :i_v_member_id,\n" + 
						"                       i_v_coupon_type => :i_v_coupon_type,\n" + 
						"                       i_v_counter => :i_v_counter,\n" + 
						"                       i_v_status => :i_v_status,\n" + 
						"                       i_v_coupon_code => :i_v_coupon_code,\n" + 
						"                       i_v_insert_by => :i_v_insert_by,\n" + 
						"                       p_out_response_code => :p_out_response_code,\n" + 
						"                       p_out_response_description => :p_out_response_description);\n" + 
						"end;";


				cs = con.prepareCall(query);
				cs.setString(1, couponDetail.getMemberId());
				cs.setString(2, couponDetail.getCouponType());
				cs.setInt(3, 1);
				cs.setString(4,"NU");
				cs.setString(5, couponDetail.getCouponCode().toString());
				cs.setString(6, partnerUserName);
				cs.registerOutParameter(7, java.sql.Types.VARCHAR);
				cs.registerOutParameter(8, java.sql.Types.VARCHAR);
				con.getData(cs);
				String responseCode = cs.getString(7);
				String responseDescription = cs.getString(8);
				if (responseCode != null) {
					result.setResultCode(responseCode);
					result.setResultDescription(responseDescription);
				} else {
					result.setResultCode("09");
					result.setResultDescription("FAIL");
				}
			}


		} catch (Exception e) {
			logger.error("Error in insert_to_cip_coupon "
					+ StringUtils.stack2string(e));
		} finally {
			try {
				cs.close();

			} catch (SQLException e) {
				logger.error("Error in " + ServiceName + " (SQLException) "
						+ StringUtils.stack2string(e));
			}catch (Exception e) {
				logger.error("Error in " + ServiceName 
						+ StringUtils.stack2string(e));
			}
			con.disconnectDB();
		}
		return result;

	}

	@Override
	public CouponOperationResult useCouponExt(CouponOperationDetail couponDetail,
			RequestHeader requestHeader) throws Exception{

		CouponOperationResult result = new CouponOperationResult();

		String partnerCode = "";
		String partnerUserName = "";
		String channelCode = "";
		String airlineCode = "";
		String application = "";
		String agent = "";
		String language = "";

		logger.info("use_cip_coupon has been called..");
		Connector con = null;
		java.sql.CallableStatement cs = null;
		try {
			partnerCode = requestHeader.getClientCode();
			partnerUserName = requestHeader.getClientUsername();
			channelCode = (requestHeader.getChannel() == null) ? "" : Utils
					.validateChannelType(requestHeader.getChannel());
			airlineCode = requestHeader.getAirlineCode();
			application = requestHeader.getApplication();
			agent = requestHeader.getAgent();
			language = (requestHeader.getLanguageCode() == null) ? "EN" : Utils
					.validateRequestLanguage(requestHeader.getLanguageCode());

			con = CraneDb.getMSPoolConnection();

			String query =  "begin\n" +
							"  -- Call the procedure\n" + 
							"  use_cip_coupon(i_v_member_id => :i_v_member_id,\n" + 
							"                 i_v_coupon_type => :i_v_coupon_type,\n" + 
							"                 p_out_response_code => :p_out_response_code,\n" + 
							"                 p_out_response_description => :p_out_response_description,\n" + 
							"                 p_coupon_code => :p_coupon_code);\n" + 
							"end;";

			cs = con.prepareCall(query);
			cs.setString(1, couponDetail.getMemberId());
			cs.setString(2, couponDetail.getCouponType());
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.registerOutParameter(4, java.sql.Types.VARCHAR);
			cs.registerOutParameter(5, java.sql.Types.VARCHAR);
			con.getData(cs);
			String responseCode = cs.getString(3);
			String responseDescription = cs.getString(4);
			String couponCode = cs.getString(5);
			if (responseCode != null) {
				result.setResultCode(responseCode);
				result.setResultDescription(responseDescription);
				if("00".equals(responseCode)){
					WsServiceResponse response = GarantiCIPCouponDAO.useGarantiCoupon(couponCode);
					//TODO response sonucunu kontrol et ve gerekirse hata olarak sonuca ekle
				}
			} else {
				result.setResultCode("09");
				result.setResultDescription("FAIL");
			}


		} catch (Exception e) {
			logger.error("Error in insert_to_cip_coupon "
					+ StringUtils.stack2string(e));
		} finally {
			try {
				cs.close();

			} catch (SQLException e) {
				logger.error("Error in " + ServiceName + " (SQLException) "
						+ StringUtils.stack2string(e));
			}
			con.disconnectDB();
		}
		return result;

	}



	@Override
	public CouponOperationResult lyCancelCoupon(CouponOperationDetail couponDetail,
			RequestHeader requestHeader) throws Exception{

		CouponOperationResult result = new CouponOperationResult();

		String partnerCode = "";
		String partnerUserName = "";
		String channelCode = "";
		String airlineCode = "";
		String application = "";
		String agent = "";
		String language = "";

		logger.info("cancel_cip_coupon has been called..");
		Connector con = null;
		java.sql.CallableStatement cs = null;
		try {
			partnerCode = requestHeader.getClientCode();
			partnerUserName = requestHeader.getClientUsername();
			channelCode = (requestHeader.getChannel() == null) ? "" : Utils
					.validateChannelType(requestHeader.getChannel());
			airlineCode = requestHeader.getAirlineCode();
			application = requestHeader.getApplication();
			agent = requestHeader.getAgent();
			language = (requestHeader.getLanguageCode() == null) ? "EN" : Utils
					.validateRequestLanguage(requestHeader.getLanguageCode());

			con = CraneDb.getMSPoolConnection();

			if(couponDetail.getCouponCode() != null ){

				String query =  "begin\n" +
						"  -- Call the procedure\n" + 
						"  cancel_cip_coupon(i_v_coupon_code => :i_v_coupon_code,\n" + 
						"                    i_v_member_id => :i_v_member_id,\n" + 
						"                    p_out_response_code => :p_out_response_code,\n" + 
						"                    p_out_response_description => :p_out_response_description);\n" + 
						"end;";

				cs = con.prepareCall(query);
				cs.setString(1, couponDetail.getCouponCode().toString());
				cs.setString(2, couponDetail.getMemberId());
				cs.registerOutParameter(3, java.sql.Types.VARCHAR);
				cs.registerOutParameter(4, java.sql.Types.VARCHAR);
				con.getData(cs);
				String responseCode = cs.getString(3);
				String responseDescription = cs.getString(4);
				if (responseCode != null) {
					result.setResultCode(responseCode);
					result.setResultDescription(responseDescription);
				} else {
					result.setResultCode("09");
					result.setResultDescription("FAIL");
				}
			}


		} catch (Exception e) {
			logger.error("Error in cancel_cip_coupon "
					+ StringUtils.stack2string(e));
		} finally {
			try {
				cs.close();

			} catch (SQLException e) {
				logger.error("Error in " + ServiceName + " (SQLException) "
						+ StringUtils.stack2string(e));
			}
			con.disconnectDB();
		}
		return result;

	}
}
