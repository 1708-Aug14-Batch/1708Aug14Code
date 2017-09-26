package com.ex.beans;

import org.springframework.stereotype.Component;

@Component
public class Students {

	public void cry() {
		System.out.println("Genesis is making me miserable. waah");
	}
	
	public void exist() {
        System.out.println("we here");
    }
	
	public void eat() {
		System.out.println("today i am eating ramen bc poor");
	}
	
	public void work() {
        System.out.println("I have been staring at my laptop for 12 hours.\n"
        		+ "I've watched the Bee movie 5 times now. Send help.");
    }
	
}
