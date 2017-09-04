package com.ers.dao;

import java.util.List;

import com.ers.pojos.Request;
import com.ers.pojos.User;

public class DatabaseDao implements Dao {

	public User getUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public void submitRequest(int userId, Request request) {
		// TODO Auto-generated method stub
		
	}

	public List<Request> getUserRequests(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Request> getPendingUserRequests(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Request> getResolvedUserRequests(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Request> getAllRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Request> getAllPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Request> getAllResolvedRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void addUser(User user, String password) {
		// TODO Auto-generated method stub
		
	}

	public void setPassword(int userId, String password) {
		// TODO Auto-generated method stub
		
	}

}
