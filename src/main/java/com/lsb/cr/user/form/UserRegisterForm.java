package com.lsb.cr.user.form;

import com.lsb.cr.user.entity.User;

public class UserRegisterForm extends User {

	private String passwordConfirm;

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
}
