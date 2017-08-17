package com.hw.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {
	
	static String filename = "src/com/hw/q20/Data.txt";
	
	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line=br.readLine()) != null) {
				String[] states = line.split(":");
				System.out.println("Name: "+states[0] + " " + states[1]);
				System.out.println("Age: "+states[2] + " years");
				System.out.println("State: "+states[3] + " State");
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
