package com.reimburse.pojos;

public class User {
	
	//instance variables
	private int userId;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String pwd;
	private byte isManager; //0 is an employee, 1 is manager
	
	//constructors
	public User() {
	}
	
	public User(int userId, String firstname, String lastname, String username, String email, String pwd,
			byte isManager) {
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.pwd = pwd;
		this.isManager = isManager;
	}
	
	//getters and setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public byte getIsManager() {
		return isManager;
	}
	public void setIsManager(byte isManager) {
		this.isManager = isManager;
	}
	
	//new toString method for easy reading of internals
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", email=" + email + ", pwd=" + pwd + ", isManager=" + isManager + "]";
	}
	
	@Override
	public boolean equals(Object obj){
		User user = (User) obj;
		if(this.userId == user.getUserId() &&
				this.firstname.equals(user.getFirstname()) &&
				this.lastname.equals(user.getLastname()) &&
				this.username.equals(user.getUserId()) &&
				this.pwd.equals(user.getPwd()) &&
				this.isManager == user.getIsManager()){
			return true;
		}
		return false;
	}
}
