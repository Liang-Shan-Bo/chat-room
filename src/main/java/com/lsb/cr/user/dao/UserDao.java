package com.lsb.cr.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lsb.cr.core.CrAbstractDao;
import com.lsb.cr.user.entity.User;
import com.lsb.cr.util.SqlStringCreator;

@Repository
public class UserDao extends CrAbstractDao<User> {

	/*public Integer conutByName(String name) {
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
	}*/
	public void insertAuth(User user) {
		this.jdbcTemplate.update("INSERT INTO t_user_roles (username, ROLE) VALUES (?, 'ROLE_USER');",
				user.getUsername());
	}
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from t_users", new BeanPropertyRowMapper(User.class));
	}

	@Override
	public User getById(User entity) {
		// TODO Auto-generated method stub
		String key = entity.getUsername();
		return (User)jdbcTemplate.queryForObject("select * from t_users where username=?",new BeanPropertyRowMapper(User.class),key);
	}

	@Override
	public int addNew(User entity) {
		// TODO Auto-generated method stub
		List<Object> values = new ArrayList<Object>();
		String sql = SqlStringCreator.createInsert(entity, "t_users", values);
		return jdbcTemplate.update(sql,values);
	}

	@Override
	public int deleteById(User entity) {
		// TODO Auto-generated method stub
		String key = entity.getUsername();
		return jdbcTemplate.update("delete from t_users where username=?",key);
	}

	@Override
	public int updateById(User entity) {
		// TODO Auto-generated method stub
		List values = new ArrayList<Object>();
		String sql = SqlStringCreator.createUpdate(entity, "t_users", "username", values);
		return jdbcTemplate.update(sql,values);
	}

	@Override
	public Integer getCount(User entity) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(*) from t_users",Integer.class);
	}

	

	
}
