package com.ex.run;

import java.util.ArrayList;

import com.ex.daoimpl.DaoImpl;
import com.ex.pojos.Example;

public class Test {
	public static void main(String[] args) {
		
		DaoImpl dao = new DaoImpl();
		//int id = dao.getID("stored");
		//String name = dao.getName(0);
		//System.out.println(id);
		//System.out.println(name);
		//int x = dao.addExample("wow this is", "awesome");
		//System.out.println(x);
		
		ArrayList<Example> list = dao.getAll();
		
		for(Example ex:list)
			System.out.println(ex.toString());
	}

}
