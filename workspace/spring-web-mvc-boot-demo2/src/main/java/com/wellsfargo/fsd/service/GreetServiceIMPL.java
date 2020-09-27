package com.wellsfargo.fsd.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceIMPL implements GreetService {

	@Override
	public String doGreet(String userName) {
		String greeting = null;

		int h = LocalTime.now().getHour();

		if (h >= 4 && h <= 11) {
			greeting = "Good Morning";
		} else if (h >= 12 && h <= 16) {
			greeting = "Good Noon";
		} else {
			greeting = "Good Evening";
		}

		return greeting + " " + userName ;
	}

}
