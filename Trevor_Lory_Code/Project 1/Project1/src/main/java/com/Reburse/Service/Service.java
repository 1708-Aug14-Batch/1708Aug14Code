package com.Reburse.Service;

import java.util.ArrayList;

import com.Reburse.dao.DAO;
import com.Reburse.dao.DAOimplementation;
import com.Reburse.pojos.Reimbursement;
import com.Reburse.pojos.User;

public class Service {

	static private DAO dao = new DAOimplementation();
	
	public User getUser(String email, String password) {
		return dao.getUser(email, password);
	}
	
	public ArrayList<Reimbursement> getReimByUser(User u) {
		return dao.getUserReimbursements(u);
	}
	
	public boolean AddReim(int SubID, String desc, double Amt) {
		return dao.addReimbursement(SubID, desc, Amt);
	}
	
	public boolean UpdateEmp(User u) {
		return dao.updateUser(u);
	}
}
