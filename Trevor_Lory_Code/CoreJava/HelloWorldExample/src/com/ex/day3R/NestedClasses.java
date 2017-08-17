package com.ex.day3R;

import com.ex.day3R.NestedClasses.memberClass;

public class NestedClasses {
	
	int a = 0;
	static int b = 0;
	
	static class staticClass {
		void message() {
			System.out.println("Hi I am in my inner class");
			//System.out.println(a);
			System.out.println(b);
		}
	}
	
	class memberClass {
		void message() {
			System.out.println("Hi I am in my member class");
			System.out.println(a);
			System.out.println(b);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Inside main method");
		class localClass {
			void message() {
				System.out.println("Hi I am in my local class");
				//System.out.println(a);
				System.out.println(b);
			}
		}
		
		myInterface anonClass = new myInterface() {

			@Override
			public void doThings() {
				
			}

			@Override
			public void doOtherThings() {
				
			}
			
		};
		
		anonClass.doThings();
		
		staticClass stat = new staticClass();
		stat.message();
		
		//memberClass mem = new memberClass();
		
	}
	
	
}

interface myInterface {
	void doThings();
	void doOtherThings();
}

class Other {
	
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
	
	NestedClasses nested = new NestedClasses();
	memberClass mem = nested.new memberClass();
	
}
