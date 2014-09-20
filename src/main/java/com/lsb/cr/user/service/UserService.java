package com.lsb.cr.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lsb.cr.core.CrAbstractService;
import com.lsb.cr.user.dao.UserDao;

@Service
@Transactional
public class UserService extends CrAbstractService {

	@Autowired
	private UserDao userDao;
	
	public Integer find(String id, String pwd) {
		return userDao.find(id, pwd);
	}

	public Integer isExistId(String id) {
		return userDao.conutById(id);
	}
	public Integer isExistName(String name) {
		return userDao.conutByName(name);
	}

	public void regist(String id, String pwd, String name) {
		userDao.insertUser(id, pwd, name);;
	}
	
}
