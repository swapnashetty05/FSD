package com.wellsfargo.fsd.service;

public class GreetServiceAdvancedImpl implements GreetService {
	
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
