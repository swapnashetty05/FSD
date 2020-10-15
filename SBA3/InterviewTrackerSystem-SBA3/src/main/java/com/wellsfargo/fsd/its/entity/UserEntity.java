package com.wellsfargo.fsd.its.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable, Comparable<UserEntity> {

	@Id
	@Column(name = "uId")
	private Integer userId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "attendees", fetch = FetchType.LAZY)
	private Set<InterviewEntity> interviews = new HashSet<>();

	public UserEntity() {

	}

	public UserEntity(Integer userId, String firstName, String lastName, String email, String mobile) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}

	public UserEntity(Integer userId, String firstName, String lastName, String email, String mobile,
			Set<InterviewEntity> interviews) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.interviews = interviews;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Set<InterviewEntity> getInterviews() {
		return interviews;
	}

	public void setInterviews(Set<InterviewEntity> interviews) {
		this.interviews = interviews;
	}

	public void removeInterviews() {
		for (InterviewEntity interview : new HashSet<>(this.interviews)) {
			this.interviews.remove(interview);
			interview.getAttendees().remove(this);
		}
	}

	@Override
	public int compareTo(UserEntity o) {

		return 0;
	}

}
