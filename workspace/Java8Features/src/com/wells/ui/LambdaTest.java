package com.wells.ui;

import com.wells.service.GreetService;
import com.wells.service.GreetServiceImpl;

public class LambdaTest {

	public static void main(String[] args) {
		
		GreetService gs = new GreetServiceImpl();
		System.out.println(gs.greet(" Swapna"));
		
		GreetService gs2 = (usName) -> "hoy" +usName;
		System.out.println(gs2.greet(" Swapna"));

	}

}
