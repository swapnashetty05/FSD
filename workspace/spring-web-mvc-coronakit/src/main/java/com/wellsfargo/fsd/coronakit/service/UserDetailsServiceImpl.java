package com.wellsfargo.fsd.coronakit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.coronakit.dao.LMSUserRepo;
import com.wellsfargo.fsd.coronakit.dao.UserRepo;
import com.wellsfargo.fsd.coronakit.entity.LMSUser;
import com.wellsfargo.fsd.coronakit.entity.Users;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PasswordEncoder pEnc;
	
	@Autowired
	private UserRepo userRepo; 
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDetails userDetails;

		Users user = userRepo.findByUserName(userName);
		
		if(user==null) {
			throw new UsernameNotFoundException("No Such User Found  ");
		}
		
		List<GrantedAuthority> authorities= new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		
		userDetails = (UserDetails) new User(
				user.getUserName(),
				user.getEncodedPassword(),
				authorities);
		
		
		return userDetails;
	}

	public Users save(Users user) {
		user.setEncodedPassword(pEnc.encode(user.getPassword()));
		return userRepo.save(user);
	} 
}
