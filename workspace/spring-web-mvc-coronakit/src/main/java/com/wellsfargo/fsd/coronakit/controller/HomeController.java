package com.wellsfargo.fsd.coronakit.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.coronakit.service.UserDetailsServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private UserDetailsServiceImpl userService;
	
	@RequestMapping("/")
	public String index() {
		return  "index";
		
	}
	
	@RequestMapping("/home")
		public ModelAndView showHome() {

			ModelAndView mv = new ModelAndView("main-menu");
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if ( auth.isAuthenticated()) {
				String role = new ArrayList<>(auth.getAuthorities()).get(0).getAuthority();
				
				mv.addObject("unm", auth.getName());
				mv.addObject("role", role);
			}
			return mv;
			
		}
	
	
	
	
}
