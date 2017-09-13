package com.Reburse.pojos;

public class User {

	private int UserID;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	private boolean IsManager;
	
	public User() {}
	
	public User(int userID, String firstName, String lastName, String email, String password, boolean isManager) {
		super();
		UserID = userID;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Password = password;
		IsManager = isManager;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public boolean isIsManager() {
		return IsManager;
	}

	public void setIsManager(boolean isManager) {
		IsManager = isManager;
	}

	@Override
	public String toString() {
		return "User [UserID=" + UserID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email
				+ ", Password=" + Password + ", IsManager=" + IsManager + "]";
	}
	
}
