package com.bank.dto;

public class UserDto {

	private int id;
	private String username;
	private String password;
	private boolean authenticatred;
	
	public UserDto() {
		
	}
	
	public UserDto(int id, String username, String password, boolean authenticatred) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authenticatred = authenticatred;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAuthenticatred() {
		return authenticatred;
	}
	public void setAuthenticatred(boolean authenticatred) {
		this.authenticatred = authenticatred;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", username=" + username + ", password=" + password + ", authenticatred="
				+ authenticatred + "]";
	}
	
	
}
