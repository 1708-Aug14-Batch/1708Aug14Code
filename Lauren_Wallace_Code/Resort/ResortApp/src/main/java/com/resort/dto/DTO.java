package com.resort.dto;

import java.util.ArrayList;
import java.util.HashMap;

import com.resort.pojos.Reimbursement;
import com.resort.pojos.User;

public class DTO {
	
	private User user;
	private ArrayList<User> users;
	private ArrayList<Reimbursement> reims;
	private HashMap<Integer, String> rstats;
	private HashMap<Integer, String> rtypes;

	public DTO(User user, ArrayList<Reimbursement> reims, HashMap<Integer, String> rstats,
			HashMap<Integer, String> rtypes) {
		super();
		this.user = user;
		this.reims = reims;
		this.rstats = rstats;
		this.rtypes = rtypes;
	}
	
	public DTO(User user, ArrayList<User> users) {
		super();
		this.user = user;
		this.users = users;
	}

	public DTO(User user, ArrayList<User> users, ArrayList<Reimbursement> reims, HashMap<Integer, String> rstats,
			HashMap<Integer, String> rtypes) {
		super();
		this.user = user;
		this.users = users;
		this.reims = reims;
		this.rstats = rstats;
		this.rtypes = rtypes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public ArrayList<Reimbursement> getReims() {
		return reims;
	}

	public void setReims(ArrayList<Reimbursement> reims) {
		this.reims = reims;
	}

	public HashMap<Integer, String> getRstats() {
		return rstats;
	}

	public void setRstats(HashMap<Integer, String> rstats) {
		this.rstats = rstats;
	}

	public HashMap<Integer, String> getRtypes() {
		return rtypes;
	}

	public void setRtypes(HashMap<Integer, String> rtypes) {
		this.rtypes = rtypes;
	}
	
}
