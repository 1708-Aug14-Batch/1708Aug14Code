package com.HW1.Q18;

public class ClassMain {

	public static void main(String[] args) {
		ConClass c = new ConClass();
		if(c.CheckUpper("Hello")) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		System.out.println(c.ToUpper("HeLlo"));
		System.out.println(c.AddTen("10"));
	}
	
}
