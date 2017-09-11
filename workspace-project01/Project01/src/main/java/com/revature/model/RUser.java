package com.revature.model;

public class RUser {
	
	private int rUserID;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean isManager;
	
	public int getRUserID() {
		return rUserID;
	}
	
	public void setRUserID(int userID) {
		this.rUserID = userID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isManager() {
		return isManager;
	}
	
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return "ReimbursementUser [rUserID=" + rUserID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", isManager=" + isManager + "]";
	}
}
