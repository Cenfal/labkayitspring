package com.thy.loyalty.controller.entrychannel;


import com.google.common.collect.Lists;
import com.thy.loyalty.model.EntryChannel;
import com.thy.loyalty.service.loyalty.entrychannel.EntryChannelService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by gkisakol on 5/7/2017.
 */
@ManagedBean(name = "entryChannelBean")
@ViewScoped
@NoArgsConstructor
public class EntryChannelBean
{
    @Getter @Setter
    List<EntryChannel> enrtyChannelList = Lists.newArrayList();

    @Setter
    @ManagedProperty("#{entryChannelService}")
    private EntryChannelService entryChannelService;


    @PostConstruct
    public void init()
    {
        this.enrtyChannelList = this.entryChannelService.findAll(EntryChannel.class);
        System.out.println("ok");
    }
}
