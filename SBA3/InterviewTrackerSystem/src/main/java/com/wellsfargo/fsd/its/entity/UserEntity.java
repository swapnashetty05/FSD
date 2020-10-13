package com.wellsfargo.fsd.its.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {

	@Id
	@Column(name="uId")
	private Integer userId ;
	
	@Column(name="firstName")
	private String firstName; 
	
	@Column(name="lastName")
	private String lastName; 
	
	@Column(name="email")
	private Integer email; 
	
	@Column(name="mobile")
	private Integer mobile ;
	
	@OneToMany(mappedBy = "userEntity")
    Set<AttendeeEntity> attendeeEntity;
	
	

	public Set<AttendeeEntity> getAttendeeEntity() {
		return attendeeEntity;
	}

	public void setAttendeeEntity(Set<AttendeeEntity> attendeeEntity) {
		this.attendeeEntity = attendeeEntity;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getEmail() {
		return email;
	}

	public void setEmail(Integer email) {
		this.email = email;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public UserEntity(Integer userId, String firstName, String lastName, Integer email, Integer mobile) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}
	
	

	public UserEntity(Integer userId, String firstName, String lastName, Integer email, Integer mobile,
			Set<AttendeeEntity> attendeeEntity) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.attendeeEntity = attendeeEntity;
	}

	public UserEntity() {
		
	}
	
	

}
