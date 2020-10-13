package com.wellsfargo.fsd.its.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="interview")
public class InterviewEntity {

	@Id
	@Column(name="iId")
	private Integer interviewId;
	
	@Column(name="interviewerName")
	private String interviewerName;
	
	@Column(name="interviewName")
	private String interviewName;
	
	@Column(name="usersSkills")
	private String usersSkills;
	
	@Column(name="time")
	private LocalTime time;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="interviewStatus")
	private String interviewStatus; 
	
	
	@Column(name="remarks")
	private String remarks ;

	@OneToMany(mappedBy = "interviewEntity")
    Set<AttendeeEntity> attendeeEntity;

	public Set<AttendeeEntity> getAttendeeEntity() {
		return attendeeEntity;
	}


	public void setAttendeeEntity(Set<AttendeeEntity> attendeeEntity) {
		this.attendeeEntity = attendeeEntity;
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


	public InterviewEntity(Integer interviewId, String interviewerName, String interviewName, String usersSkills,
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


	public InterviewEntity(Integer interviewId, String interviewerName, String interviewName, String usersSkills,
			LocalTime time, LocalDate date, String interviewStatus, String remarks,
			Set<AttendeeEntity> attendeeEntity) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.usersSkills = usersSkills;
		this.time = time;
		this.date = date;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
		this.attendeeEntity = attendeeEntity;
	}


	public InterviewEntity() {
		
	}

	
}
