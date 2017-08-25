package com.ex.pojos;

public class Example {

	int id;
	String firstname;
	String lastname;
	int song;
	String songName;
	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public Example() {}
	
	public Example(int id, String firstname, String lastname, int song) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.song = song;
	}

	public Example(int id, String firstname, String lastname, String songName) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.songName = songName;
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

	@Override
	public String toString() {
		return "Example [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", song=" + song + "]";
	}
	public String toStringSongName() {
		return "Example [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", song=" + songName + "]";
	}
	
}
