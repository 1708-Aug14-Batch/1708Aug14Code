package com.ex.homework1JavaOOP;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Restaurant chineseRestaurant = new ChineseRestaurant();
		
		chineseRestaurant.cooksFood();
		
		ChineseRestaurant cr;
		
		cr = (ChineseRestaurant) chineseRestaurant; 
		cr.addToMenu("General T'so Chicken");
		
		System.out.println("Menu" + cr.getMenu());
	}

}
