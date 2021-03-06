package com.lsb.cr.user.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.lsb.cr.core.CrAbstractService;
import com.lsb.cr.user.dao.UserDao;
import com.lsb.cr.user.entity.User;
import com.lsb.cr.user.form.UserRegisterForm;

@Service
@Transactional
public class UserService extends CrAbstractService {

	@Autowired
	private UserDao userDao;
	
	public void validate(UserRegisterForm user, Errors errors) {
		String username = user.getUsername().trim();
		String password = user.getPassword().trim();
		String passwordConfirm = user.getPasswordConfirm().trim();
		
		if ("".equals(username)) {
			errors.rejectValue("username", "error.required");
		}else if(this.isExistName(username)){
			errors.rejectValue("username", "error.existed");
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
		User u = new User();
		BeanUtils.copyProperties(user, u);
		userDao.insertUser(u);
		userDao.insertAuth(u);
	}
	
	public List<User> getALLUsers(){
		return userDao.getUsers();
	}
	
	
}
