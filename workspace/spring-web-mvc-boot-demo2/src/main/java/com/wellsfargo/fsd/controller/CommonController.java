package com.wellsfargo.fsd.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.service.GreetService;

@Controller
public class CommonController {

	@Autowired
	private GreetService greetService;
	
	@GetMapping({"","/","/home"})
	public String defaultAction() {
		return "home";
	}
	
	@GetMapping("/greet")
	public ModelAndView acceptUser(@RequestParam("userName") String userName) {
		return new ModelAndView("home","msg",greetService.doGreet(userName) );
	}
	
	@GetMapping({"/Page*"})
	public String defaultBootStrapAction() {
		return "home";
	}
	
	@RequestMapping("/header") //allows get,post and all other http methods
	public ModelAndView headerAction() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("header");
		mv.addObject("title", "My SpringBoot MVC App");
		mv.addObject("today",LocalDateTime.now());
		
		return mv;
	}
}
