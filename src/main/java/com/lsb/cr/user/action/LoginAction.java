package com.lsb.cr.user.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/login")
public class LoginAction {
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView loginError() {
		ModelAndView model = new ModelAndView();
		model.addObject("error", "Invalid username and password!");
		model.setViewName("login/login");
		return model;
	}
}