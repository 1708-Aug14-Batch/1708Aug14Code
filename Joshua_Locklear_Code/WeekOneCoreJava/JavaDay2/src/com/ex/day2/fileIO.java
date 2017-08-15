package com.ex.day2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class fileIO {
static String filename = "src/com/ex/Files/log.txt";
	public static void main(String[] args) {
		writeMessage("Hello World");
		//Date date = new Date();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		writeMessage(timeStamp);
		

	}
	
	static void writeMessage(String message){
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));){
			bw.write(message +"\n");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
