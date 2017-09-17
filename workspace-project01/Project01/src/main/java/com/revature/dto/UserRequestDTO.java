package com.revature.dto;

import com.revature.model.Reimbursement;

public class UserRequestDTO {
	
	private String firstName;
	private String lastName;
	private Reimbursement reimb;
	
	public UserRequestDTO(String firstName, String lastName, Reimbursement reimb) {
		this.errorCheckFirstName(firstName);
		this.errorCheckLastName(lastName);
		this.errorCheckReimb(reimb);
		this.firstName = firstName;
		this.lastName = lastName;
		this.reimb = reimb;
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
	
	private void errorCheckReimb(Reimbursement reimb) {
		if (reimb == null) {
			throw new IllegalArgumentException("Reimbursement cannot be null");
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.errorCheckFirstName(firstName);
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.errorCheckLastName(lastName);
		this.lastName = lastName;
	}

	public Reimbursement getReimb() {
		return reimb;
	}

	public void setReimb(Reimbursement reimb) {
		this.errorCheckReimb(reimb);
		this.reimb = reimb;
	}
	
}
