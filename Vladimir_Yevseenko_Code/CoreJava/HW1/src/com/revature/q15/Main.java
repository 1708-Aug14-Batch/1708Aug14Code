package com.revature.q15;

public class Main {
	public static void main(String[] args) {
		NumberContainer nc1 = new NumberContainer((short) 5, 100, 2500, 8.6f, 3.14);
		NumberContainer nc2 = new NumberContainer((short) 40, 259, 69420, 100.05f, 29.29);
		
		NumberContainer added = nc1.add(nc2);
		NumberContainer subtracted = nc1.subtract(nc2);
		NumberContainer multiplied = nc1.multiply(nc2);
		NumberContainer divided = nc1.divide(nc2);
		
		System.out.println("Originals:");
		System.out.printf("nc1: s = %d i = %d l = %d f = %f d = %f\n", nc1.getS(), nc1.getI(),
				nc1.getL(), nc1.getF(), nc1.getD());
		System.out.printf("nc2: s = %d i = %d l = %d f = %f d = %f\n\n", nc2.getS(), nc2.getI(),
				nc2.getL(), nc2.getF(), nc2.getD());
		
		System.out.printf("added: s = %d i = %d l = %d f = %f d = %f\n", added.getS(), added.getI(),
				added.getL(), added.getF(), added.getD());
		System.out.printf("subtracted: s = %d i = %d l = %d f = %f d = %f\n", subtracted.getS(), 
				subtracted.getI(), subtracted.getL(), subtracted.getF(), subtracted.getD());
		System.out.printf("multiplied: s = %d i = %d l = %d f = %f d = %f\n", multiplied.getS(), 
				multiplied.getI(), multiplied.getL(), multiplied.getF(), multiplied.getD());
		System.out.printf("divided: s = %d i = %d l = %d f = %f d = %f\n", divided.getS(), divided.getI(),
				divided.getL(), divided.getF(), divided.getD());
	}
}