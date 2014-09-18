package com.lsb.cr.user.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Integer find(String id) {
		return jdbcTemplate.queryForObject(
				"select count(*) from t_user where id =" + id, Integer.class);
	}
}
