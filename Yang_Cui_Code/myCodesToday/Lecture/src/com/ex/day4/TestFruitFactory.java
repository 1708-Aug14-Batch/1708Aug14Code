package com.ex.day4;

public class TestFruitFactory {
	
	public static void main(String[] args){
		FruitFactory ff = new FruitFactory();
		Fruit f1 = ff.getFruit("APPLE");
		Fruit f2 = ff.getFruit("ORANGE");
		Fruit f3 = ff.getFruit("GRAPE");
		Fruit f4 = ff.getFruit("H2OMELLON");
		
		f1.color();
		f1.volume();
		f1.zone();
		
		System.out.println("=============================");
		
		f2.color();
		f2.volume();
		f2.zone();
		System.out.println("=============================");
		f3.color();
		f3.volume();
		f3.zone();
		System.out.println("=============================");
		f4.color();
		f4.volume();
		f4.zone();
	}
}
