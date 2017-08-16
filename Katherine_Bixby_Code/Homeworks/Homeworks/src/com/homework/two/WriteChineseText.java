package com.homework.two;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/*
 * This code is completely new. It writes a string of Chinese characters to a txt file.
 * I had to use an OutputStreamWriter this time to deal with writing UTF8 characters.
 * Because of this, if you try to open the txt files in Eclipse, it will look like absolute
 * jibberish. I recommend opening the text files in something like Notepad++ to see that they
 * are indeed text files with actual Chinese characters!
 */

public class WriteChineseText {
	
	static String filename = "src/com/homework/two/chinese.txt";	// setting the file directory to write to
	static File fileDir = new File(filename);
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		writeMessage("你好我是边凯蒂");	// Here I am saying that my name is Bian Kaidi (which is my Chinese name!)
	}
	
	static void writeMessage(String message) throws UnsupportedEncodingException  {
		try {
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileDir), StandardCharsets.UTF_8);
			writer.write(message);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
