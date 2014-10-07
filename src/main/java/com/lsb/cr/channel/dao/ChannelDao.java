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

	@Override
	public Integer getCount(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		RowMapper<Channel> rowMapper = new BeanPropertyRowMapper<Channel>(Channel.class);
		return this.jdbcTemplate.query("select * from t_channel", rowMapper);
	}

	@Override
	public Object getById(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addNew(Object entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Object entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(Object entity) {
		// TODO Auto-generated method stub
		return 0;
	}
}
