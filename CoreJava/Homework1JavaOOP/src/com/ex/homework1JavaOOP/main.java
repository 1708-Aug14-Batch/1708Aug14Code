package com.ex.homework1JavaOOP;

import java.time.LocalDateTime;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Polymorphism covariant
		
		Restaurant chineseRestaurant = new ChineseRestaurant();
		
		// Abstraction
		chineseRestaurant.cooksFood();
		
		ChineseRestaurant cr;
		
		// Encapsulation
		
		cr = (ChineseRestaurant) chineseRestaurant; 
		cr.addToMenu("General T'so Chicken");
		System.out.println("Menu" + cr.getMenu());
	}

}
