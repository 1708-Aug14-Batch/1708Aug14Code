package com.day3;

import com.day3.NestedClasses.MemberClass;

public class NestedClasses {
	int b = 0;
	static int c = 9;
	//Java allows us to write class
	//Static Nested Classes:
	//
	static class StaticClass{
	
		void Message() {
			System.out.println("I'm in a Static nexted class, this is my first inner class!");
			System.out.println(c); //I can't put a or b here
			
		}
	}
		
	class MemberClass{
		void message() {
			System.out.println("I am in my member inner class");
			System.out.println(b+" "+c);//I can't access a!
		}
		void doOtherThings() {
			System.out.println("Doin stuff");
		}
	}
	
	//static MemberClass memClass = new MemberClass();
	
	public static void main(String[] args) {
		System.out.println("Inside main method");
		
		class LocalClass{
			void message() {
				System.out.println("I am in my local class!");
				System.out.println(c); //I can't access a or b!
			}
		}
		
		myInterface anon = new myInterface() {
			@Override
			public void doThings() {
			}
			@Override
			public void doStuff() {
			}
			};
		
		StaticClass statClass = new StaticClass();
		statClass.Message();
//		LocalClass 
		LocalClass locClass = new LocalClass();
		locClass.message();
	
	//	memClass.message();
		myOtherInterface inter = () -> {System.out.println("lambda"); };
		inter.doIt();
	}

	
	
	
	
}

interface myInterface{
	void doThings();
	void doStuff();
}

interface myOtherInterface{
	void doIt();
}

class Other{
	int a;
	String message;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
