package com.homework.two;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/*
 * Okay, so I know this looks like it's a buffered reader. But look, there's an
 * InputStreamReader in there, because this is reading Chinese characters,
 * which can only be accessed through UTF8. This is altered from my senior year research.
 */
public class ParseChineseText {
	public static void main(String[] args) throws UnsupportedEncodingException {
        
        File fileDir = new File("src/com/homework/two/E2.txt"); // Create a File index to read from
        BufferedReader in = null;	// Establish the BufferedReader
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8")); // Reading in with UTF8
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()){	// Print out all the lines in the document
        	String sent = scanner.next();
        	System.out.println(sent);
        }
        scanner.close();	// close the scanner
        try {	// close the reader
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
}