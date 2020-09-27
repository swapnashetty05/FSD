package com.wellsfargo.fsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gseb")
public class GreetServiceEnhancedImpl implements GreetService {
	
	@Autowired
	private GreetingProvider gp;

	public String greet(String userName) {
		
		return gp.getGreeting() + " " + userName;
	}

	
	

}
