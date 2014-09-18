package com.lsb.cr.user.entity;

public class UserEntity {
	private int id;
	private String name;
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
