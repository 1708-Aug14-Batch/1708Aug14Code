package com.ex.question11;

import com.ex.question11package.FloatStuff;

public class AccessFloatFromPackage {

	public static void main(String[] args) {
		
		FloatStuff f = new FloatStuff();
		
		float a = f.getThing1();
		float b = f.getThing2();
		
		System.out.println(a);
		System.out.println(b);

	}

}
