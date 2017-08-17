package com.x.pogos;

public class Student {
	
	private String firstname;
	private String lastname;
	private String email;
	
	public Student()
	{
		
	}
	
	public Student(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
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
	
	public String toString()
	{
		return "Student [ " + firstname + " : " + lastname + " : " + email + " ]";
	}
	
	

}
