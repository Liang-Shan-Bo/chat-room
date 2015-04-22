package com.lsb.cr.top.action;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TopAction {

	@RequestMapping(value = { "/", "/top**", "/room/top" }, method = RequestMethod.GET)
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
	
	@RequestMapping(value = {"/showSM"}, method = RequestMethod.GET)
	public String showSM(){
		return "grid/sortm";
	}
	
	@ResponseBody
	@RequestMapping(value = { "/g/sortm.json" }, method = RequestMethod.GET)
	public String sortm() {
		String path = this.getClass().getResource("").getPath() + "sortm.json";
		return getJsonData(path.substring(1));
	}
	
	@RequestMapping(value = {"/tree"}, method = RequestMethod.GET)
	public String showTree(){
		return "grid/tree";
	}
	
	@ResponseBody
	@RequestMapping(value = { "/g/tree1.json" }, method = RequestMethod.GET)
	public String tree() {
		String path = this.getClass().getResource("").getPath() + "tree1.json";
		return getJsonData(path.substring(1));
	}


	private String getJsonData(String path) {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(path));
			return new String(encoded, StandardCharsets.UTF_8);
		} catch (IOException e) {
			//ignore
		}
		return null;
	}

}
