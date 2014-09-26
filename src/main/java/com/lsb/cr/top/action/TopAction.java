package com.lsb.cr.top.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TopAction {

	@RequestMapping(value = { "/", "/top**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("test", "test");
		model.setViewName("top");
		return model;

	}
	
	@RequestMapping(value = { "/403" }, method = RequestMethod.GET)
	public ModelAndView accessDeniedPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("test", "test");
		model.setViewName("403");
		return model;

	}
	
	

}
