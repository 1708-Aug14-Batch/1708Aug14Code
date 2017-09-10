package com.revature.andy.pojos;

public class User {

	private int userID;
	private String fName;
	private String lName;
	private String email;
	private String pwd;
	private int isManager;
	
	public User(){}
	
	public User(int userID, String fName, String lName, String email, String pwd, int isManager) {
		super();
		this.userID = userID;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.pwd = pwd;
		this.isManager = isManager;
	}

	public User(String fname, String lname, String email, String pwd, int isManager) {
		super();
		this.fName = fname;
		this.lName = lname;
		this.email = email;
		this.pwd = pwd;
		this.isManager = isManager;
	}

	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFName() {
		return fName;
	}

	public void setFName(String fName) {
		this.fName = fName;
	}

	public String getLName() {
		return lName;
	}

	public void setLName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return pwd;
	}

	public void setPassword(String password) {
		this.pwd = password;
	}
	
	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", pwd=" + pwd
				+ ", isManager=" + isManager + "]";
	}
	
}
