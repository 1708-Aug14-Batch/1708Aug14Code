package com.revature.andy.beans;

import org.springframework.stereotype.Component;

@Component
public class Student {

		public void cry() {
			System.out.println("Crying");
		}
		
		public void exist() {
			System.out.println("We Here");
		}
		
		public void eat() {
			System.out.println("Eating");
		}
	
		public void work() {
			System.out.println("Working");
		}
		
		public void takeTime() {
			int a =0;
			for(int x = 0; x < 100000000; x++) {
				for(int y = 0; y < 100000000; y++) {
					a++;
				}
			}
			System.out.println("a:" + a);
		}
}
