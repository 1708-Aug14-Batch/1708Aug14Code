package com.revature.q11_2;

import com.revature.q11_1.FloatContainer;

public class FloatContainerUser {
	public static void main(String[] args) {
		FloatContainer fc = new FloatContainer();
		/* 
		 * We can see that the value printed out is the default
		 * value given to instances of FloatContainer
		 */
		System.out.println("f1 = " + fc.float1 + ", f2 = " + fc.float2);
		
		
		fc.float1 = 450;
		fc.float2 = 3.50f;
		
		System.out.println("f1 = " + fc.float1 + ", f2 = " + fc.float2);
	}
}
