package com.ex.run;

import java.util.ArrayList;

import com.ex.dao.DAOImpl;
import com.ex.pojo.Example;

public class Test {
	public static void main(String[] args){
		DAOImpl dao=new DAOImpl();
		//int id=dao.getID("stored");
		//System.out.println(id);
		//int x=dao.addExample("wow this is", "awesome");
		//System.out.println(x);
		ArrayList<Example> list = dao.getAll();
		for(Example ex:list){
			System.out.println(ex.toString());
		}
	}
}
