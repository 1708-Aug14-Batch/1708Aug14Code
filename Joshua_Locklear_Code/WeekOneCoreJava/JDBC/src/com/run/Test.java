package com.run;

import java.io.OutputStream;
import java.util.ArrayList;

import com.dao.DAOimpl;
import com.pojo.Example;

public class Test {
	public static void main(String[] args) {
		DAOimpl dao = new DAOimpl();
//		int id = dao.getID("stored");
//		System.out.println(id);
		
//		int x = dao.addExample("Jax", "Hill");
//		System.out.println(x);
//		
//		ArrayList<Example> list = dao.getAll();
//		for(Example ex:list){
//			System.out.println(ex.toString());
//		}
		
		String name = dao.getNameById(1);
		System.out.println(name);
		
		ArrayList<Example> list = dao.getAll2();
		for(Example ex:list){
			System.out.println(ex.toString());
		}
	
	}
}
