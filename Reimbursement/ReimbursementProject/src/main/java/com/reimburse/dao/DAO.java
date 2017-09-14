package com.reimburse.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;

public interface DAO {
	public User getUserById(int id);
	public int addUser(String firstname, String lastname, String email, String pwd);
	public Reimbursement addReimbursement(User u, String desc, double amt);	
	public HashMap<Integer, String> getEmails();
	public ArrayList<Reimbursement> getReimburseByUser(User u);

}
