package com.ex.day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class readAndWriteWithoutBuffering {

	public static void main(String[] args){
		try{
			FileReader reader = new FileReader("src/com/ex/Files/log.txt");
			FileWriter writer = new FileWriter("src/com/ex/Files/log2.txt",true);
			writer.write("Hello World");
			writer.write("\r\n");
			writer.write("Good Bye!");
			writer.close();
			int character;
			while ((character = reader.read())!= -1){
				System.out.print((char)character);
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}

