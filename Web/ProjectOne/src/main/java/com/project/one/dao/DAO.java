package com.project.one.dao;

public interface DAO {
	
	int addEmployee(String fn, String ln, String email, String pwd, int mngr);
//	int addRequest()
	String getEmployee(String usr);
	//update employee
	//update request

}
