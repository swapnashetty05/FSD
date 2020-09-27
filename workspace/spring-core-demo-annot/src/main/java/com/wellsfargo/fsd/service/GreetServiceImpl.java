package com.wellsfargo.fsd.service;

import org.springframework.stereotype.Service;

@Service("gsb")
public class GreetServiceImpl implements GreetService {

	public String greet(String userName) {
		
		return "Hello " + userName;
	}

}
