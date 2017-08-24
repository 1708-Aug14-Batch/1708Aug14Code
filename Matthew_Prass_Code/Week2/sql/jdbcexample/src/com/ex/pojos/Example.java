package com.ex.pojos;

public class Example {
	
	int id;
	String firstname;
	String lastname;
	String favesong;
	
	public Example() {}

	public Example(int id, String firstname, String lastname, String favesong) {
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

	public String getFavesong() {
		return favesong;
	}

	public void setFavesong(String favesong) {
		this.favesong = favesong;
	}

	@Override
	public String toString() {
		return "Example[ " + "id: " + id + " " +"|First name: " + firstname + " " +"|Last name: "+lastname+ " " +"|Fave song: " + favesong + " ]";
	}
	
	
	
}
