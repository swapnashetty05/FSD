package com.wellsfargo.fsd.its.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.its.dao.InterviewDAO;
import com.wellsfargo.fsd.its.dao.UserDAO;
import com.wellsfargo.fsd.its.entity.InterviewEntity;
import com.wellsfargo.fsd.its.entity.UserEntity;
import com.wellsfargo.fsd.its.exception.ITSException;
import com.wellsfargo.fsd.its.model.AttendeeModel;
import com.wellsfargo.fsd.its.model.InterviewModel;
import com.wellsfargo.fsd.its.model.UserModel;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	private InterviewDAO intRepo;

	@Autowired
	private UserDAO userRepo;

	
	@Override
	@Transactional
	public InterviewModel addInterview(InterviewModel interview) throws ITSException {
		if (interview != null) {
			if (intRepo.existsById(interview.getInterviewId())) {
				throw new ITSException("Interview Id already used!");
			}
			interview = toInterviewModel(intRepo.save(toInterviewEntity(interview)));
		}
		return interview;
	}

	@Override
	@Transactional
	public String addAttendee(AttendeeModel attendee) throws ITSException {
		if (attendee != null) {
			if (!userRepo.existsById(attendee.getUserId())) {
				throw new ITSException("User Not Found");
			}
			if (!intRepo.existsById(attendee.getInterviewId())) {
				throw new ITSException("Interview Id Not Found!");
			}
			InterviewModel interview = getInterviewById(attendee.getInterviewId());
			for (UserModel user : interview.getAttendee()) {
				if (user.getUserId() == attendee.getUserId()) {
					throw new ITSException("User Id already exists on Interview!");
				}
			}
			Set<UserModel> users = interview.getAttendee();
			users.add(getUserById(attendee.getUserId()));
			interview.setAttendee(users);
			intRepo.save(toInterviewEntity(interview));
			return "User added successfully to Interview";
		}
		return "Error adding User with Id: " + attendee.getUserId();
	}

	public UserModel getUserById(int userId) {
		UserEntity entity = userRepo.findById(userId).orElse(null);
		return entity != null ? toUserModel(entity) : null;
	}

	@Override
	public boolean deleteInterview(int interviewId) throws ITSException {
		if (!intRepo.existsById(interviewId)) {
			throw new ITSException("Interview Id Not Found!");
		}

		InterviewEntity interviewEntity = intRepo.findById(interviewId).orElse(null);
		interviewEntity.removeUsers();
		intRepo.flush();
		intRepo.delete(interviewEntity);
		return true;

	}

	@Override
	public InterviewModel updateStatusOfInterview(Integer interviewId, String status) throws ITSException {
		if (!intRepo.existsById(interviewId)) {
			throw new ITSException("Interview Id Not Found!");
		}
		InterviewModel interview = getInterviewById(interviewId);
		interview.setInterviewStatus(status);
		intRepo.save(toInterviewEntity(interview));
		return getInterviewModel(toInterviewEntity(interview));
	}

	@Override
	public Set<InterviewModel> searchInterviews(String interviewName, String interviewerName) {
		Set<InterviewEntity> entities = new HashSet<InterviewEntity>(
				intRepo.findByName(interviewName, interviewerName));
		Set<InterviewModel> models = null;
		if (entities != null && !entities.isEmpty()) {
			models = entities.stream().map(e -> getInterviewModel(e)).collect(Collectors.toSet());
		}
		return models;
	}

	@Override
	public String getCountOfInterviews() {
		Set<InterviewEntity> entities = new HashSet<InterviewEntity>(intRepo.findAll());
		if (entities != null)
			return "Total number of Interviews: " + entities.size();
		return "No interviews are scheduled";
	}

	@Override
	public Set<InterviewModel> getAllInterviewDetails() {

		Set<InterviewEntity> entities = new HashSet<InterviewEntity>(intRepo.findAll());
		Set<InterviewModel> models = null;
		if (entities != null && !entities.isEmpty()) {
			models = entities.stream().map(e -> getInterviewModel(e)).collect(Collectors.toSet());
		}
		return models;
	}

	private InterviewModel getInterviewModel(InterviewEntity entity) {
		return new InterviewModel(entity.getInterviewId(), entity.getInterviewerName(), entity.getInterviewName(),
				entity.getUsersSkills(), entity.getTime(), entity.getDate(), entity.getInterviewStatus(),
				entity.getRemarks());
	}

	@Override
	public Set<UserModel> showUsers(int interviewId) throws ITSException {
		if (!intRepo.existsById(interviewId)) {
			throw new ITSException("Interview Id Not Found!");
		}
		return toUserModels(intRepo.findById(interviewId).orElse(null).getAttendees());
	}

	@Override
	public InterviewModel getInterviewById(int iId) {
		InterviewEntity entity = intRepo.findById(iId).orElse(null);
		return entity != null ? toInterviewModel(entity) : null;
	}
	
	private InterviewEntity toInterviewEntity(InterviewModel intModel) {
		if (intModel.getAttendee() == null)
			return new InterviewEntity(intModel.getInterviewId(), intModel.getInterviewerName(),
					intModel.getInterviewName(), intModel.getUsersSkills(), intModel.getTime(), intModel.getDate(),
					intModel.getInterviewStatus(), intModel.getRemarks());
		else
			return new InterviewEntity(intModel.getInterviewId(), intModel.getInterviewerName(),
					intModel.getInterviewName(), intModel.getUsersSkills(), intModel.getTime(), intModel.getDate(),
					intModel.getInterviewStatus(), intModel.getRemarks(), toUserEntities(intModel.getAttendee()));
	}

	private InterviewModel toInterviewModel(InterviewEntity entity) {
		if (entity.getAttendees() == null)
			return new InterviewModel(entity.getInterviewId(), entity.getInterviewerName(), entity.getInterviewName(),
					entity.getUsersSkills(), entity.getTime(), entity.getDate(), entity.getInterviewStatus(),
					entity.getRemarks());
		else
			return new InterviewModel(entity.getInterviewId(), entity.getInterviewerName(), entity.getInterviewName(),
					entity.getUsersSkills(), entity.getTime(), entity.getDate(), entity.getInterviewStatus(),
					entity.getRemarks(), toUserModels(entity.getAttendees()));
	}

	private Set<UserEntity> toUserEntities(Set<UserModel> userModels) {
		Set<UserEntity> entities = null;
		entities = userModels.stream().map(e -> toUserEntity(e)).collect(Collectors.toSet());
		return entities;
	}

	private UserEntity toUserEntity(UserModel model) {
		return new UserEntity(model.getUserId(), model.getFirstName(), model.getLastName(), model.getEmail(),
				model.getMobile());
	}

	private Set<UserModel> toUserModels(Set<UserEntity> userEntities) {
		Set<UserModel> models = null;
		models = userEntities.stream().map(e -> toUserModel(e)).collect(Collectors.toSet());
		return models;
	}

	private UserModel toUserModel(UserEntity entity) {
		return new UserModel(entity.getUserId(), entity.getFirstName(), entity.getLastName(), entity.getEmail(),
				entity.getMobile());
	}

}
