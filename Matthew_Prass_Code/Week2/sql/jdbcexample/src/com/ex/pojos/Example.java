package com.ex.pojos;

public class Example {
	
	int id;
	String firstname;
	String lastname;
	int favesong;
	
	public Example() {}

	public Example(int id, String firstname, String lastname, int favesong) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.favesong = favesong;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getFavesong() {
		return favesong;
	}

	public void setFavesong(int favesong) {
		this.favesong = favesong;
	}

	@Override
	public String toString() {
		return id +firstname +lastname +favesong;
	}
	
	
	
}
