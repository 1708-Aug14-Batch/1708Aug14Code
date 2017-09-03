package com.bank.pojos;

public class Person {

	// This is used to delimit fields in the toString and fromString methods
	public static final String delimit = ":";
	
	// Each person must have a unique 9-digit Social Security Number
	private final String SSN;

	// Each person must have a firstName and lastName
	private String firstName;
	private String lastName;

	// If a person has an email then it must be unique.
	private String email = "";

	private boolean deceased = false;
	
	// Note: Do not create a Person object unless the given SSN is unique
	public Person(String SSN, String firstName, String lastName) {

		this.SSN = SSN;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getSSN() {
		return SSN;
	}
	
	public void setDeceased(boolean deceased) {
		this.deceased = deceased;
	}
	
	public boolean isDeceased() {
		return deceased;
	}

	// Turns a person into a string object
	public String toString() {
		return SSN + delimit + firstName + delimit + lastName + delimit + deceased + delimit + email;
	}
	// Creates a person object from the given string
	public static Person fromString(String str) {

		String[] splitStr = str.split(delimit);

		Person per = new Person(splitStr[0], splitStr[1], splitStr[2]);
		per.setDeceased(Boolean.parseBoolean(splitStr[3]));
		
		if (splitStr.length > 4)
			per.setEmail(splitStr[4]);

		return per;
	}
	
	// Validaes whether these strings can be used to make this object. Uses delimit
	public boolean validateStrings() {
		
		return !(SSN.contains(delimit) || firstName.contains(delimit) ||
				lastName.contains(delimit) || email.contains(delimit));
	}
}