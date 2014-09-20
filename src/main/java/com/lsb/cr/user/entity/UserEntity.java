package com.lsb.cr.user.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserEntity {
	
	@NotNull
	@Size(max=50, min=2)
	private int id;
	
	@NotNull
	@Size(max=50, min=2)
	private String name;
	
	@NotNull
	@Size(max=50, min=2)
	private String pwd;

	public UserEntity() {
	}

	public UserEntity(int id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	public UserEntity(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
