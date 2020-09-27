package com.wellsfargo.fsd.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("gsab")
public class GreetServiceAdvancedImpl implements GreetService {
	
	@Value("#{'${greeting}'}")
	private String greeting;

	public String greet(String userName) {
		
		return greeting + " " + userName;
	}

	public GreetServiceAdvancedImpl() {
		super();
	}

	public GreetServiceAdvancedImpl(String greeting) {
		super();
		this.greeting = greeting;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	

}
