package com.eval.coronakit.service;

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

import com.eval.coronakit.dao.RolesRepository;
import com.eval.coronakit.dao.UserRepository;
import com.eval.coronakit.entity.Roles;





@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PasswordEncoder pEnc;
	
	@Autowired
	private RolesRepository rolesRepo; 
	
	@Autowired
	private UserRepository userRepo; 
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserDetails userDetails;

		Roles role = rolesRepo.findByUserName(userName);
		com.eval.coronakit.entity.User userDetail = userRepo.findByUserName(userName);
		
		if(role==null) {
			throw new UsernameNotFoundException("No Such User Found  ");
		}
		
		List<GrantedAuthority> authorities= new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role.getRole()));
		
		
		userDetails = (UserDetails) new User(
				role.getUserName(),
				userDetail.getEncodedPassword(),
				authorities);
		
		
		return userDetails;
	}

	public User save(User userInformation) {
		((com.eval.coronakit.entity.User) userInformation).setEncodedPassword(pEnc.encode(userInformation.getPassword()));
		return userRepo.save(userInformation);
	} 
}