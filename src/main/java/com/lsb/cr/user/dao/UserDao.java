package com.lsb.cr.user.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.lsb.cr.core.CrAbstractDao;

@Repository
public class UserDao extends CrAbstractDao {

	public Integer find(String id, String pwd) {
		return jdbcTemplate.queryForObject(
				"select count(*) from t_user where id = ? and password = ?",
				Integer.class, id, pwd);
	}

	public Integer conutById(String id) {
		return jdbcTemplate.queryForObject(
				"select count(*) from t_user where id = ?", Integer.class, id);
	}
	public Integer conutByName(String name) {
		return jdbcTemplate.queryForObject(
				"select count(*) from t_user where name = ?", Integer.class, name);
	}

	public void insertUser(String id, String pwd, String name) {
		this.jdbcTemplate
				.update("insert into t_user (id, password, name, createtime) values (?, ?, ?, ?)",
						id, pwd, name, new Date());//TODO use db timestamp
	}

}
