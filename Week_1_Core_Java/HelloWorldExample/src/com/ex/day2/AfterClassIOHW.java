package com.ex.day2;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import java.io.PrintWriter;


public class AfterClassIOHW {

	
	public static void main(String[] args) {
		testWrite("This is a test of the PrintWriter! And this is a second test that " //Test Write function call
				+ "overwrites the previous text.");
		testRead(); //Test read function call

	}
	
	static void testWrite(String testMessage) { //The testWrite function that has a String as an argument
		
		/*
		 * Sets up a try/catch block for the Writer I used for this example, PrintWriter.
		 * Printer seems to be easier to implement, although you cannot specify if you want it overridden or not.
		 * It will always override every time you run the code.
		 * Afterwards I needed to flush and close the writer.
		 */
		try {
			PrintWriter writer = new PrintWriter(new File("src/com/ex/files/testlog.txt"));
			writer.write(testMessage);
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	static void testRead(){ //The testRead function with no argument
		/*
		 * For my example here I used the FileReader.
		 * Again, it is a little easier to implement.
		 * The big difference between it and BufferedReader is that I needed to use an int-
		 * -to read the file to the output. So I had to cast it to a char to make it work.
		 */
		
		try {
			FileReader fr = new FileReader("src/com/ex/files/testlog.txt");
			int line;
			while((line = fr.read())!= -1) {
				System.out.print((char)line);
			}
			fr.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}

