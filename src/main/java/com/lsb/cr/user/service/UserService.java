package com.lsb.cr.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.lsb.cr.core.CrAbstractService;
import com.lsb.cr.user.dao.UserDao;
import com.lsb.cr.user.entity.User;

@Service
@Transactional
public class UserService extends CrAbstractService {

	@Autowired
	private UserDao userDao;
	
	public void validate(User user, Errors errors) {
		String username = user.getUsername().trim();
		String password = user.getPassword().trim();
		String passwordConfirm = user.getPasswordConfirm().trim();
		
		if ("".equals(username)) {
			errors.rejectValue("name", "error.required");
		}else if(this.isExistName(username)){
			errors.rejectValue("name", "error.existed");
		}
		
		
		if ("".equals(password)) {
			errors.rejectValue("password", "error.required");
		}
		
		if ("".equals(passwordConfirm)){
			errors.rejectValue("passwordConfirm", "error.required");
		}else if(!password.equals(passwordConfirm)){
			errors.rejectValue("passwordConfirm", "error.password.different");
		}
	}
	

	public boolean isExistName(String name) {
		return userDao.conutByName(name) != 0;
	}

	public void regist(User user) {
		userDao.insertUser(user);
		userDao.insertAuth(user);
	}
	
}
