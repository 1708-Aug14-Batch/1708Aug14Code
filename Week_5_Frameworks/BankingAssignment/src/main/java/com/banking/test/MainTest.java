package com.banking.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.banking.DAO.DAO;
import com.banking.pojos.User;

public class MainTest {

	public static void main(String[] args) {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		DAO dao = (DAO) ac.getBean("myDao");
		
		
		User u = new User();
		u.setFirstname("Andrew");
		u.setLastname("Bonds");
		u.setEmail("ChainChain@Chain.com");
		u.setPassword("chain");
		System.out.println(u.toString());
		dao.addUser(u);
		
	}

}
