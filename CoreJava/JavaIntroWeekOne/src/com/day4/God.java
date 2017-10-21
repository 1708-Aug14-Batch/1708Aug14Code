package com.day4;

public class God {
	private static God instance = new God();
	private String name;
	private boolean believer = true;
	private boolean raining;
	
	private God() {
		
	}
	
	public static God getGod() {
		return instance;
	}
	
	public void praise() {
		if(believer == true) {
		System.out.println("Yes, good, I am your one God.");
			if(raining) {
				System.out.println("Go build a boat");
			}
		}
		else {
			System.out.println("You are not a believer");
			if(raining) {
				System.out.println("I'm just gonna try again");
			}
		}
	}

	public void forsake() {
		System.out.println("SMITE");
		believer = false;
	}
	
	public void recommit() {
		believer = true;
		if(raining) {
			System.out.println("Okay go build a boat lol");
		}
	}
	
	public void Noah() {
		System.out.println("Lol, make it rain.");
		raining = true;
	}
}
