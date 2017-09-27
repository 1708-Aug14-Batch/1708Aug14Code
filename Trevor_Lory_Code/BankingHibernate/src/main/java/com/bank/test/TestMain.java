package com.bank.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.beans.User;
import com.bank.dao.DAO;
import com.ex.service.Service;

public class TestMain {

	public static void main(String[] args) {
		
		//AbstractApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
		
		//DAO dao = (DAO) con.getBean("myDao");
		
//		User u = new User();
//		u.setFIRSTNAME("Test");
//		u.setLASTNAME("User");
//		u.setEMAIL("testing@email.com");
//		u.setPASSWORD("12345");
//		
//		dao.addUserNew(u);
		
		Service ser = new Service();
		Scanner sc = new Scanner(System.in);
		String em = sc.nextLine();
		
		if(ser.validateEmail(em)) {
			User u = new User();
			u.setEMAIL(em);
			u.setFIRSTNAME(sc.nextLine());
			u.setLASTNAME(sc.nextLine());
			u.setPASSWORD(sc.nextLine());
			u = ser.addUser(u);
			System.out.println(u.toString());
		}
		
//		Scanner sc = new Scanner(System.in);
//		String em = sc.nextLine();
//		
//		boolean yes = true;
//		
//		List<String> thing = dao.getAllEmails();
//		for(int i = 0; i < thing.size(); i++) {
//			System.out.println(thing.get(i));
//			if(em.equals(thing.get(i))) {
//				System.out.println("NOPE");
//				yes = false;
//				break;
//			}
//		}
//		
//		if(yes) {
//			User u = new User();
//			u.setEMAIL(em);
//			u.setFIRSTNAME(sc.nextLine());
//			u.setLASTNAME(sc.nextLine());
//			u.setPASSWORD(sc.nextLine());
//			u = dao.addUserNew(u);
//			System.out.println(u.toString());
//		}
		
//		BankHibDAOImp dao = new BankHibDAOImp();
//		List<User> list = dao.getAllUsers();
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
//		
//		List<Account> list2 = dao.getAllAccounts();
//		for(int i = 0; i < list2.size(); i++) {
//			System.out.println(list2.get(i).toString());
//		}
//		
//		List<AccountType> list3 = dao.getAllAccountTypes();
//		for(int i = 0; i < list3.size(); i++) {
//			System.out.println(list3.get(i).toString());
//		}
//		
//		User u = new User();
//		u.setEMAIL("HibernateTest");
//		u.setFIRSTNAME("Hib");
//		u.setLASTNAME("bernate");
//		u.setPASSWORD("hib");
//		dao.addUser(u);
//		System.out.println(u.getUSERID());
	}
	
}
