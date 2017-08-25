package com.ex.run;

import java.util.ArrayList;

import com.bank.daoimpl.DaoImpl;
import com.bank.pojos.User;

public class Test {

	public static void main(String[] args) {
		
		DaoImpl dao = new DaoImpl();
		
		int x = dao.addUser("mo", "p", "some", "else");
		System.out.println(x);
		
		//ArrayList<User> list =  dao.getAll();
		//for(User u : list)
			//System.out.println(u.toString());
		

	}

}
