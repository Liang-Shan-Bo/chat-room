package com.lsb.cr.channel.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsb.cr.channel.service.ChannelService;
import com.lsb.cr.core.CrConstants;

@Secured(CrConstants.ROLE.ROLE_USER)
@Controller
public class EnterRoomAction {
	
	@Autowired
	private ChannelService channelService;

	@RequestMapping(value = { "/room/{channelId}", }, method = RequestMethod.GET)
	public String showLoginPage(Model model,@PathVariable("channelId") int channelId) {
		model.addAttribute("ChannelName", channelService.getChannelName(channelId));
		return "chatroom/room";
	}
}