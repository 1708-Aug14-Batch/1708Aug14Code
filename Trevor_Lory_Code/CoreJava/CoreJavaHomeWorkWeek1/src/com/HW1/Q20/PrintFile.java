package com.HW1.Q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PrintFile {

	public static void main(String[] args) {
		ArrayList<String> st = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader("src/com/HW1/Q20/Data.txt"))) {
			String s;
			while((s = br.readLine()) != null) {
				st.add(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(String s : st) {
			String[] str = s.split(":");
			System.out.println("Name: " + str[0] + " " + str[1]);
			System.out.println("Age: " + str[2] + " years");
			System.out.println("State: " + str[3] + " State");
			System.out.println("");
		}
		
	}
	
}
