package com.lsb.cr.channel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lsb.cr.channel.dao.ChannelDao;
import com.lsb.cr.channel.entity.Channel;
@Service
@Transactional
public class ChannelService {
	
	@Autowired
	private ChannelDao channelDao;
	
	public List<Channel> getChannelList(){
		return channelDao.getChannelList();
	}
}
