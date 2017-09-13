package com.Reburse.dto;

import java.util.ArrayList;

import com.Reburse.pojos.User;

public class DTOAcc {

	ArrayList<User> users = new ArrayList<User>();

	public DTOAcc(ArrayList<User> users) {
		super();
		this.users = users;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
}
