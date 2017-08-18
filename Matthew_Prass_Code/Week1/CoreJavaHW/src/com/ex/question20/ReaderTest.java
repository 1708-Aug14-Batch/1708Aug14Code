package com.ex.question20;

import java.util.ArrayList;

public class ReaderTest {

	static Reader r;
	public static void main(String[] args) {
		
		getThings();

	}
	
	static void getThings()
	{
		r = new Reader();
		ArrayList<Things> a = r.readThings();
		for(Things t: a)
		{
			System.out.println("Name: " + t.getFirstname() + t.getLastname());
			System.out.println("Age: " + t.getAge());
			System.out.println("State: " + t.getCollege() + "State"); 
			System.out.println();
		}
	}

}
