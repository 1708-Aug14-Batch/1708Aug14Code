package com.hw.breeds;

import com.hw.mammals.Dog;

/*
 * Below is a class called Boxer that is a child class of the class Dog.
 * This is called INHERITANCE.
 * The child class Boxer is a specialization of the super class Dog.
 * The child class can use the parent's methods or define its own.
 */
public class Boxer extends Dog{

	private float weight = 63.0f;
	private float height = 23.0f;
	private String color = "fawn";
	
	/*
	 * This class uses a constructor, but is defined in two separate ways.
	 * This is a form of POLYMORPHISM.
	 * The constructor takes on two forms: one where no arguments are provided
	 * and another that accepts three arguments(weight, height, and color).
	 * This is called method overloading.
	 */
	public Boxer () {};
	
	public Boxer(float weight, float height, String color) {
		this.weight = weight;
		this.height = height;
		this.color = color;
	}
	
	/*
	 * The following method is a form of POLYMORPHISM.
	 * Because the super class Dog already defines a sleep method and here the child is creating its own
	 * sleep method the class will use its own definition. This is called method overriding.
	 */
	public void sleep() {
		System.out.println("The boxer is snoring while asleep.");
	}

	/*
	 * The following code are Getters and Setters.
	 * Through making the class's variables private they are no longer accessable from outside the class.
	 * Instead Getters/Setters use ENCAPSULATION to hide the details from the user.
	 */
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
}
