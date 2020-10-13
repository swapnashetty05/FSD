package com.wellsfargo.fsd.its.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AttendeeModel {

	@NotNull(message = "Attendee Id is mandatory")
	@Min(value = 1, message = "Attendee Id can not be negative or zero")
	private Integer aId;

	UserModel userModel;

	InterviewModel interviewModel;

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public InterviewModel getInterviewModel() {
		return interviewModel;
	}

	public void setInterviewModel(InterviewModel interviewModel) {
		this.interviewModel = interviewModel;
	}

	public AttendeeModel(Integer aId, UserModel userModel, InterviewModel interviewModel) {
		super();
		this.aId = aId;
		this.userModel = userModel;
		this.interviewModel = interviewModel;
	}

	public AttendeeModel() {

	}

}
