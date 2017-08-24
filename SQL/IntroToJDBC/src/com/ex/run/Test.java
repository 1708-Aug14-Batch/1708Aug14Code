package com.ex.run;

import java.util.ArrayList;

import com.ex.dao.DAOImpl;
import com.ex.pojos.Example;

public class Test {

	public static void main(String[] args) {
		
		DAOImpl dao = new DAOImpl();
//		int id = dao.getID("stored");
//		System.out.println(id);
		
		// testing add to db
//		int x = dao.addExample("wow this is", "awesome");
//		System.out.println(x);
		
		
		// test get all elements
		ArrayList<Example> list = dao.getAll();
		for(Example ex:list){
			System.out.println(ex.toString());
		}

	}

}
