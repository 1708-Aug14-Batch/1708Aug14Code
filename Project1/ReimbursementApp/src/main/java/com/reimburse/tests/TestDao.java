package com.reimburse.tests;

import java.util.ArrayList;

import com.reimburse.dao.DAO;
import com.reimburse.dao.ReimburseDAO;
import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;

public class TestDao {

	public static void main(String[] args) {
		DAO dao = new ReimburseDAO();
		
		//User user = new User(-1,"Josh","Audibert","jaudibert","jaudibert@mail.com","jaudibert", (byte) 0);
		//user.setUserId(dao.addUser(user));
		User user = dao.getUser(21);
		System.out.println(user.toString());
		
//		Reimbursement r = new Reimbursement(-1, user.getUserId(), -1,
//				0, "I actually took a trip",
//				"", new BigDecimal(2500), 
//				new Date(),new Date());
//		r.setReimbursementId(dao.addReimbursement(r));
//		Reimbursement r = dao.getReimbursement(25);
//		System.out.println(r.toString());
		
		User manager = dao.getUser(1);
		System.out.println(manager.toString());
		
//		r.setManagerNotes("yeah ok");
//		r.setResolveId(manager.getUserId());
//		r.setStatusId(1);
//		dao.resolveReimbursement(r);
//		r = dao.getReimbursement(r.getReimbursementId());
//		System.out.println(r.toString());
		
		ArrayList<Reimbursement> pending = dao.getAllPending();
		ArrayList<Reimbursement> resolved = dao.getAllResolved();
		ArrayList<User> users = dao.getAllEmployees();
		
		System.out.println("Pending requests:");
		for(Reimbursement re : pending){
			System.out.println(re.toString());
		}
		
		System.out.println("Resolved requests:");
		for(Reimbursement re : resolved){
			System.out.println(re.toString());
		}
		
		System.out.println("All employees (not managers):");
		for(User u : users){
			System.out.println(u.toString());
		}
	}

}
