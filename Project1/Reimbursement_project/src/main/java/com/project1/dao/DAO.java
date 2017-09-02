package com.project1.dao;

public interface DAO {
	
	public int getUserID(String username, String pw);
	
	public void registerEmp(int id);
	
	public void viewAllEmp();
	
	public void viewPendingRequestsByMgr();
	
	public void viewResolvedRequestsByMgr();
	
	public void viewPendingRequestsByEmp(int id);
	
	public void viewResolvedRequestsByEmp(int id);
	
	public void viewEmpRequest(int id);
	
	public void viewEmployee(int id);

}
