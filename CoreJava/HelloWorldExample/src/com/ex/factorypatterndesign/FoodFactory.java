package com.ex.factorypatterndesign;

public class FoodFactory {
	public Food getFood(String foodType) {
		
		switch(foodType) {
		case "Bread":
			return new Bread();
		case "Soup":
			return new Soup();
		case "Steak":
			return new Steak();
		default:
			return null;
		}
		
	}
}
