package com.ex.run;

import java.util.ArrayList;

import com.ex.fakedao.FakeDaoImpl;
import com.ex.pojos.Examples;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FakeDaoImpl dao = new FakeDaoImpl();
		//int id = dao.getID("Jeff");
		//System.out.println(id);
		
		//int x = dao.addExample("wow", "wow");
		//System.out.println(x);	
		
		ArrayList<Examples> list = dao.getAll();
		for(Examples ex:list) {
			System.out.println(ex.toString());
		}
	}
}

