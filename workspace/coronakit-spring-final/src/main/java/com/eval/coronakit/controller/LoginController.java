package com.eval.coronakit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eval.coronakit.service.UserDetailsServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private UserDetailsServiceImpl userService;
	
	@RequestMapping("/custom-login")
	public String login() {
		return "login-form";
	}
	
	@RequestMapping("/custom-error")
	public String error() {
		return "error-page";
	}
	
	@RequestMapping(value= "/validate",method=RequestMethod.POST)
	//@GetMapping("/validate")
	public String gotoLogin() {
		String view="login-form";
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
		//if ( auth.isAuthenticated()) {
			view="redirect:/home";
		}

		return view; 
	}
	/*
	@RequestMapping(value= "/validate",method=RequestMethod.POST)
	public String gotoLogin() {
		String view="main-menu";
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			view="redirect:/home";
		}

		return view; 
	}
	*/
}
