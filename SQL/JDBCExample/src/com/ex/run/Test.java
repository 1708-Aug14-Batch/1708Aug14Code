package com.ex.run;

import java.util.ArrayList;

import com.ex.dao.DAOImpl;
import com.ex.pojos.Example;

public class Test {
	public static void main(String[] args) {



		DAOImpl dao = new DAOImpl();
		
		ArrayList<Example> list = dao.getAll();
		
		for(Example ex : list){
			System.out.println(ex.toString());
		}
		
		



	}
}
