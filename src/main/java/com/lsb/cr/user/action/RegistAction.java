package com.lsb.cr.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsb.cr.user.entity.User;
import com.lsb.cr.user.service.UserService;

@Controller
public class RegistAction {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier("org.springframework.security.authenticationManager")
    protected AuthenticationManager authenticationManager;
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registPost(@ModelAttribute("registUser") User user, BindingResult result, Model model) {
		model.addAttribute("registUser", user);
		return "login/regist";
	}

	@RequestMapping(value = "/doRegist", method = RequestMethod.POST)
	public String doRegist(@ModelAttribute("registUser") @Valid User user, 
			BindingResult result, HttpServletRequest request, Model model)
			throws Exception {
		
		userService.validate(user, result);
		
		
		if(result.hasErrors() ){
			model.addAttribute("registerUser", user);
			return "login/regist";
		}
		
		userService.regist(user);
		
		//do login
		this.authenticateUserAndSetSession(user, request);
		
		return "redirect:/top";
		
	}
	
	private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
		
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

		// generate session if one doesn't exist
		request.getSession();

		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser = authenticationManager
				.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}
}
