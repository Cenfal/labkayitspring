package com.thy.loyalty.loyaltyservices.common.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.thy.loyalty.loyaltyservices.common.service.IRefreshApplicationCacheService;
import com.thy.loyalty.ms.config.DataCache;

@Service
public class RefreshApplicationCacheImpl implements
		IRefreshApplicationCacheService {
	private static Log logger = LogFactory
			.getLog(RefreshApplicationCacheImpl.class);

	@Override
	public String refreshApplicationDataCache(String user, String pass) {
		String result = "";

		logger.debug("RefreshApplicationCacheImpl.refreshApplicationDataCache called with user : "
				+ user);

		result = DataCache.reLoad(user, pass);

		logger.debug("RefreshApplicationCacheImpl.refreshApplicationDataCache returned value : "
				+ result);

		return result;
	}

}
