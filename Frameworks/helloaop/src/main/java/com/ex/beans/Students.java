package com.ex.beans;

import org.springframework.stereotype.Component;

@Component
public class Students {
	
	public void cry(){
		System.out.println("Genesis is making me miserable. wahh");
	}
	
	public void exist(){
		System.out.println("we here");
	}
	
	public void eat(){
		int x = 1;
		for(int i = 0; i < 10000; i++){
			x = x + 10;
		}
		System.out.println("today i am eating ramen bc poor");
	}
	
	public void work(){
		System.out.println("I have been staring at my laptop for 12 hours");
	}
	
	
	public void taketime(long time){
		System.out.println("waiting");
		try{
			Thread.sleep(time);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	

}
