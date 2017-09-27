package com.ex.model;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * Auto-generated
	 */
	private static final long serialVersionUID = 1944865744792695214L;
	
	private int id;
	private String username;

	public User() {
		super();
	}

	public User(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}

}
