package com.HW.HomeWorkWeek1Day1;

public class MainTest {

	public static void main(String[] args) {
		Hippo bob = new Hippo(4);
		System.out.println("Hippos Leg Amount:" + bob.getLegs());
		//PolyMorphism is used here by instantiating Animals as a Hippo
		Animals Pol = new Hippo(42);
		Pol.eat();
	}
	
}
