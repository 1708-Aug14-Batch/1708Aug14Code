package com.ex.question11;

//package to import 
import com.ex.question11package.FloatStuff;

public class AccessFloatFromPackage {

	public static void main(String[] args) {
		
		
		//object to access float variables
		FloatStuff f = new FloatStuff();
		
		//accessing the float variables
		float a = f.getThing1();
		float b = f.getThing2();
		
		System.out.println(a);
		System.out.println(b);

	}

}
