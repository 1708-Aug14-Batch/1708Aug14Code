package com.exe.nestedclasses;

import com.exe.nestedclasses.NestedClasses.MemberClass;

public class NestedClasses {
	
	public static void main(String[] args) {
		
		MyInterface anonClass = new MyInterface() {

			@Override
			public void doThings() {
				// TODO Auto-generated method stub
				System.out.println("doing things");
				
			}

			@Override
			public void doOtherThings() {
				// TODO Auto-generated method stub
				System.out.println("doing other things");
				
			}
		};
		
		StaticClass stat = new StaticClass();
		stat.message();
		
		//MemberClass mem = new NestedClasses.MemberClass();
		//mem.message();
		
		System.out.println("Hi main method");
		class localClass{
			void message() {
				System.out.println("Hi local class");
				System.out.println("b");
			}
		}
	}
	
	int a = 0;
	static int b = 0;
	
	static class StaticClass{
		void message() {
			System.out.println("Hi static inner class");
			// can't print a
			System.out.println(b);
		}
	}
	
	class MemberClass{
		void message() {
			System.out.println("Hi member class");
			System.out.println(a + b);
		}
	}
	
	Other anon = new Other() {
		
	};
	
}

interface MyInterface{
	void doThings();
	void doOtherThings();
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
	
	public String getString() {
		return message;
	}
	
	public void setString(String message) {
		this.message = message;
	}
	
	NestedClasses nested = new NestedClasses();
	MemberClass mc = nested.new MemberClass();
	
//	mc.message
}
