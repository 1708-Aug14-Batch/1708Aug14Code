package com.ex.day2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	static String filename = "src/com/ex/files/log.txt";
	public static void main(String[] args) {
		
		writeMessage("Hello Genesis!");
	}
	
	
	static void writeMessage(String message){
		
		try(BufferedWriter bw = 
				new BufferedWriter(
						new FileWriter(filename,false));){
			bw.write(message + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
