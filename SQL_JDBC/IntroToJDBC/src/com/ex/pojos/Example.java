package com.ex.pojos;

public class Example {

	private int id;
	private String firstName;
	private String lastName;
	private Integer songID;
	private String songName;
	
	public Example() {}
	public Example(int id, String firstName, String lastName, Integer songID) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.songID = songID;
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

	public Integer getSongID() {
		return songID;
	}

	public void setSongID(Integer songID) {
		this.songID = songID;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}
	@Override
	public String toString() {
		return "Example [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", songID=" + songID
				+ ", songName=" + songName + "]";
	}

}
