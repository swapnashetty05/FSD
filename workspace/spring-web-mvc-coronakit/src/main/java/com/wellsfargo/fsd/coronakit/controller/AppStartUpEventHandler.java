package com.wellsfargo.fsd.coronakit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.wellsfargo.fsd.coronakit.dao.LMSUserRepo;
import com.wellsfargo.fsd.coronakit.dao.UserRepo;
import com.wellsfargo.fsd.coronakit.entity.LMSUser;
import com.wellsfargo.fsd.coronakit.entity.Users;

@Component
public class AppStartUpEventHandler {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder penc;
	
	@EventListener
	public void appReady(ApplicationReadyEvent event) {

		Users user = userRepo.findByUserName("admin");

		if (user == null) {
			user = new Users();
			user.setUserName("admin");
			user.setEncodedPassword(penc.encode("admin"));
			user.setRole("ADMIN");
			userRepo.save(user);
		}

		Users firstUser = userRepo.findByUserName("First");

		if (firstUser == null) {
			firstUser = new Users();
			firstUser.setUserName("First");
			firstUser.setEncodedPassword(penc.encode("abc"));
			firstUser.setRole("USER");
			userRepo.save(firstUser);
		}

		Users secondUser = userRepo.findByUserName("Second");

		if (secondUser == null) {
			secondUser = new Users();
			secondUser.setUserName("Second");
			secondUser.setEncodedPassword(penc.encode("abc"));
			secondUser.setRole("USER");
			userRepo.save(secondUser);
		}
		
	}

}
