package com.hw.problem20;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Split {
	public static void main(String[] args) {
		String filename = "src/com/hw/problem20/Data.txt";
		
		try (Scanner s = new Scanner(new File(filename))) {
			
			while (s.hasNextLine()) {
				String[] fields = s.nextLine().split(":");
				System.out.println("Name: " + fields[0] + " " + fields[1]);
				System.out.println("Age: " + fields[2] + " years old");
				System.out.println("State: " + fields[3] + "\n");
				
			}
		} catch (IOException e) {
			
			e.printStackTrace();			
		}
	}

}
