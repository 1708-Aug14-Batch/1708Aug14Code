package com.bank.pojos;

import java.time.LocalDate;

public class Person {
	
	// Each person must have a unique 9-digit Social Security Number
	private final int SSN;

	// Each person must have a firstName and lastName
	private String firstName;
	private String lastName;

	// If a person has an email then it must be unique.
	private String email = "";
	
	private LocalDate birthDate;

	private boolean deceased = false;
	
	public Person(int SSN, String firstName, String lastName, LocalDate birthDate) {

		this.SSN = SSN;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
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

	public int getSSN() {
		return SSN;
	}
	
	public void setDeceased(boolean deceased) {
		this.deceased = deceased;
	}
	
	public boolean isDeceased() {
		return deceased;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [SSN=" + SSN + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", birthDate=" + birthDate + ", deceased=" + deceased + "]";
	}

}