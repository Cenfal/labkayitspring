package com.thy.loyalty.service.loyalty.entrychannel.impl;


import com.thy.loyalty.dao.base.GenericDAO;
import com.thy.loyalty.dao.entrychannel.EntryChannelDAO;
import com.thy.loyalty.service.base.impl.BaseServiceImpl;
import com.thy.loyalty.service.loyalty.entrychannel.EntryChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service(value = "entryChannelService")
public class EntryChannelServiceImpl extends BaseServiceImpl implements EntryChannelService
{
    private static final Logger LOG = LoggerFactory.getLogger(EntryChannelServiceImpl.class);

    private EntryChannelDAO entryChannelDAO;

    @Resource(name = "entryChannelDAO")
    public void setEntryChannelDAO(EntryChannelDAO entryChannelDAO) {
        this.entryChannelDAO = entryChannelDAO;
    }

    @Override
    protected GenericDAO getDAO()
    {
        return entryChannelDAO;
    }
}
