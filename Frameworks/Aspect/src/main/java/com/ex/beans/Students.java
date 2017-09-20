package com.ex.beans;

import org.springframework.stereotype.Component;

@Component
public class Students {

	public void cry() {
		System.out.println("Crying..");
	}
	
	public void exist() {
		System.out.println("Existing..");
	}
	
	public void eat() {
		System.out.println("Eating..");
	}
	
	public void work() {
		System.out.println("Working..");
	}
	
	public void takeTime(long time) {
		System.out.println("Waiting..");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
