package com.HW1.Q6;

public class Modul {

	public static void main(String[] args) {
		if(modul(128))
			System.out.println("Is Even");
	}
	
	public static boolean modul(int num) {
		if (((num>>>0) & 1) != 0) {
			return false;
		}
		return true;
	}
	
}
