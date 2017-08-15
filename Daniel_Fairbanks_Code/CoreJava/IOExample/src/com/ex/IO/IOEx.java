package com.ex.IO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOEx {

	static String filename = "src/com/ex/IO/log.txt";
	public static void main(String[] args) {
		Date dNow = new Date( );
	    SimpleDateFormat ft = 
	    new SimpleDateFormat ("E MM/dd/yyyy");
	    writeMessage(ft.format(dNow)+": Hello World!");
	    readMessage();
	}
	static void writeMessage(String message) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename,false));){
			bw.write(message + "\n");
			System.out.println("DONE");
		} catch (IOException e) {
			System.out.println("IO ERROR");
		}
	}
	static void readMessage()
	{
		try (BufferedReader br = new BufferedReader(new FileReader(filename));)
		{
			System.out.println(br.readLine());
		} catch (IOException e) {
			System.out.println("IO ERROR");
		}
	}
}
