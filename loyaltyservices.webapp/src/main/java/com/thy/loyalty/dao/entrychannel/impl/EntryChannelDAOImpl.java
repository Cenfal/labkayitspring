package com.thy.loyalty.dao.entrychannel.impl;

import com.thy.loyalty.dao.base.impl.GenericDAOImpl;
import com.thy.loyalty.dao.entrychannel.EntryChannelDAO;
import org.springframework.stereotype.Repository;

/**
 * Created by gokmenkisakol on 14.06.2016.
 */
@Repository(value = "entryChannelDAO")
public class EntryChannelDAOImpl extends GenericDAOImpl implements EntryChannelDAO
{

/*    @Override
    public EnrtyChannel login(Long id)
    {
        EnrtyChannel users = null;
        try
        {
            Criteria criteria = getSession().createCriteria(EnrtyChannel.class);
            criteria.add(Restrictions.eq("id", id));
            return (EnrtyChannel)criteria.uniqueResult();
        }
        catch (Exception e)
        {
            LOG.error("CheckUser Method Failed " + e);
        }
        return users;
    }*/
}