package com.question.twenty;

/**
 * My person class for storing the information of each person in the Data.txt file
 * @author Katie
 *
 */
public class Person {

	private String firstName;
	private String lastName;
	private String age;
	private String location;
	
	public Person(String firstName, String lastName, String age, String location) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.location = location;
	}
	
	public Person() {
		super();
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Printing the person's qualities out in the desired format
	 */
	public void printPerson() {
		System.out.println("Name: "+this.firstName+" "+this.lastName);
		System.out.println("Age: "+this.age+" years");
		System.out.println("State: "+location+" State");
	}
	
	
}
