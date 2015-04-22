package com.lsb.cr.channel.action;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsb.cr.core.CrConstants;

@Secured(CrConstants.ROLE.ROLE_USER)
@Controller
public class RoomAction {

	@RequestMapping(value = { "/room/{channelName}", }, method = RequestMethod.GET)
	public String showLoginPage(Model model,@PathVariable("channelName") String channelName) {
		model.addAttribute("ChannelName", channelName);
		return "channel/room";
	}
}