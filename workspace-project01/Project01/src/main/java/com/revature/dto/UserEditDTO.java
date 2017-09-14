package com.revature.dto;


public class UserEditDTO {
	
	private String firstName;
	private String lastName;
	private String email;
	private String newPassword;
	private String currentPassword;
	
	public UserEditDTO() {}
	
	public UserEditDTO(String firstName, String lastName, String email, String newPassword, String currentPassword) {
		this.errorCheckFirstName(firstName);
		this.errorCheckLastName(lastName);
		this.errorCheckEmail(email);
		this.errorCheckNewPassword(newPassword);
		this.errorCheckCurrentPassword(currentPassword);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.newPassword = newPassword;
		this.currentPassword = currentPassword;
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

	private void errorCheckNewPassword(String newPassword) {
		if (newPassword == null) {
			throw new IllegalArgumentException("New password cannot be null");
		}
	}
	
	private void errorCheckCurrentPassword(String currentPassword) {
		if (currentPassword == null) {
			throw new IllegalArgumentException("Current passwords cannot be null");
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

	public String getNewPassword() {
		return newPassword;
	}
	
	public void setNewPassword(String newPassword) {
		this.errorCheckNewPassword(newPassword);
		this.newPassword = newPassword;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	
}
