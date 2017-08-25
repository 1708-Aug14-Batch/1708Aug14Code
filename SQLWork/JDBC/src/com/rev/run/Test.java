package com.rev.run;


import java.util.ArrayList;
import com.rev.dao.DAOImpl;
import com.rev.pojos.Example;


public class Test {
	
	public static void main(String[] args) {
		DAOImpl dao = new DAOImpl();
//		int id = dao.getID("stored");
//		System.out.println(id);
//		
//		String name = dao.getName(2);
//		System.out.println(name);
////	
//		int x = dao.addExample("cool", "stuff");
//		System.out.println(x);
//		
//		String name = dao.getName(x);
//		System.out.println(name);
		
		//test get all elements
		ArrayList<Example> list = dao.getAll();
		
		for(Example ex: list) {
			System.out.println(ex.toString());
		}
		
		
		
	
	}
	
	

}
