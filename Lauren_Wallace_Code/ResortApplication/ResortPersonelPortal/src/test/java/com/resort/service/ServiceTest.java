package com.resort.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import com.resort.dao.ReimburseDAO;
import com.resort.dao.ReimburseDAOImpl;
import com.resort.dao.UserDAO;
import com.resort.dao.UserDAOImpl;
import com.resort.pojos.Reimbursement;
import com.resort.pojos.User;

public class ServiceTest
{
	private Service service;
	@Mock
	private UserDAOImpl uDAO;
	@Mock
	private ReimburseDAOImpl rDAO;
	
	private User utest;
	private User utest2;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		map.put(1, "example@gmail.com");
		map.put(2, "test");
		when(uDAO.getEmails()).thenReturn(map);
		
		
		utest = new User();
		utest.setEmail("koko@gmail.com");
		utest.setFirstname("john");
		utest.setLastname("mon");
		utest.setPassword("pass");
		utest.setIsManager(0);
		utest.setUserid(5);
		when(uDAO.getUserById(5)).thenReturn(utest);
		
		utest2 = new User();
		utest2.setFirstname("mars");
		utest2.setLastname("solar");
		utest2.setEmail("mars@rover.com");
		utest2.setPassword("planets");
		when(uDAO.addUser("mars", "solar", "mars@rover.com", "planets")).thenReturn(7);
		
		service = new Service(uDAO,rDAO);
	}
	
	//this is successful
	@Test
	public void validatevalidUserTest() 
	{
		assert(service.validateUser("example@gmail.com")==1);
	}
	
	//this is successful
	@Test
	public void validateinvalidUserTest() 
	{
		assert(service.validateUser("ko@gmail.com")==-1);
	}
	
	@Test
	public void validateloginUserTest() 
	{
		assert(service.login(5, "pass").equals(utest));
	}
	
	@Test
	public void validateInvalidLoginPassUserTest() 
	{
		assert(service.login(5, "") == null);
	}
	
	@Test
	public void validateAddUserTest()
	{
		User utest3 = service.addUser(utest2);
		assert(utest3.getUserid() == 7);
	}
	
	@Test
	public void validateInvalidAddUserTest() 
	{
		User utest4 = new User();
		utest4.setEmail("");
		utest4.setFirstname("");
		utest4.setLastname("");
		utest4.setPassword("");
		User utest5 = service.addUser(utest4);
		assert(utest5 == null);
	}
	
	@Test
	public void validateGetUserReimbursementsTest() {
		
	}

}