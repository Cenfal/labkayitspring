package com.thy.loyalty.process.bookingws;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import com.thy.client.CardPaymentDTO;
import com.thy.client.CardPaymentDataDTO;
import com.thy.client.CashPaymentDataDTO;
import com.thy.client.EmdsCreateOTARequest;
import com.thy.client.FareComponentTypeDTO;
import com.thy.client.FlightTypeDTO;
import com.thy.client.MilesPaymentDTO;
import com.thy.client.MilesPaymentDataDTO;
import com.thy.client.PaymentDTO;
import com.thy.client.PaymentInfoDTO;
import com.thy.client.ProfileTypeDTO;
import com.thy.client.VposPaymentDTO;
import com.thy.client.VposPaymentDataDTO;
import com.thy.loyalty.loyaltyservices.milesell.dto.MileType;
import com.thy.loyalty.loyaltyservices.milesell.dto.PaymentType;
import com.thy.loyalty.ms.common.operations.CommonJava;
import com.thy.loyalty.ms.common.operations.Utils;
import com.thy.loyalty.ms.config.ParameterKeys;
import com.thy.loyalty.ms.config.Parameters;
import com.thy.loyalty.ms.dblog.DBLogRecord;
import com.thy.loyalty.ms.ws.redemption.w3.SignInType;

public class BookingWSOperations {


	public static void createEMD(CreateEmdDetail createEmdDetail, DBLogRecord dbLog) throws Exception {
		
		try {

			String officeNumber = Parameters.getString(ParameterKeys.MSMILESELLSERVICE_INVALID_SOR);

			if (Parameters.getString(ParameterKeys.MSMILESELLSERVICE_USD).equals(createEmdDetail.getCurrency())) {

				officeNumber = Parameters.getString(ParameterKeys.MSMILESELLSERVICE_SOR_USD);

			} else if (Parameters.getString(ParameterKeys.MSMILESELLSERVICE_TRY).equals(createEmdDetail.getCurrency())) {

				officeNumber = Parameters.getString(ParameterKeys.MSMILESELLSERVICE_SOR_TRY);
			}

			SignInType signcode = new SignInType();

			signcode.setCityCode(Parameters.getString(ParameterKeys.EMDSERVICE_SIGN_CITY_CODE));
			signcode.setOfficeNumber(officeNumber);
			signcode.setDutyCode(Parameters.getString(ParameterKeys.EMDSERVICE_SIGN_DUTY_CODE));
			signcode.setInitials(Parameters.getString(ParameterKeys.EMDSERVICE_SIGN_INITIAL));

			String emdType = "";
			// 10.12.2014 - osman.cetin - fix
			if ((createEmdDetail.getMileType() == MileType.bonus)) {
//
//				signcode.setType(Parameters.getString(ParameterKeys.EMDSERVICE_SIGN_CODE_TYPE_BONUS));
			emdType = Parameters.getString(ParameterKeys.EMDSERVICE_SIGN_CODE_TYPE_BONUS);
//
			} else if ((createEmdDetail.getMileType() == MileType.statu)
					|| (createEmdDetail.getMileType() == MileType.upgrade)) {
//
//				signcode.setType(Parameters.getString(ParameterKeys.EMDSERVICE_SIGN_CODE_TYPE_STATU));
			emdType = Parameters.getString(ParameterKeys.EMDSERVICE_SIGN_CODE_TYPE_STATU);
//
			} else if (createEmdDetail.getMileType() == MileType.mileTransfer) {
//
//				signcode.setType(Parameters.getString(ParameterKeys.EMDSERVICE_SIGN_CODE_TYPE_TRANSFER));
			emdType = Parameters.getString(ParameterKeys.EMDSERVICE_SIGN_CODE_TYPE_TRANSFER);
//
			} else if ((createEmdDetail.getMileType() == MileType.mileReaktivate)
					|| (createEmdDetail.getMileType() == MileType.expireMileReaktivate)) {
//
//				signcode.setType(Parameters.getString(ParameterKeys.EMDSERVICE_SIGN_CODE_TYPE_REACTIVE));
			emdType = Parameters.getString(ParameterKeys.EMDSERVICE_SIGN_CODE_TYPE_REACTIVE);
			}

			double taxRate = 0;
			double amount = 0;

			try {
				amount = createEmdDetail.getPrice().doubleValue();
				taxRate = createEmdDetail.getTax().doubleValue();

			} catch (Exception e) {
			}
			
			double amountWithoutTax = amount - (amount * (taxRate * 0.01));
			double tax = amount * (taxRate * 0.01);
			DecimalFormatSymbols symbol = new DecimalFormatSymbols();
			symbol.setDecimalSeparator('.');
			DecimalFormat df = new DecimalFormat("#.00", symbol);

			String formatAmount = df.format(amount);
			String formatTax = df.format(tax);
			String formatAmountWithoutTax = df.format(amountWithoutTax);

			PaymentInfoDTO paymentInfo = new PaymentInfoDTO();
			
			if (PaymentType.VPOS.equals(createEmdDetail.getPaymentType())) {
				
				VposPaymentDTO vposPayment = new VposPaymentDTO();
				vposPayment.setAmount(formatAmount);
				
				if (createEmdDetail.getCreditCard()!=null) {
					vposPayment.setAuthorizationCode(createEmdDetail.getCreditCard().getAuthCode());
					vposPayment.setBankCode(createEmdDetail.getCreditCard().getBankCode());
					vposPayment.setCardNumber(createEmdDetail.getCreditCard().getCardNumber());
					
					if ("1".equals(createEmdDetail.getCreditCard().getCardType())) {
						
						vposPayment.setCardType("EC");
						
					} else {
						
						vposPayment.setCardType("VI");
					}
					
					vposPayment.setExpirationDate(createEmdDetail.getCreditCard().getExpireDate().format("yyyyMMdd").toString());
					vposPayment.setHostDate(createEmdDetail.getCreditCard().getHostDate());
					vposPayment.setVirtualCard(createEmdDetail.getCreditCard().isVirtualCard());
				}
				
				vposPayment.setCurrency(createEmdDetail.getCurrency());
				// vpos[0].setVposTransactionId(msc.getCreditCard().getTrxID());
				// commonOrderID gelistirmesi _ EAky
				
				// maksimum 13 karakter olmali transaction id veya kendi urettigin
				
				// vpos[0].setReferenceCode(msc.getCreditCard().getTrxID());
				// commonOrderID gelistirmesi _ EAky
				vposPayment.setPosType("VPOS");
				vposPayment.setPassengerIndex("1");
				// vpos[0].setElit(false); // commonOrderID gelistirmesi _ EAky
				
				// BEGIN - commonOrderID gelistirmesi _ EAky
				vposPayment.setOrderId(createEmdDetail.getOrderId());
				vposPayment.setInstallmentPeriod(1);
				
				VposPaymentDataDTO vposPaymentData = new VposPaymentDataDTO();
				vposPaymentData.getVposPaymentList().add(vposPayment);
				paymentInfo.setVposPaymentData(vposPaymentData);
			}
			// END - commonOrderID gelistirmesi _ EAky

			if (PaymentType.CARD.equals(createEmdDetail.getPaymentType())) {
				CardPaymentDTO cardPayment = new CardPaymentDTO();

				cardPayment.setAmount(formatAmount);

				if (createEmdDetail.getCreditCard()!=null) {
					cardPayment.setCardNumber(createEmdDetail.getCreditCard().getCardNumber());
					
					if ("1".equals(createEmdDetail.getCreditCard().getCardType())) {
						cardPayment.setCardType("EC");
					} else {
						cardPayment.setCardType("VI");
					}
					
					cardPayment.setExpirationDate(createEmdDetail.getCreditCard().getExpireDate().format("yyyyMM").toString());
				}
				
				cardPayment.setCurrency(createEmdDetail.getCurrency());
				cardPayment.setPassengerIndex("1");
				cardPayment.setPosType("COMMONPOS");

				CardPaymentDataDTO cardPaymentData = new CardPaymentDataDTO();
				cardPaymentData.getCardPaymentList().add(cardPayment);
				paymentInfo.setCardPaymentData(cardPaymentData);
			}
			
			//TODO: Mile olmadan EMD servisi kabul etmiyor ??
//			if (PaymentType.MILE.equals(createEmdDetail.getPaymentType())) {
				MilesPaymentDTO milesPayment = new MilesPaymentDTO();
				milesPayment.setAmount(formatAmount);
				milesPayment.setCurrency(createEmdDetail.getCurrency());
				milesPayment.setMemberId(createEmdDetail.getMember().getMemberId());
				milesPayment.setMiles(String.valueOf(createEmdDetail.getMileAmount()));
				milesPayment.setMsApprovalCode(String.valueOf(createEmdDetail.getApprovalCode()));
				milesPayment.setMilesPaymentOperationType("ADD_MILE");
				milesPayment.setPassengerIndex("1");

				MilesPaymentDataDTO milesPaymentData = new MilesPaymentDataDTO();
				milesPaymentData.getMilesPaymentList().add(milesPayment);
				paymentInfo.setMilesPaymentData(milesPaymentData);
//			}

			if (PaymentType.CASH.equals(createEmdDetail.getPaymentType())) {
				
				PaymentDTO payment = new PaymentDTO();
				
				payment.setAmount(formatAmount);
				payment.setCurrency(createEmdDetail.getCurrency());
				payment.setPassengerIndex("1");

				CashPaymentDataDTO paymentData = new CashPaymentDataDTO();
				paymentData.getCashPaymentList().add(payment);
				paymentInfo.setCashPaymentData(paymentData);
			}

			ProfileTypeDTO profile = new ProfileTypeDTO();

			if (createEmdDetail.getMember()!=null) {
				
				profile.setName(Utils.toUpperCaseEnglish(createEmdDetail.getMember().getMemberName()));
				profile.setLastname(Utils.toUpperCaseEnglish(createEmdDetail.getMember().getMemberSurname()));
				profile.setMemberId(createEmdDetail.getMember().getMemberId());
				
				// A.G. 05082012 profile.setTitle(msc.getProfileData().getSex());
				
				if (!CommonJava.strEqualNullOrEmpty(createEmdDetail.getMember().getMemberSex())
						&& "M".equals(createEmdDetail.getMember().getMemberSex())) {
					
					profile.setTitle("MR");
					
				} else {
					
					profile.setTitle("MS");
				}
				
				profile.setEmail(createEmdDetail.getMember().getMemberPrimaryEmailAdress());
				
				if (CommonJava.strEqualNullOrEmpty(createEmdDetail.getMember().getMemberIdentityCardNo())) {
					profile.setCitizenshipNo("0");
				} else {
					profile.setCitizenshipNo(createEmdDetail.getMember().getMemberIdentityCardNo());
				}
			}

			FareComponentTypeDTO fare = new FareComponentTypeDTO();

			// INFO Sor
			// DecimalFormat dfCurr = new DecimalFormat("#.0000", symbol);
			fare.setBankSellingRate(df.format(createEmdDetail.getCurrencyRate()));// A.G. fare.setBankSellingRate("1");

			fare.setTaxesPaid(false); // common orderId - EA yeni eklendi
			fare.setFareCurrency(createEmdDetail.getCurrency());
//			TaxType[] taxType = new TaxType[1];
//			taxType[0] = new TaxType();
			// A.G. CR08052012 taxType[0].setAmount(formatTax);
			// taxType[0].setTaxName(Parameters.getString(ParameterKeys.EMDSERVICE_FARE_TAX_NAME));
//			fare.setTaxList(taxType);
			fare.setTotalAmount(formatAmount); // A.G. CR08052012 fare.setTotalAmount(formatAmountWithoutTax);
			// A.G. CR08052012 fare.setTotalTaxAmount(formatTax);
			// A.G. CR08052012 fare.setTotalTaxCurrency(msc.getCurrency());

//			HeaderType header = new HeaderType();
//			header.setNPhaseId(createEmdDetail.getnPhaseId());

			FlightTypeDTO flightType = new FlightTypeDTO();

			EmdsCreateOTARequest emdRequest = new EmdsCreateOTARequest();
			
//			emdRequest.setSignCode(signInType);
			emdRequest.setPaymentInfo(paymentInfo);
			emdRequest.setProfile(profile);
			emdRequest.setFlight(flightType);
			emdRequest.setFareComponent(fare);
			emdRequest.setNPhaseId(createEmdDetail.getnPhaseId());
			emdRequest.setEmdType(emdType);
			
			CreateEmdResult createEmdResult = CreateEMDUtility.createEMD( signcode, emdRequest, dbLog);

			if ("00".equals(createEmdResult.getResultCode())) {
				createEmdDetail.setEmdNumber(createEmdResult.getEmdNumber());
			}else {

				throw new Exception("EMD Number is null : " +createEmdResult.getResultDescription());
			}
			
		} catch (Exception e) {

			throw e;
		}
	}
	
}
