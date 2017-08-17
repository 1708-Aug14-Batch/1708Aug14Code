package com.revature.student;

public class Student {
	private String first, last, email;
	
	public Student(String first, String last, String email) {
		this.first = first;
		this.last = last;
		this.email = email;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "[first = " + first + " last = " + last + " email = " + email + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Student))
			return false;
		Student s = (Student) o;
		return this.first.equals(s.first) && this.last.equals(s.last) && this.email.equals(s.email);
	}
}
