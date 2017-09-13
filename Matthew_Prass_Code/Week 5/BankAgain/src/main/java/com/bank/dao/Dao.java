package com.bank.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bank.pojos.User;
import com.bank.pojos.Account;
import com.bank.pojos.AccountType;
import com.bank.util.ConnectionUtil;

public class Dao {
	public User addStudent(User s) {
		Session sesh = ConnectionUtil.getSession();
		try {
			Transaction tx = (Transaction)sesh.beginTransaction();
			sesh.save(s);
			tx.commit();
		}
		finally {
			sesh.close();
		}
		return s;
	}

}
