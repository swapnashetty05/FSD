package com.wellsfargo.swapmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SwapController {

	@RequestMapping(value = {"","/","/page"},method= RequestMethod.GET)
	public String getPage() {
		return "page";
	}
}
