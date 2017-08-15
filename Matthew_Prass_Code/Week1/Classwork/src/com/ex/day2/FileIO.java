package com.ex.day2;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileIO {

	static String filename = "src/com/ex/files/log.txt";
	public static void main(String[] args) {
		
		writeMessage("testinggg");
		readMessage();
		
	}
	
	static void writeMessage(String message)
	{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename,true)))
		{
			String date = new SimpleDateFormat("MM/dd/yyyy HH:mm.ss").format(new Date());
			bw.write(date + ": " +message + "\n");	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
				//edit
		
	}
	
	static ArrayList<String> readMessage()
	{
		ArrayList<String> messages = new ArrayList<String>();
		try(BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			String temp = "";
			temp = br.readLine();
			System.out.println(temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
