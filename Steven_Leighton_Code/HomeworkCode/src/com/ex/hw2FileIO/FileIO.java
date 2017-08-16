package com.ex.hw2FileIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIO {

	/*
	 * we will use the data Input and Output streams for an example
	 * importance of these types:
	 * 	able to translate primitives types into data streams that can
	 * 	be transferred between places
	 */
	
	//file name
	static String filename = "src/com/ex/hw2FileIO/output.txt"; 
	
	public static void main(String[] args) {
	
		/*
		 * Start by opening the output stream that we write data to,
		 * using a try/catch to handle exceptions thrown
		 */
		try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(filename))){
			
			//write to output stream
			dataOut.writeDouble(100);
			dataOut.writeBoolean(false);
			dataOut.writeChar('g');
			dataOut.writeInt(25);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Reading data from the same file
	      try(DataInputStream dataIn = new DataInputStream(new FileInputStream(filename))) {

			  while(dataIn.available()>0) {
				  //important to note that to you must read them the order they were output
			     double a = dataIn.readDouble();
				 boolean b = dataIn.readBoolean();
				 char c = dataIn.readChar();
				 int d = dataIn.readInt();
				 System.out.println(a + "\n" +
						 			b + "\n" + 
						 			c + "\n" +
						 			d + "\n");
			  }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
