package com.ex.AbstractionPrinciple;

public abstract class Games {
		
		public abstract float price(float base, float tax);
		
		public abstract void resources(String x, String y);
		
		public void played() {
			System.out.println("the game is being played");
		}
		
}
