package com.lsb.cr.channel;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoomAction {

	@RequestMapping(value = { "/room" }, method = RequestMethod.GET)
	public String showLoginPage(Principal principal) {
		return "channel/room";
	}
}