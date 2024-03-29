package com.wellsfargo.fsd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wellsfargo.fsd.conf.AppConf;
import com.wellsfargo.fsd.service.GreetService;


public class GreetApp1 {

	public static void main(String[] args) {
		
//		GreetServiceImpl gs = new GreetServiceImpl();
//		System.out.println(gs.greet("swap"));

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);
		
		GreetService gs = (GreetService) context.getBean("gsb");
		System.out.println(gs.greet("swap"));
		
		GreetService gsa = (GreetService) context.getBean("gsab");
		System.out.println(gsa.greet("swap"));
		
		GreetService gse = (GreetService) context.getBean("gseb");
		System.out.println(gse.greet("swap"));
		
		System.out.println(context.getBean("today"));
	}

}
