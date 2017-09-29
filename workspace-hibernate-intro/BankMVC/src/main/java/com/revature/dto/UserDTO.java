package com.revature.dto;

public class UserDTO {

	private int ID;
	private String username;
	private String password;
	private boolean authenticated;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(int iD, String username, String password, boolean authenticated) {
		super();
		ID = iD;
		this.username = username;
		this.password = password;
		this.authenticated = authenticated;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
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
	
	public boolean isAuthenticated() {
		return authenticated;
	}
	
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}



}
