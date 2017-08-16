package com.ex.StudentIO;

public class Student {
	private String firstname;
	private String lastname;
	private int studentID;
	
	
	public Student() {
		super();
	}

	public Student(String firstname, String lastname, int studentID) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.studentID = studentID;
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

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", studentID=" + studentID + "]";
	}
	
}
