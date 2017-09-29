package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@Column(name="user_id")
	@SequenceGenerator(name="user_id_seq", sequenceName="user_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id_seq")
	private int userID;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	public User(int userID, String username, String password) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + "]";
	}
	
	

}
