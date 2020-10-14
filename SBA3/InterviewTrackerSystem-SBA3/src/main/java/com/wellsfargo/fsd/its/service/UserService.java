package com.wellsfargo.fsd.its.service;

import java.util.List;

import com.wellsfargo.fsd.its.exception.ITSException;
import com.wellsfargo.fsd.its.model.UserModel;

public interface UserService {

	UserModel add(UserModel user) throws ITSException;
	
	boolean deleteUser(int userId) throws ITSException;
	
	UserModel getUser(int userId);
	
	List<UserModel> getAllUsers();

}
