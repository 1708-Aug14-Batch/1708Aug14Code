package com.revature.dto;

public class RegisterEmpDTO {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public RegisterEmpDTO() {}
	
	public RegisterEmpDTO(String firstName, String lastName, String email, String password) {
		this.errorCheckFirstName(firstName);
		this.errorCheckLastName(lastName);
		this.errorCheckEmail(email);
		this.errorCheckPassword(password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	private void errorCheckFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First name cannot be null");
		}
	}
	
	private void errorCheckLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last name cannot be null");
		}
	}
	
	private void errorCheckEmail(String email) {
		if (email == null) {
			throw new IllegalArgumentException("Email cannot be null");
		}
	}
	
	private void errorCheckPassword(String password) {
		if (password == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
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

}
