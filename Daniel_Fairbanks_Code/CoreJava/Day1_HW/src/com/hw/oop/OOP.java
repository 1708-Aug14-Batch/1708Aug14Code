package com.hw.oop;
import com.hw.mammals.*;
import com.hw.breeds.*;

public class OOP {

	public static void main(String[] args) {
		
		Dog goodboy = new Dog();
		goodboy.talk();
		goodboy.move();
		goodboy.sleep();
		goodboy.playCatch();
		Boxer moe = new Boxer(65.2f, 20.11f, "brindle");
		moe.sleep();
		System.out.println("Moe's weight: " + moe.getWeight());
		System.out.println("Moe's height: " + moe.getHeight());
		System.out.println("Moe's color : " + moe.getColor());
		Boxer lucy = new Boxer();
		lucy.talk();
		lucy.sleep();
		System.out.println("Lucy's weight: " + lucy.getWeight());
		System.out.println("Lucy's height: " + lucy.getHeight());
		System.out.println("Lucy's color : " + lucy.getColor());
		
	}

}
