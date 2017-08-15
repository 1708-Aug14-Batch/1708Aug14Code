package com.ex.day2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

	static String filename = "src/com/ex/day2/log.txt";
	// Read from and right to a text file
	public static void main(String[] args) {
		
		writeMessage("Hello Genesis!");
	}
	static void writeMessage(String message) {
		try(BufferedWriter bw = 
				new BufferedWriter(
						new FileWriter(filename,true));){
			bw.write(message+"\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
