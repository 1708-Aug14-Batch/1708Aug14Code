package com.bank.pojos;

public class Users {
 //INstance variables
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	//No ARGS Constructor
	public Users() {
	}
	
	//Constructor with Arguments
	public Users(int id, String firstname, String lastname, String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		
	}
	
	/*
	 * GETTERS AND SETTERS
	 * 
	 */

	public int getId() {		
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
