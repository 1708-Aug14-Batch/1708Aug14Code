package com.ex.factorypatterndesign;

public class FactoryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FoodFactory foodFactory = new FoodFactory();
		
		Food food1 = foodFactory.getFood("Bread");
		
		food1.cook();
		
		Food food2 = foodFactory.getFood("Soup");
		
		food2.cook();
		
		Food food3 = foodFactory.getFood("Steak");
		
		food3.cook();
		
	}

}
