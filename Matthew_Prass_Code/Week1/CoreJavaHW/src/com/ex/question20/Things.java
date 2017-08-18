package com.ex.question20;

public class Things {

	
	private String firstname;
	private String lastname;
	private int age;
	private String college;
	
	public Things() {
		
	}
	
	public Things(String firstname, String lastname, int age, String college) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.college = college;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}
	
	public String toString()
	{
		return firstname + ":" + lastname + ":" + age + ":" +college +"state";
	}
	
	
}
