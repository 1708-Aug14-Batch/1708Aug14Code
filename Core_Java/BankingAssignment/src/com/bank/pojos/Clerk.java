package com.bank.pojos;

import java.util.Date;

// Manages bank account information
// Has access to every account
// Cannot own an account

public class Clerk extends Person {
	
	// This is used to delimit fields in the toString and fromString methods
	public static final String delimit = "::";
	
	public static double MINIMUM_WAGE = 8.85;
	
	// Each employee has a unique employeeId
	private final int employeeId;
	private String password;
	
	private final String dateHired;
	
	private double hourlyWage;
	
	// Shows whether the employee is currently working for the company
	// Turns false when an employee is let go
	private boolean hired = true;
	
	// Clerks do have administrator privileges
	final boolean admin = true;
	
	public Clerk(Person person, int employeeId, String password) {
		super(person.getSSN(), person.getFirstName(), person.getLastName());
		this.password = password;
		
		dateHired = new Date().toString();
		hourlyWage = MINIMUM_WAGE;
		this.employeeId = employeeId;
	}
	private Clerk(Person per, int employeeId, String password, String dateHired, double hourlyWage, boolean hired) {
		super(per.getSSN(), per.getFirstName(), per.getLastName());
		
		this.employeeId = employeeId;
		this.password = password;
		this.dateHired = dateHired;
		this.hourlyWage = hourlyWage;
		this.hired = hired;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateHired() {
		return dateHired;
	}

	public boolean isAdmin() {
		return admin;
	}

	public boolean isHired() {
		return hired;
	}

	public void setHired(boolean hired) {
		this.hired = hired;
	}
	
	public String toString() {
		return super.toString() + User.delimit + employeeId + delimit + password + delimit +
				dateHired + delimit + hourlyWage + delimit + hired;
	}
	public static Clerk fromString(String str) throws NumberFormatException {
		String[] splitStr = str.split(User.delimit);
		Person per = Person.fromString(splitStr[0]);
		
		String[] splitSplitStr = splitStr[1].split(delimit);
		
		int employeeId = Integer.parseInt(splitSplitStr[0]);
		String password = splitStr[1];
		String dateHired = splitSplitStr[2];
		double hourlyWage = Double.parseDouble(splitSplitStr[3]);
		boolean hired = Boolean.parseBoolean(splitSplitStr[4]);
		
		return new Clerk(per, employeeId, password, dateHired, hourlyWage, hired);
	}
	
	// Validaes whether these strings can be used to make this object. Uses delimit
	public boolean validateStrings() {
		
		return !(password.contains(delimit) || dateHired.contains(delimit));
	}
	
}