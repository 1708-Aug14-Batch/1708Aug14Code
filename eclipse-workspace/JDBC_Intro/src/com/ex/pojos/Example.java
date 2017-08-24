package com.ex.pojos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ex.util.ConnectionSingleton;

public class Example {
	
	private int ID;
	private String firstName;
	private String lastName;
	private int songID;
	
	public Example(int id, String firstName, String lastName, int song) {
		this.ID = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.songID = song;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public int getSongID() {
		return songID;
	}
	public void setSongID(int songID) {
		this.songID = songID;
	}
	@Override
	public String toString() {
		return "Example [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", songID=" + songID + "]";
	}

}
