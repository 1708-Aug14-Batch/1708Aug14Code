package com.reimbursement.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.reimbursement.pojos.User;



public class createReimburseTest {

	static DAO test = new DAOImpl();
	
	@Test
	public void test() {
		
//		User u = new User(7, "Andrew", "Bonds", "apbonds1@gmail.com", "test1234", 0);
		
//		test.createReimbursement(u);
//		
//		test.getUsers();
		
		ArrayList<User> list = test.getUsers();
		
		for(User u: list) {
			assertEquals(u, test.getUsers());
		}
		

		
//		test.getReimbursement();
		
	}

}
