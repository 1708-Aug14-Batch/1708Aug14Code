package com.ers.dao;

import java.util.List;

import com.ers.pojos.Request;
import com.ers.pojos.User;

public interface Dao {
	
	public User getUser(String email, String password);
	
	public User getUser(int userId);
	
	public boolean hasUser(int userId);
	
	public int addUser(User user);
	
	public boolean setEmail(int userId, String email);
		
	public boolean setPassword(int userId, String password);
	
	public boolean setFirstName(int userId, String firstName);
	
	public boolean setLastName(int userId, String lastName);
	
	public boolean submitRequest(int userId, float amount, String description);
	
	public List<Request> getUserRequests(int userId);
	
	public List<Request> getPendingRequests(int userId);
	
	public List<Request> getResolvedRequests(int userId);
	
	public List<Request> getAllRequests();
	
	public List<Request> getAllPendingRequests();
	
	public List<Request> getAllResolvedRequests();
	
	public List<User> getAllUsers();
}
