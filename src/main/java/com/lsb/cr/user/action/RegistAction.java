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
public class RegistAction {
	public RegistAction() {
	}

	@RequestMapping(value = "/login/regist", method = RequestMethod.GET)
	public String registPost() {
		return "regist";
	}

	@RequestMapping(value = "/regist/{id}/{password}/{name}", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") String id,
			@PathVariable("password") String password,
			@PathVariable("name") String name, ModelMap modelMap)
			throws Exception {
		String registResult;
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserDao userdao = (UserDao) ac.getBean("userdao");
		if (userdao.isExistId(id) == 1) {
			registResult = "账号已存在";
		} else if (userdao.isExistName(name) == 1){
			registResult = "昵称已存在";
		}else {
			userdao.regist(id, password, name);
			registResult = "注册成功";
			modelMap.put("loginResult", registResult);
			return new ModelAndView("/login/index", modelMap);
		}
		modelMap.put("registResult", registResult);
		return new ModelAndView("/login/regist", modelMap);
	}
}
