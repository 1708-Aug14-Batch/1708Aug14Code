package com.ers.dao;

import java.util.List;

import com.ers.pojos.Request;
import com.ers.pojos.User;

public interface Dao {
	
	public User getUser(String email, String password);
	
	public User getUser(int userId);
	
	public boolean hasUser(int userId);
	
	public void addUser(User user, String password);
		
	public void setPassword(int userId, String password);
	
	public void setFirstName(int userId, String firstName);
	
	public void setLastName(int userId, String lastName);
	
	public void submitRequest(int userId, Request request);
	
	public List<Request> getUserRequests(int userId);
	
	public List<Request> getPendingUserRequests(int userId);
	
	public List<Request> getResolvedUserRequests(int userId);
	
	public List<Request> getAllRequests();
	
	public List<Request> getAllPendingRequests();
	
	public List<Request> getAllResolvedRequests();
	
	public List<User> getAllEmployees();
}
