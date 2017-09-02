package com.project1.dao;

public interface DAO {
	
	public int getUserID(String username, String pw);
	
	public void registerEmp(int id);
	
	public void viewAllEmp();
	
	public void viewPendingRequests();
	
	public void viewResolvedRequests();
	
	public void viewEmpRequest(int id);

}
