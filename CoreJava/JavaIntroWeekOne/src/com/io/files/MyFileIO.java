package com.io.files;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class MyFileIO {
	static String filename = "src/com/io/files/log.txt";
	
	public static void main(String[] args) {
		writeMessage("Hello Emma!");
		makeTime();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			String IRead = br.readLine();
			System.out.println(IRead);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}
	
	static void writeMessage(String message) {
		try(BufferedWriter bw = 
				new BufferedWriter(
						new FileWriter(filename,false));){
			bw.write(makeTime() + ": " + message + "\n");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
				
		
	}
	
	static String makeTime() {
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		String time = now.toString();
		return time;	
	}
//	static String makeFormatTime() {
//		SimpleDateFormat time = new	SimpleDateFormat(, locale)
//	}
	

}
