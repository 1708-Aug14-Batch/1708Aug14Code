package com.ex.day2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
public class FileIO {
	static String filename = "src/com/ex/files/log.txt";
	static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	public static void main(String[] args) {
		writeMessage("Hello Jathmel");


	}
	static void writeMessage(String message){
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){
			bw.write(timestamp + " " + message + "\n");
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
