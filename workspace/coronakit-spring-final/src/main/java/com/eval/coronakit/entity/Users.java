package com.eval.coronakit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue
	private Integer userId;

	@Column(name = "unm", unique = true)
	private String userName;

	@Transient
	private String password;

	@Column(name = "pwd")
	private String encodedPassword;

	@Column(name = "role")
	private String role;
	
	@Column
	private boolean enabled;
	
	@Column
	private String email;
	
	@Column
	private String contact;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncodedPassword() {
		return encodedPassword;
	}

	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Users(Integer userId, String userName, String password, String encodedPassword, String role, boolean enabled,
			String email, String contact) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.encodedPassword = encodedPassword;
		this.role = role;
		this.enabled = enabled;
		this.email = email;
		this.contact = contact;
	}

	public Users() {
		
	}
	
	
	
}
