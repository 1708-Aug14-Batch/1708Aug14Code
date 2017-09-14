package com.reimburse.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.reimburse.dao.DAO;
import com.reimburse.dao.ReimburseDAO;
import com.reimburse.pojos.Reimbursement;
import com.reimburse.pojos.User;

public class JunitTester {

	
	@Test
	  public void testDao(){
		DAO dao = new ReimburseDAO();
		
	    //create test user
		User user1 = new User();
		user1.setEmail("testEmail90909090909");
		user1.setFirstname("fn");
		user1.setLastname("ln");
		user1.setIsManager((byte) 0);
		user1.setPwd("pwd");
		user1.setUsername("test_username98125");
		user1.setUserId(dao.addUser(user1));
		//was inserted
		assertTrue(user1.getUserId() > 0);
		assertTrue(dao.existsEmail(user1.getEmail()));
		assertTrue(dao.existsUsername(user1.getUsername()));
		//compare original to returned from get w/id
		User user2 = dao.getUser(user1.getUserId());
		assertTrue(user1.toString().equals(user2.toString()));
		//compare original to returned from get w/usr + pwd
		//compare added to returned from get
		User user3 = dao.getUser(user1.getUsername(),user1.getPwd());
		assertTrue(user1.toString().equals(user3.toString()));
		//test update
		user1.setFirstname("fn2");
		user1.setLastname("ln2");
		user1.setPwd("pwd2");
		dao.updateUser(user1);
		User user4 = dao.getUser(user1.getUserId());
		assertTrue(user1.toString().equals(user4.toString()));
		

		//create test reimbursement
		Reimbursement r1 = new Reimbursement();
		r1.setAmount(BigDecimal.valueOf(50));
		r1.setDescription("no");
		r1.setSubmitId(user1.getUserId());
		r1.setReimbursementId(dao.addReimbursement(r1));
		//was inserted
		assertTrue(r1.getReimbursementId() > 0);
		
		//new reimbursement has date submitted
		Reimbursement r2 = dao.getReimbursement(r1.getReimbursementId());
		System.out.println("Test date submitted: "+r2.getSubmitDate().toString());
		
		//check get all pending
		assertTrue(dao.getAllPending().size() > 0);
		assertTrue(dao.getEmployeePendingReimbursements(user1.getUserId()).size() > 0);
		assertTrue(dao.getEmployeeReimbursements(user1.getUserId()).size() > 0);
		assertTrue(dao.getEmployeeReimbursements(user1.getFirstname() + " " + user1.getLastname()).size() > 0);
		
		//resolve reimbursement w/ test manager
		User manager = new User();
		manager.setEmail("testEmail90909090908");
		manager.setFirstname("mn");
		manager.setLastname("mn");
		manager.setIsManager((byte) 1);
		manager.setPwd("pwd");
		manager.setUsername("test_username98126");
		manager.setUserId(dao.addUser(manager));
		
		r2.setResolveId(manager.getUserId());
		r2.setStatusId(1);
		r2.setManagerNotes("resolved");
		dao.resolveReimbursement(r2);
		
		//test resolved
		assertTrue(dao.getAllResolved().size() > 0);
		assertTrue(dao.getEmployeeResolvedReimbursements(user1.getUserId()).size() > 0);
		//check that pending is gone
		assertTrue(dao.getEmployeePendingReimbursements(user1.getUserId()).size() == 0);
		
		//remove users & reimbursement
		dao.deleteReimbursement(r2);
		dao.deleteUser(user1);
		dao.deleteUser(manager);
	}
	
	@Test
	  public void testPojos(){
	    
		//users
		User user1 = new User();
		user1.setEmail("email");
		user1.setFirstname("fn");
		user1.setLastname("ln");
		user1.setIsManager((byte) 0);
		user1.setPwd("pwd");
		user1.setUserId(50);
		user1.setUsername("username");
		
		User user2 = new User(50,"fn","ln","username","email","pwd",(byte) 0);

		//same object info, different constructors
		assertTrue(user1.toString().equals(user2.toString()));
		
		user2.setIsManager((byte)1);
		
		assertFalse(user1.toString() == user2.toString());
		
		//test reimbursements
		Reimbursement r1 = new Reimbursement();
		r1.setAmount(BigDecimal.valueOf(50));
		r1.setDescription("no");
		r1.setManagerNotes("yes");
		r1.setReimbursementId(50);
		r1.setResolveDate(null);
		r1.setSubmitDate(new Date());
		r1.setResolveId(5);
		r1.setSubmitId(3);
		r1.setStatusId(0);
		Reimbursement r2 = new Reimbursement(
				50,3,5,0,"no","yes",BigDecimal.valueOf(50),
				new Date(),null
				);
		
		assertTrue(r1.toString().equals(r2.toString()));
	}
}
