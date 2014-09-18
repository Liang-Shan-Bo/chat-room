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

	@RequestMapping(value = "/login/{user}", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("user") String user,
			ModelMap modelMap) throws Exception {
		int rowCount;
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDao userdao = (UserDao) ac.getBean("userdao");
		rowCount = userdao.find(user);
		if (rowCount == 0) {
			modelMap.put("rowCount", "²»´æÔÚ");
			return new ModelAndView("/login/index", modelMap);
		} else {
			modelMap.put("loginUser", user);
			return new ModelAndView("/login/login", modelMap);
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String registPost() {
		return "index";
	}
}