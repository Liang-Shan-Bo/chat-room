package com.lsb.cr.user.action;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/login")
public class LoginAction {
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String showLoginPage(Principal principal) {
		if (principal != null) {
			return "redirect:/top";
		}
		return "login/login";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView loginError(Principal principal) {
		ModelAndView model = new ModelAndView();
		if (principal != null) {
			return new ModelAndView("redirect:/top");
		}
		model.addObject("error", "true");
		model.setViewName("login/login");
		return model;
	}
}