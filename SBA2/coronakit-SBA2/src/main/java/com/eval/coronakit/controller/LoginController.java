package com.eval.coronakit.controller;

import java.util.ArrayList;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping("/custom-login")
	public String login() {
		return "login-form";
	}

	@RequestMapping("/custom-error")
	public String error() {
		return "error-page";
	}

	@PostMapping("/validate")
	public String gotoLogin() {
		String view = "loginPage";

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			view = "redirect:/home";
		}

		return view;
	}

	@GetMapping("/login")
	public String validateLogin() {
		String view = "login-form";

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			view = "redirect:/home";
		}

		return view;
	}

	@RequestMapping("/header")
	public ModelAndView showHeader() {

		ModelAndView mv = new ModelAndView("header");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.isAuthenticated()) {
			String role = new ArrayList<>(auth.getAuthorities()).get(0).getAuthority();

			mv.addObject("unm", auth.getName());
			mv.addObject("role", role);
		}
		return mv;

	}

	@RequestMapping("/footer")
	public String getFooter() {
		return "footer";

	}
}
