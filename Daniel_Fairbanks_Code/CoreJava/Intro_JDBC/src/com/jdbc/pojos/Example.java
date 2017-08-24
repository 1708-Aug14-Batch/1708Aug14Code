package com.jdbc.pojos;

public class Example {

	private int id;
	private String firstname;
	private String lastname;
	private int song;
	
	
	public Example() {
		super();
	}

	public Example(int id, String firstname, String lastname, int song) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.song = song;
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

	public int getSong() {
		return song;
	}

	public void setSong(int song) {
		this.song = song;
	}
	
	
}
