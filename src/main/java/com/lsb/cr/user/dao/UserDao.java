package com.lsb.cr.user.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.lsb.cr.core.CrAbstractDao;
import com.lsb.cr.user.entity.User;

@Repository
public class UserDao extends CrAbstractDao {

	public Integer conutByName(String name) {
		return jdbcTemplate.queryForObject(
				"select count(*) from t_users where username = ?", Integer.class, name);
	}

	public void insertUser(User user) {
		this.jdbcTemplate.update("insert into t_users (username, password) values (?, ?)",
						user.getUsername(), user.getPassword());
	}

	public void insertAuth(User user) {
		this.jdbcTemplate.update("INSERT INTO t_user_roles (username, ROLE) VALUES (?, 'ROLE_USER');",
				user.getUsername());
	}

	public List<User> getUsers(){
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		return this.jdbcTemplate.query("select * from t_users", rowMapper);
	}
}
