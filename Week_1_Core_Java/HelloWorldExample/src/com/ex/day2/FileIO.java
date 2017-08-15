package com.ex.day2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class FileIO {
	static String filename = "src/com/ex/files/log.txt";
	public static void main(String[] args) {
		writeMessage("Hello Andrew");
		readMessage();
	
	}

	static void writeMessage(String message) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		try(BufferedWriter bw = 
				new BufferedWriter(new FileWriter(filename,false));){ //If it true, rerunning concats. False rewrites it. Boolean append
			bw.write(time + ": " + message + "\n");
		
		}	catch(IOException e) {
			e.printStackTrace();
		}
	}
	static ArrayList<String> readMessage() {
		ArrayList<String> messages = new ArrayList<String>();
		try(BufferedReader rw =
				new BufferedReader(new FileReader(filename));){
			String line = null;
			while((line = rw.readLine())!= null) {
					messages.add(line);
					System.out.println(line);}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
