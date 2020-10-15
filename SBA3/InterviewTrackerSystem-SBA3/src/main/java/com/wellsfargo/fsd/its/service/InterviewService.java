package com.wellsfargo.fsd.its.service;

import java.util.Set;
import com.wellsfargo.fsd.its.exception.ITSException;
import com.wellsfargo.fsd.its.model.AttendeeModel;
import com.wellsfargo.fsd.its.model.InterviewModel;
import com.wellsfargo.fsd.its.model.UserModel;

public interface InterviewService {

	InterviewModel addInterview(InterviewModel interview) throws ITSException;

	Set<InterviewModel> getAllInterviewDetails();

	Set<UserModel> showUsers(int interviewId) throws ITSException;

	String addAttendee(AttendeeModel attendee) throws ITSException;

	InterviewModel getInterviewById(int interviewId);

	boolean deleteInterview(int interviewId) throws ITSException;

	InterviewModel updateStatusOfInterview(Integer interviewid, String status) throws ITSException;

	Set<InterviewModel> searchInterviews(String interviewName, String interviewerName);

	String getCountOfInterviews();
}
