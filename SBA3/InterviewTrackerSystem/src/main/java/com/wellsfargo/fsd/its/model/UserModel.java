package com.wellsfargo.fsd.its.model;

import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {

	@NotNull(message = "User Id is mandatory")
	@Min(value = 1, message = "User Id can not be negative or zero")
	private Integer userId;

	@NotNull(message = "firstName is mandatory")
	@NotBlank(message = "firstName is mandatory")
	@Size(min = 3, max = 20, message = "firstName is expected to be 3 to 20 chars in length")
	private String firstName;

	@NotNull(message = "lastName is mandatory")
	@NotBlank(message = "lastName is mandatory")
	@Size(min = 3, max = 20, message = "lastName is expected to be 3 to 20 chars in length")
	private String lastName;

	@NotNull(message = "email is mandatory")
	@NotBlank(message = "email is mandatory")
	@Size(min = 3, max = 20, message = "email is expected to be 3 to 20 chars in length")
	private String email;

	@NotNull(message = "mobile is mandatory")
	@Min(value = 1, message = "mobile can not be negative or zero")
	private Integer mobile;

	Set<AttendeeModel> attendeeModel;

	public Set<AttendeeModel> getAttendeeModel() {
		return attendeeModel;
	}

	public void setAttendeeModel(Set<AttendeeModel> attendeeModel) {
		this.attendeeModel = attendeeModel;
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

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public UserModel(Integer userId, String firstName, String lastName, String email, Integer mobile) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}

	public UserModel(Integer userId, String firstName, String lastName, String email, Integer mobile,
			Set<AttendeeModel> attendeeModel) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.attendeeModel = attendeeModel;
	}

	public UserModel() {

	}

}
