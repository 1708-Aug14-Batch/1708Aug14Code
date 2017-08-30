package com.bank3.dao;

public interface DAO {
	// adduser
	// add account
	// etc.
	
	public void addUser(String fn, String ln, String username, String password);
	
	public void createAccount(int userid, int typeId);
	
	public void editUser(String fn, String ln, String pw, int id);
	
	public int getUserID(String username, String pw);
	
	public double getBalance(int id, int typeid);
	
	public void updateBalance(int id, int typeid, double deposit);
	
	public void deleteAcct(int id, int typeid);

}
