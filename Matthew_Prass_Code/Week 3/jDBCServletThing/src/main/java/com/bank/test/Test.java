package com.bank.test;

import com.bank.dao.DAO;
import com.bank.dao.DaoImpl;

public class Test 
{
	public static void main(String[] args) {
		DAO dao = new DaoImpl();
		System.out.println(dao.getUserByID(1));
	}
}
