package com.lsb.cr.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lsb.cr.user.service.UserService;

@Controller
public class LoginAction {
	
	@Autowired
	private UserService userService;
	
	public LoginAction() {
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") String id,
			@PathVariable("password") String password, ModelMap modelMap)
			throws Exception {
		String loginResult;
		
		if (userService.find(id, password) == 0) {
			loginResult = "�˺Ų�����";
		} else {
			modelMap.put("loginUser", id);
			return new ModelAndView("/login/login", modelMap);
		}
		modelMap.put("loginResult", loginResult);
		return new ModelAndView("/login/index", modelMap);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPost() {
		return "login/index";
	}
}