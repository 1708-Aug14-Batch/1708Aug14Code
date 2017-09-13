package com.bank.test;

import java.util.List;

import com.bank.beans.Account;
import com.bank.beans.AccountType;
import com.bank.beans.User;
import com.bank.dao.BankHibDAOImp;

public class TestMain {

	public static void main(String[] args) {
		BankHibDAOImp dao = new BankHibDAOImp();
		List<User> list = dao.getAllUsers();
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		List<Account> list2 = dao.getAllAccounts();
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i).toString());
		}
		
		List<AccountType> list3 = dao.getAllAccountTypes();
		for(int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i).toString());
		}
		
		User u = new User();
		u.setEMAIL("HibernateTest");
		u.setFIRSTNAME("Hib");
		u.setLASTNAME("bernate");
		u.setPASSWORD("hib");
		dao.addUser(u);
		System.out.println(u.getUSERID());
	}
	
}
