package com.bank.pojos;

public class User {
	
	private int id = -1;
	private String first, last, email, password;
	
	public User() {
	}
	
	public User(String first, String last, String email, String password) {
		this.first = first;
		this.last = last;
		this.email = email;
		this.password = password;
	}
	
	public User(int id, String first, String last, String email, String password) {
		this.id = id;
		this.first = first;
		this.last = last;
		this.email = email;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
