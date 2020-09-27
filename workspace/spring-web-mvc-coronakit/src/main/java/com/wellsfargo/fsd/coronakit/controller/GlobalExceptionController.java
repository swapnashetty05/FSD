package com.wellsfargo.fsd.coronakit.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.coronakit.exception.CoronaException;
import com.wellsfargo.fsd.coronakit.exception.LoanException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(CoronaException.class)
	public ModelAndView handleException(CoronaException exp) {
		return new ModelAndView("errPage", "errMsg",exp.getMessage());
		
	}
}
