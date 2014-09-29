package com.lsb.cr.channel.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsb.cr.channel.service.ChannelService;

@Controller
public class ChannelAction {
	
	@Autowired
	private ChannelService channelService;

	@RequestMapping(value = { "/channel" }, method = RequestMethod.GET)
	public String showChannelPage(Model model) {
		model.addAttribute("ChannelList", channelService.getChannelList());
		return "channel/channel";
	}
}