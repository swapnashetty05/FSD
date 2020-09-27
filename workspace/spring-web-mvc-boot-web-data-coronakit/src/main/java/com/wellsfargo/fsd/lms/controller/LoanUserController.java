package com.wellsfargo.fsd.lms.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exception.LoanException;
import com.wellsfargo.fsd.lms.service.LoanService;

@RequestMapping("/user")
@Controller
public class LoanUserController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping("/list")
	public ModelAndView doDisplayLoans() {
		return new ModelAndView("loanListPage","loans", loanService.getAllLoans());
	}
	
	
	@GetMapping("/search")
	public ModelAndView doSearch() {
		return new  ModelAndView("searchPage");
	}
	
	@GetMapping("/searchList")
	public ModelAndView doDisplayWithStatus(Model model, @RequestParam("status") String status) throws LoanException {
		
		
		 List<Loan> listloans = loanService.getAllLoans(status);
	        model.addAttribute("listloans", listloans);
	        model.addAttribute("status", status);
		return new ModelAndView("loanListPage","loans", loanService.getAllLoans(status));
	}
	
}
