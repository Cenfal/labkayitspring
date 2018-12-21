package com.thy.loyalty.ms.membership.dto;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

import com.thy.loyalty.ms.utility.dto.MethodResult;

@XmlRootElement(name="GetMemberExchageMileInfoResult")
public class GetMemberExchageMileInfoResult extends MethodResult {
	
	private static final String _reqMileToUpgradeKey = "D_OUT_REQ_MILES_UPGRADE_CARD";
	private static final String _reqMileToRenewalKey = "D_OUT_REQ_MILES_RENEW_CARD";
	private static final String _maxExchangableMilesKey = "D_OUT_MAX_EXCHANGABLE_MILES";
	private static final String _alreadyExchangedMilesKey = "D_OUT_ALREADY_EXCHANGED_MILES";
	private static final String _totalMileKey = "D_OUT_TOTAL_MILES";	
	
	
	private String reqMileToUpgrade;
	private String reqMileToRenewal;
	private String maxExchangableMiles;
	private String alreadyExchangedMiles;
	private String totalMile;	
	
	public String getReqMileToUpgrade() {
		return reqMileToUpgrade;
	}

	public void setReqMileToUpgrade(String reqMileToUpgrade) {
		this.reqMileToUpgrade = reqMileToUpgrade;
	}

	public String getReqMileToRenewal() {
		return reqMileToRenewal;
	}

	public void setReqMileToRenewal(String reqMileToRenewal) {
		this.reqMileToRenewal = reqMileToRenewal;
	}

	public String getMaxExchangableMiles() {
		return maxExchangableMiles;
	}

	public void setMaxExchangableMiles(String maxExchangableMiles) {
		this.maxExchangableMiles = maxExchangableMiles;
	}

	public String getAlreadyExchangedMiles() {
		return alreadyExchangedMiles;
	}

	public void setAlreadyExchangedMiles(String alreadyExchangedMiles) {
		this.alreadyExchangedMiles = alreadyExchangedMiles;
	}
	
	public String getTotalMile() {
		return totalMile;
	}

	public void setTotalMile(String totalMile) {
		this.totalMile = totalMile;
	}

	public void copyValuesFromGetMemberDetailsListResponse(GetMemberDetailsListResponse detailsList)
	{
		
		final ArrayList<MSKeyValuePair> msKeyValuePairs =   detailsList.getMemberDetailsList().getMemberDataKVPair();	
		
		this.reqMileToUpgrade = findMSKeyValueForAKey(msKeyValuePairs, _reqMileToUpgradeKey);
		this.reqMileToRenewal = findMSKeyValueForAKey(msKeyValuePairs, _reqMileToRenewalKey);
		this.maxExchangableMiles = findMSKeyValueForAKey(msKeyValuePairs, _maxExchangableMilesKey);
		this.alreadyExchangedMiles = findMSKeyValueForAKey(msKeyValuePairs, _alreadyExchangedMilesKey);
		this.totalMile = findMSKeyValueForAKey(msKeyValuePairs, _totalMileKey);		
		
		setResultCode(detailsList.getErrorCode());
		setResultDescription(detailsList.getErrorDescription());
	}	
	
	public String findMSKeyValueForAKey(
			ArrayList<MSKeyValuePair> msKeyValuePairs, String key) {

		if (msKeyValuePairs.size() > 0) {
			for (int i = 0; i < msKeyValuePairs.size(); i++) {
				if (msKeyValuePairs.get(i).getKey().equals(key)) {
					return msKeyValuePairs.get(i).getValue();
				}
			}
		}

		return "NF";

	}
	
}

