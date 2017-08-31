package com.revature.andy.pojos;

public class User {

	private int userID;
	private String fName;
	private String lName;
	private String email;
	private String pwd;
	
	public User(){}

	public User(int userid, String fname, String lname, String email, String pwd) {
		super();
		this.userID = userid;
		this.fName = fname;
		this.lName = lname;
		this.email = email;
		this.pwd = pwd;
	}

	public User(String fname, String lname, String email, String pwd) {
		super();
		this.fName = fname;
		this.lName = lname;
		this.email = email;
		this.pwd = pwd;
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

	@Override
	public String toString() {
		return "\n------------------------------------\n"
				+ "UserID: " + userID + 
				"\nFirst Name: " + fName + 
				"\nLast Name: " + lName + 
				"\nEmail: " + email + 
				"\nPassword: " + pwd + 
				"\n------------------------------------\n";
	};
}
