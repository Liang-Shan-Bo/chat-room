package com.lsb.cr.user.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class User {
	
	@NotNull
	@Size(max=50, min=2)
	private String username;
	
	@NotNull
	@Size(max=50, min=2)
	private String password;
	
	@NotNull
	@Size(max=50, min=2)
	private String passwordConfirm;


	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
