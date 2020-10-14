package com.wellsfargo.fsd.its.service;

import java.util.Set;

import com.wellsfargo.fsd.its.exception.ITSException;
import com.wellsfargo.fsd.its.model.AttendeeModel;
import com.wellsfargo.fsd.its.model.InterviewModel;
import com.wellsfargo.fsd.its.model.UserModel;



public interface InterviewService {

	InterviewModel add(InterviewModel interview) throws ITSException;
	
	boolean deleteInterview(int interviewId) throws ITSException;
	
	InterviewModel updateStatus(Integer interviewid, String status) throws ITSException;
	
	Set<InterviewModel> getinterview(String interviewName, String interviewerName);
	
	String getInterviewCount();
	
	Set<InterviewModel> getAllInterviewDetails();
	
	Set<UserModel> showUsers(int interviewId) throws ITSException;

	String addAttendee(AttendeeModel attendee) throws ITSException;

	InterviewModel getInterviewById(int interviewId);;
}
