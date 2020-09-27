package com.wellsfargo.fsd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.wellsfargo.fsd.service.GreetService;
import com.wellsfargo.fsd.service.GreetServiceAdvancedImpl;


public class GreetApp2 {

	public static void main(String[] args) {
		

		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		
		GreetService gs = (GreetService) context.getBean("gsab");
		System.out.println(gs.greet("swap"));
		
		((GreetServiceAdvancedImpl) gs).setGreeting("hello  ");
		System.out.println(gs.greet("swap"));
		
		gs = (GreetService) context.getBean("gsab");
		System.out.println(gs.greet("swap"));
	}

}