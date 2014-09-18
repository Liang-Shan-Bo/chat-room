package com.lsb.cr.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lsb.cr.user.dao.UserDao;

@RestController
public class LoginAction {
	public LoginAction() {
	}

	@RequestMapping(value = "/login/{id}/{password}", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") String id,
			@PathVariable("password") String password, ModelMap modelMap)
			throws Exception {
		String loginResult;
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDao userdao = (UserDao) ac.getBean("userdao");
		if (userdao.find(id, password) == 0) {
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
		return "index";
	}
}