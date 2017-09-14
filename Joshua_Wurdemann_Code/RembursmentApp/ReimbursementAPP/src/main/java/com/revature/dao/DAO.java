package com.revature.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.revature.model.Reimbursement;
import com.revature.model.User;

public interface DAO {
	public HashMap<Integer, String> getEmails();
	public User getUserById(int id);
	public int addUser(String fn, String ln, String email, String pass);
//	public Account createAccount(User u, int typeId);
//  public ArrayList<Reimbursement> getReimbursementByUser(User u);
  public int editUser(User u);
}
