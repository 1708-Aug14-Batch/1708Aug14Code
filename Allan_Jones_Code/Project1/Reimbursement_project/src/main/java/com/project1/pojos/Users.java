package com.project1.pojos;

public class Users {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private int isMgr;
	
	public Users() {}
	
	public Users(String firstName, String lastName, String userName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
	}

	public Users(String firstName, String lastName, String userName, String password, String email, int isMgr) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.isMgr = isMgr;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsMgr() {
		return isMgr;
	}

	public void setIsMgr(int isMgr) {
		this.isMgr = isMgr;
	}

	@Override
	public String toString() {
		return "Users [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", isMgr=" + isMgr + "]";
	}
	
}
