package com.bank.pojos;

import java.util.Date;

// Manages bank account information
// Has access to every account
// Cannot own an account

public class Clerk extends Person {
		
	public static double MINIMUM_WAGE = 8.85;
	
	// Each employee has a unique employeeId
	private final int employeeId;
	private String password;
	
	private final Date dateHired;
	
	private double hourlyWage;
	
	// Shows whether the employee is currently working for the company
	// Turns false when an employee is let go
	private boolean hired = true;
	
	private Clerk(Person per, int employeeId, String password, Date dateHired, double hourlyWage, boolean hired) {
		super(per.getSSN(), per.getFirstName(), per.getLastName(), per.getBirthDate());
		
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
	public Date getDateHired() {
		return dateHired;
	}
	
	public boolean isHired() {
		return hired;
	}

	public void setHired(boolean hired) {
		this.hired = hired;
	}

	@Override
	public String toString() {
		return "Clerk [employeeId=" + employeeId + ", password=" + password + ", dateHired=" + dateHired
				+ ", hourlyWage=" + hourlyWage + ", hired=" + hired + "]";
	}
	
}
