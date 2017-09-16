package com.project1.dao;

import java.util.ArrayList;

import com.project1.dto.DTO;
import com.project1.pojos.Reimbursements;
import com.project1.pojos.Users;

public interface DAO {
	
	public int getUserID(String username, String pw);
	
	public Users getUser(int id);
	
	public boolean isMgr(int id);
	
	public boolean registerEmp(String fn, String ln, String un, String em);
	
	public ArrayList<Users> viewAllEmp();
	
	public void submitRequest(int submitterid, String description, double amt);
	
	public ArrayList<DTO> viewPendingRequestsByMgr();
	
	public ArrayList<DTO> viewResolvedRequestsByMgr();
	
	public ArrayList<Reimbursements> viewPendingRequestsByEmp(int id);
	
	public ArrayList<Reimbursements> viewResolvedRequestsByEmp(int id);
	
	public void viewEmpRequest(int id);
	
	public void viewEmployee(int id);
	
	public void updateEmployee(int id, String fn, String ln, String em, String un, String pw);

}
