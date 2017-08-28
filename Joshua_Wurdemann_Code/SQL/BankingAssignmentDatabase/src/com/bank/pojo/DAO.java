package com.bank.pojo;

public interface DAO {
	public int addUser(String fn, String ln, String em, String pw);
	
	public Account addAccount(User u, int typeId);


	
	
}
