package com.bank.test;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.model.BankUser;
import com.bank.service.BankService;

public class MainTest {
	public static void main(String[] args) {

		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BankService service = ac.getBean("bankService", BankService.class);

		System.out.println(service.getUserByUsername("Test"));
		
		
	}

}
