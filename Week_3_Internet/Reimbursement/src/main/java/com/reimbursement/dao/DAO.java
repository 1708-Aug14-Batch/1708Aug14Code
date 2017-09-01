package com.reimbursement.dao;

import java.util.ArrayList;

import com.reimbursement.pojos.User;

public interface DAO {
	
	ArrayList<User> getUsers();
	void createUser();
	void createReimbursement(User u);

}
