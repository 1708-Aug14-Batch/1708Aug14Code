package com.day4;

public class FindGod {
	public static void main(String[] args) {
		
	God myGod = God.getGod();
	myGod.praise();
	myGod.forsake();
	
	God newGod = God.getGod();
	newGod.praise();
	
	newGod.Noah();
	myGod.praise();
	myGod.recommit();
	}
}
