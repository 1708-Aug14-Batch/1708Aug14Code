package com.reimbursments.pojos;

public class Users {
	private int userid;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int isManager;
	
	public Users() {
		super();
	}
	

	public Users(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public Users(String firstName, String lastName,String email, String password, int isManager) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isManager = isManager;
	}


	public Users(int userid, String firstName, String lastName, String email, String password,
			int isManager) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isManager = isManager;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
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


	public int getIsManager() {
		return isManager;
	}


	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}


	@Override
	public String toString() {
		return "Users [userid=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", isManager=" + isManager + "]";
	}
	
	
	

}
