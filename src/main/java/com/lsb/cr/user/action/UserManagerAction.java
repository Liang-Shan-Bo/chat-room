package com.lsb.cr.user.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lsb.cr.user.entity.User;
import com.lsb.cr.user.service.UserService;

@Secured("ROLE_ADMIN")
@Controller
public class UserManagerAction {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="users", method=RequestMethod.GET)
	public ModelAndView showAllUsers(){
		ModelAndView modelAndView = new ModelAndView("users/users");
		List<User> users = userService.getALLUsers();
		modelAndView.addObject("users", users);
		return modelAndView;
		
	}
}
