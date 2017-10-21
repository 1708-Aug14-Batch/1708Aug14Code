package com.day4;

public class Casting {
	public static byte castDtoB(double d) {
		byte ret = (byte)d;
		return ret;
	}
	public static void main(String[] args) {
		byte bYte 		= 111;
		short sHort		= 111;
		int iNt			= 121;
		long lOng 		= 121;

		float fLoat 		= -129;
		byte abyte = (byte)fLoat;
		System.out.println("a float: "+fLoat+" cast to a byte: "+abyte+" cast back: "+(float)abyte);

		double dOuble 	= 2.508;
		char cHar = 'a';
		boolean bOolean = true;

		System.out.println((byte)cHar);
		System.out.println((byte)dOuble);
		System.out.println((byte)lOng);
		System.out.println((byte)iNt);
		System.out.println((byte)sHort);


//		String demo = "hello";
//		// The above object is stored in constant string pool
//		//and its value can not be modified.
//
//
//		demo ="Bye" ;     
//		//new "Bye" string is created in constant pool and referenced 
//		//by the demo variable            
//		// "hello" string still exists in string constant pool and its 
//		//value is not overrided but we lost reference to the  "hello" string  
//		
//		
//		int x = 2;
//		int y = 4;
//		if(x==2 & y==2) {
//			System.out.println("bit wise, true & false");
//		}
//		if(trying() ^ thist()) {
//			System.out.println("bit wise");
//		}
//		
//		System.out.println(10011|10111);
//		boolean condition = true;
//		boolean otherCondition = true;
//		if(condition) {
//			//do things
//		}
//		else if(otherCondition) {
//			//do different things
//		}
//		else {
//			//do something else
//		}
		
		int cond = 1;
		switch(cond) {
		case 1:
			System.out.println("1");
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
		}
		
		int[] a = {1,2,3,4,5};
		int[] b = {1,2,3};
		int[][] c;
		c[0] = a;
		
		
		try {
			//Risky business that could through an Exception
		}
		catch(Exception e){
			//what to do if Exception e is thrown
		}
		finally {
			//whether or not Exception is thrown,
			//whatever is writte here will happen
		}
		
	}
	
		
		static boolean trying() {
			System.out.println("inside try");
			return true;
		}
		static boolean thist() {
			System.out.println("inside this");
			return false;
		}
		
	}


