package com.ex.day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileIO {
	
	static String filename = "src/com/ex/files/log.txt";
	
	public static void main(String[] args) {
		
		Date date = new Date();
		Timestamp time = new Timestamp(0);
		Scanner scan;
		
		readMessage();
		
		try {
			scan = new Scanner(Paths.get(filename));
			writeMessage("Hello Genesis!" + date + time);
		while (scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	static void writeMessage(String message) {
		
		try (BufferedWriter bw = new BufferedWriter (new FileWriter(filename, true));) { 
			bw.write(message + "\n");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static ArrayList<String> readMessage() {
		ArrayList<String> messages = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while((line=br.readLine()) != null) {
				messages.add(line);
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
