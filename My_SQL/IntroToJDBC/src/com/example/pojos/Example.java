package com.example.pojos;

public class Example {
	
	int id;
	String firstName;
	String lastName;
	String favSong;

	public Example(int id, String firstName, String lastName, String favSongId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.favSong = favSongId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getFavSongId() {
		return favSong;
	}

	public void setFavSongId(int favSongId) {
		this.favSong = favSong;
	}

	@Override
	public String toString() {
		return "Example [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", favSongId=" + favSong + "]";
	}	
}
