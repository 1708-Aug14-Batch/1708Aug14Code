package com.rev.pojos;

public class Example {

	int id;
	String firstname;
	String lastname;
	int favSong;
	
	public Example() {
		super();
	}
	public Example(int id, String firstname, String lastname, int favSong) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.favSong = favSong;
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
	public int getFavSong() {
		return favSong;
	}
	public void setFavSong(int favSong) {
		this.favSong = favSong;
	}
	@Override
	public String toString() {
		return "Example [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", favSong=" + favSong
				+ "]";
	}
	
}
