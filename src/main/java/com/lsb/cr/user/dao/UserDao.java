package com.lsb.cr.user.dao;

import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Integer find(String id, String pwd) {
		return jdbcTemplate.queryForObject(
				"select count(*) from t_user where id = ? and password = ?",
				Integer.class, id, pwd);
	}

	public Integer isExistId(String id) {
		return jdbcTemplate.queryForObject(
				"select count(*) from t_user where id = ?", Integer.class, id);
	}
	public Integer isExistName(String name) {
		return jdbcTemplate.queryForObject(
				"select count(*) from t_user where name = ?", Integer.class, name);
	}

	public void regist(String id, String pwd, String name) {
		this.jdbcTemplate
				.update("insert into t_user (id, password, name, createtime) values (?, ?, ?, ?)",
						id, pwd, name, new Date());
	}

}
