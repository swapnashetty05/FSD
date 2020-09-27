package com.eval.coronakit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eval.coronakit.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	
	User findByUserName(String userName);
	boolean existsByUserName(String userName);
	
	 @Query("SELECT u FROM User u WHERE u.username = :username")
	    public User getUserByUsername(@Param("username") String username);
	
}
