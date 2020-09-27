package com.wellsfargo.fsd.service;

public class GreetServiceEnhancedImpl implements GreetService {
	
	private GreetingProvider gp;

	public String greet(String userName) {
		
		return gp.getGreeting() + " " + userName;
	}

	public GreetServiceEnhancedImpl(GreetingProvider gp) {
		super();
		this.gp = gp;
	}

	public GreetServiceEnhancedImpl() {
		super();
	}

	public GreetingProvider getGp() {
		return gp;
	}

	public void setGp(GreetingProvider gp) {
		this.gp = gp;
	}
	

}
