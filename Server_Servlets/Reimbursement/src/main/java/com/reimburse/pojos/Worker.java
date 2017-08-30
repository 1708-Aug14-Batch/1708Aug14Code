package com.reimburse.pojos;

// A BankUser can have many acounts
// Only has access to their own data

public class Worker {

	private final int workerId;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private boolean isManager = false;
	private boolean isHired = true;
	
	public Worker(int workerId, String firstName, String lastName, String email, String username, String password,
			boolean isManager, boolean isHired) {
		super();
		this.workerId = workerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.isManager = isManager;
		this.isHired = isHired;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	public boolean isHired() {
		return isHired;
	}

	public void setHired(boolean isHired) {
		this.isHired = isHired;
	}

	public int getWorkerId() {
		return workerId;
	}

	@Override
	public String toString() {
		return "Worker [workerId=" + workerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", username=" + username + ", password=" + password + ", isManager=" + isManager
				+ ", isHired=" + isHired + "]";
	}

}
