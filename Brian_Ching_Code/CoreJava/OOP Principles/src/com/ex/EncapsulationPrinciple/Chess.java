package com.ex.EncapsulationPrinciple;

public class Chess {

	private String year;
	private int ageRange;
	private String description;
	
	public Chess(String year, int ageRange, String description) {
		super();
		this.year = year;
		this.ageRange = ageRange;
		this.description = description;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(int ageRange) {
		this.ageRange = ageRange;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
