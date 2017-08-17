package com.revature.q20;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileInput {
	public static void main(String[] args) {
		try (Scanner s = new Scanner(new File("src\\com\\revature\\q20\\Data.txt"))) {
			while (s.hasNextLine()) {
				String[] fields = s.nextLine().split(":");
				System.out.println("Name: " + fields[0] + " " + fields[1]);
				System.out.println("Age: " + fields[2] + " years old");
				System.out.println("State: " + fields[3] + "\n");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}
}
