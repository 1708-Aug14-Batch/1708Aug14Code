package com.ex.pojo;

public class Student {
	private String firstname;
	private String lastname;
	private String email;
	
	public Student(){
		super();
	}
	public Student(String firstname, String lastname, String email){
		super();
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
	}
	public String getFirstname() {
		// TODO Auto-generated method stub
		return this.firstname;
	}

	public String getLasttname() {
		// TODO Auto-generated method stub
		return this.lastname;
	}
	
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}
	public void setFirstname(String firstname) {
		// TODO Auto-generated method stub
		this.firstname=firstname;
		
	}
	public void setLastname(String lastname) {
		// TODO Auto-generated method stub
		this.lastname=lastname;
		
	}
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email=email;
		
	}
}
