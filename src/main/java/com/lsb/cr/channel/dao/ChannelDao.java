package com.lsb.cr.channel.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lsb.cr.channel.entity.Channel;
import com.lsb.cr.core.CrAbstractDao;

@Repository
public class ChannelDao extends CrAbstractDao {
	
	public List<Channel> getChannelList(){
		RowMapper<Channel> rowMapper = new BeanPropertyRowMapper<Channel>(Channel.class);
		return this.jdbcTemplate.query("select * from t_channel", rowMapper);
	}
}
