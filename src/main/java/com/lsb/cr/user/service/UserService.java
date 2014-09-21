package com.lsb.cr.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lsb.cr.core.CrAbstractService;
import com.lsb.cr.user.dao.UserDao;
import com.lsb.cr.user.entity.UserEntity;

@Service
@Transactional
public class UserService extends CrAbstractService {

	@Autowired
	private UserDao userDao;
	
	public boolean find(UserEntity userEntity) {
		return userDao.find(String.valueOf(userEntity.getId()), userEntity.getPwd()) != 0;
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
