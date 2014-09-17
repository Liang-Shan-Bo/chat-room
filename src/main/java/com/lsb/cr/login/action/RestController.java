package com.lsb.cr.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestController {
	public RestController() {
	}

	@RequestMapping(value = "/login/{user}", method = RequestMethod.GET)
	public ModelAndView myMethod(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("user") String user,
			ModelMap modelMap) throws Exception {
		modelMap.put("loginUser", user);
		return new ModelAndView("/login/login", modelMap);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String registPost() {
		return "/login";
	}
}