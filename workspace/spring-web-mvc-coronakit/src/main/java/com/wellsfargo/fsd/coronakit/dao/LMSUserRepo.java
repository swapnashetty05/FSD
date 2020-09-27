package com.wellsfargo.fsd.coronakit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.fsd.coronakit.entity.LMSUser;

public interface LMSUserRepo extends JpaRepository<LMSUser, Integer> {

	LMSUser findByUserName(String userName);
	boolean existsByUserName(String userName);
}
