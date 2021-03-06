package com.wellsfargo.fsd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wellsfargo.fsd.lms.dao.LMSUserRepo;
import com.wellsfargo.fsd.lms.entity.LMSUser;

@Component
public class AppStartUpEventHandler {

	@Autowired
	private LMSUserRepo repo;
	
	@Autowired
	private PasswordEncoder penc;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {

		LMSUser user = repo.findByUserName("admin");
		
		if(user==null) {
			user = new LMSUser();
			user.setUserName("admin");
			user.setEncodedPassword(penc.encode("admin"));
			user.setRole("ADMIN");
			repo.save(user);
		}
	}

}
