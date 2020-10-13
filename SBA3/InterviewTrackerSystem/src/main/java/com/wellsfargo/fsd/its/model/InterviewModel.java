package com.wellsfargo.fsd.its.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class InterviewModel {

	@NotNull(message = "interview Id is mandatory")
	@Min(value = 1, message = "interview Id can not be negative or zero")
	private Integer interviewId;

	@NotNull(message = "interviewerName is mandatory")
	@NotBlank(message = "interviewerName is mandatory")
	@Size(min = 3, max = 20, message = "interviewerName is expected to be 3 to 20 chars in length")
	private String interviewerName;

	@NotNull(message = "interviewName is mandatory")
	@NotBlank(message = "interviewName is mandatory")
	@Size(min = 3, max = 20, message = "interviewName is expected to be 3 to 20 chars in length")
	private String interviewName;

	@NotNull(message = "usersSkills is mandatory")
	@NotBlank(message = "usersSkills is mandatory")
	@Size(min = 3, max = 20, message = "usersSkills is expected to be 3 to 20 chars in length")
	private String usersSkills;

	@NotNull(message = "Interview Time is mandatory")
	@PastOrPresent(message = "Interview Time is expected to be past or present time")
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalTime time;

	@NotNull(message = "Interview Date is mandatory")
	@PastOrPresent(message = "Interview Date is expected to be past or present date")
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate date;

	@NotNull(message = "interviewStatus is mandatory")
	@NotBlank(message = "interviewStatus is mandatory")
	@Size(min = 3, max = 20, message = "interviewStatus is expected to be 3 to 20 chars in length")
	private String interviewStatus;

	@NotNull(message = "remarks is mandatory")
	@NotBlank(message = "remarks is mandatory")
	@Size(min = 3, max = 20, message = "remarks is expected to be 3 to 20 chars in length")
	private String remarks;

	Set<AttendeeModel> attendeeModel;

	public Set<AttendeeModel> getAttendeeModel() {
		return attendeeModel;
	}

	public void setAttendeeModel(Set<AttendeeModel> attendeeModel) {
		this.attendeeModel = attendeeModel;
	}

	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getInterviewName() {
		return interviewName;
	}

	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}

	public String getUsersSkills() {
		return usersSkills;
	}

	public void setUsersSkills(String usersSkills) {
		this.usersSkills = usersSkills;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public InterviewModel(Integer interviewId, String interviewerName, String interviewName, String usersSkills,
			LocalTime time, LocalDate date, String interviewStatus, String remarks) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.usersSkills = usersSkills;
		this.time = time;
		this.date = date;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
	}

	public InterviewModel(Integer interviewId, String interviewerName, String interviewName, String usersSkills,
			LocalTime time, LocalDate date, String interviewStatus, String remarks, Set<AttendeeModel> attendeeModel) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.usersSkills = usersSkills;
		this.time = time;
		this.date = date;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
		this.attendeeModel = attendeeModel;
	}

	public InterviewModel() {

	}

}
