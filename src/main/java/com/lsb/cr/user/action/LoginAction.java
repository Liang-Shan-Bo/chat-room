package com.lsb.cr.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lsb.cr.user.service.UserService;

@Controller
public class LoginAction {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPost() {
		return "login/index";
	}
	
	@RequestMapping(value = "/login/error", method = RequestMethod.GET)
	public ModelAndView loginError() {
		ModelAndView model = new ModelAndView();
		model.addObject("error", "Invalid username and password!");
		model.setViewName("login/index");
		return model;
	}
}