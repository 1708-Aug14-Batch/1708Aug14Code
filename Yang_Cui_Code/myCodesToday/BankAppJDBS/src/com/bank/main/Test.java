package com.bank.main;

import com.bank.dao.DaoImpl;
import com.bank.pojos.User;

public class Test {
	public static void main(String[] args){
		DaoImpl dao = new DaoImpl();
		//dao.addUser("Random2", "Random2", "random2@random2.com", "random222");
		User user1 =new User(1,"test0x","test0x","test0x@random0x.com","random000x");
		int x=dao.updateUser(user1);
		System.out.println(x);
	}
}
