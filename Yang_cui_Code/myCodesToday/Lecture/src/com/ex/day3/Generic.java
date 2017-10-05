package com.ex.day3;

import java.util.ArrayList;

public class Generic {
	public static void main(String[] args){
		
		ArrayList<String> strings= new ArrayList<String>();
		ArrayList things =new ArrayList();
		things.add(1);
		things.add("hello");
		things.add(new Object());
		
		Box<Integer> intBox= new Box<Integer>();
		Box<String> stringBox =new Box<String>();
		
	}
}

class Box<T>{
	//T stand for type
}