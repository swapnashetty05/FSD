package com.wellsfargo.fsd.its.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attendee")
public class AttendeeEntity {

	@Id
	@Column(name="aId")
	private Integer aId;
 
    @ManyToOne
    @JoinColumn(name = "uId")
    UserEntity userEntity;
 
    @ManyToOne
    @JoinColumn(name = "iId")
    InterviewEntity interviewEntity;

    
    
	public Integer getaId() {
		return aId;
	}



	public void setaId(Integer aId) {
		this.aId = aId;
	}



	public UserEntity getUserEntity() {
		return userEntity;
	}



	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}



	public InterviewEntity getInterviewEntity() {
		return interviewEntity;
	}



	public void setInterviewEntity(InterviewEntity interviewEntity) {
		this.interviewEntity = interviewEntity;
	}



	public AttendeeEntity(Integer aId, UserEntity userEntity, InterviewEntity interviewEntity) {
		super();
		this.aId = aId;
		this.userEntity = userEntity;
		this.interviewEntity = interviewEntity;
	}



	public AttendeeEntity() {
		
	}
	

	
}
