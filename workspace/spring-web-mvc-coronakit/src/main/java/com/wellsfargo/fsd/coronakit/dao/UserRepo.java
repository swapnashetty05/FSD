package com.wellsfargo.fsd.coronakit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.fsd.coronakit.entity.LMSUser;
import com.wellsfargo.fsd.coronakit.entity.Users;

public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByUserName(String userName);
	boolean existsByUserName(String userName);
}
