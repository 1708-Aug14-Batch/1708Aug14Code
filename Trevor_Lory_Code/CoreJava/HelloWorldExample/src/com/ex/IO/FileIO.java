package com.ex.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FileIO {

	public static void main(String[] args) {
		String filename = "src/com/ex/files/log.txt";
		writeTimedMessage(filename, "Hello this is writing to file for time\n");
	}
	
	static void writeMessage(String FileName, String message) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FileName, true))) { //true is for concatenating, false is for flushing
			bw.write(message);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static void writeTimedMessage(String FileName, String message) {
		//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FileName, true))) { //true is for concatenating, false is for flushing
			bw.write(ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME) + " : " + message);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(FileName))) {
			String temp = br.readLine();
			System.out.println("Read in first line : " + temp);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
