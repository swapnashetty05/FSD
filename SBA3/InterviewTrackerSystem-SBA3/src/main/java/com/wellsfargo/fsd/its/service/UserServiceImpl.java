package com.wellsfargo.fsd.its.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wellsfargo.fsd.its.dao.UserDAO;
import com.wellsfargo.fsd.its.entity.UserEntity;
import com.wellsfargo.fsd.its.exception.ITSException;
import com.wellsfargo.fsd.its.model.UserModel;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userRepo;
	
	
	private UserEntity toEntity(UserModel model) {
		return new UserEntity(model.getUserId(), model.getFirstName(), model.getLastName(),model.getEmail(), model.getMobile());
	}
	
	private UserModel toModel(UserEntity entity) {
		return new UserModel(entity.getUserId(),entity.getFirstName(), entity.getLastName(), entity.getEmail(), entity.getMobile());
	}

	
	@Override
	@Transactional
	public UserModel add(UserModel user) throws ITSException {
        if(user!=null) {
            if(userRepo.existsById(user.getUserId())) {
                throw new ITSException("User Id already used");
            }
            
            user = toModel(userRepo.save(toEntity(user)));
        }
        return user;
	}

	@Override
	@Transactional
	public boolean deleteUser(int userId) throws ITSException {
		if(!userRepo.existsById(userId)) {
			throw new ITSException("User Not Found");
		}
		UserEntity userEntity = userRepo.findById(userId).orElse(null);
		
		userEntity.removeInterviews();
		userRepo.flush();
		userRepo.delete(userEntity);
		return true;
	}

	@Override
	public UserModel getUser(int userId) {
        UserEntity entity = userRepo.findById(userId).orElse(null);
        return entity!=null?toModel(entity):null;
	}

	@Override
	public List<UserModel> getAllUsers() {
		List<UserEntity> entities= userRepo.findAll();
		List<UserModel> models=null;
		if(entities!=null && !entities.isEmpty()) {
			models = entities.stream().map(e -> toModel(e)).collect(Collectors.toList());
		}
		return models;
	}

}
