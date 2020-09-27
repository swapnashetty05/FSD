package com.wellsfargo.fsd.coronakit.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.coronakit.entity.LMSUser;
import com.wellsfargo.fsd.coronakit.service.UserDetailsServiceImpl;

@Controller
public class LoginController {

	
	@Autowired
	private UserDetailsServiceImpl userService;
	
	@GetMapping({"","/"})
	public String getHome() {
		return "index";
	}
	
	@GetMapping("/login")
	public String gotoLogin() {
		String view="loginPage";
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			view="redirect:/home";
		}

		return view; 
	}
	
	@RequestMapping("/header")
	public ModelAndView showHeader() {

		ModelAndView mv = new ModelAndView("header");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if ( auth.isAuthenticated()) {
			String role = new ArrayList<>(auth.getAuthorities()).get(0).getAuthority();
			
			mv.addObject("unm", auth.getName());
			mv.addObject("role", role);
		}
		return mv;
		
	}
	
	@RequestMapping("/footer")
	public ModelAndView showFooter() {

		ModelAndView mv = new ModelAndView("footer");
		
		return mv;
		
	}
	
	@GetMapping("/register")
	public ModelAndView showRegisterationForm() {
		return  new ModelAndView("registerFormPage","user",new LMSUser());
	}
	
	@PostMapping("/register")
	public ModelAndView doRegisteration(@ModelAttribute("user") LMSUser user) {
		user.setRole("USER");
		//user = userService.save(user);
		return  new ModelAndView("index","msg","User got registered! with ID#"+user.getUserId());
	}
}
