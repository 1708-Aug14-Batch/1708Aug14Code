package com.project1.dao;

import java.util.ArrayList;

import com.project1.pojos.Users;

public interface DAO {
	
	public int getUserID(String username, String pw);
	
	public Users getUser(int id);
	
	public boolean isMgr(int id);
	
	public boolean registerEmp(String fn, String ln, String un, String em);
	
	public ArrayList<Users> viewAllEmp();
	
	public void viewPendingRequestsByMgr();
	
	public void viewResolvedRequestsByMgr();
	
	public void viewPendingRequestsByEmp(int id);
	
	public void viewResolvedRequestsByEmp(int id);
	
	public void viewEmpRequest(int id);
	
	public void viewEmployee(int id);

}
