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
public class RegistAction {
	
	@Autowired
	private UserService userService;
	
	public RegistAction() {
	}

	@RequestMapping(value = "/login/regist", method = RequestMethod.GET)
	public String registPost() {
		return "login/regist";
	}

	@RequestMapping(value = "/regist/{id}/{password}/{name}", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") String id,
			@PathVariable("password") String password,
			@PathVariable("name") String name, ModelMap modelMap)
			throws Exception {
		String registResult;
		
		if (userService.isExistId(id) == 1) {
			registResult = "�˺��Ѵ���";
		} else if (userService.isExistName(name) == 1){
			registResult = "�ǳ��Ѵ���";
		}else {
			userService.regist(id, password, name);
			registResult = "ע��ɹ�";
			modelMap.put("loginResult", registResult);
			return new ModelAndView("/login/index", modelMap);
		}
		modelMap.put("registResult", registResult);
		return new ModelAndView("/login/regist", modelMap);
	}
}
