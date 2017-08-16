package com.ex.FileExperiment;
import java.io.*;

public class FileInputandOutput {

	   public static void main(String args[]) throws IOException {  
	      FileInputStream input = null;
	      FileOutputStream output = null;

	      try {
	         input = new FileInputStream("src/com/ex/experimentfiles/input.txt");
	         output = new FileOutputStream("src/com/ex/experimentfiles/output.txt");
	         
	         int x;
	         while ((x = input.read()) != -1) {
	            output.write(x);
	         }
	      }finally {
	         if (input != null && output != null) {
	            input.close();
	            output.close();
	         }
	      
	      }
	   }
}
