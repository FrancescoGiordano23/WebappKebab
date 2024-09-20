package com.advancia.Modal;

import java.util.List;

import com.advancia.Entity.KebabEntity;

public class User {
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int value) {
		id = value;
	}

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String value) {
		username = value;
	}

	private String password;

	public String getpassword() {
		return password;
	}

	public void setPassword(String value) {
		password = value;
	}

	
	private List<KebabEntity> kebabsCreated;

	public List<KebabEntity> getKebabsCreated() {
		return kebabsCreated;
	}

	public void setKebabsCreated() {

	}
}
