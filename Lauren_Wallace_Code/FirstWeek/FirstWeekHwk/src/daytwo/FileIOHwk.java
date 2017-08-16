package daytwo;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class FileIOHwk {

	public static void main(String[] args) {
		//files are created upon running the program
		String filename = "src/com/ex/files/hwk.txt";
		String file2 = "src/com/ex/files/f2.txt";
		
		//need to try the following code in case it produces an
		//exception during runtime
		try {
			PrintStream printstr = new PrintStream(filename);
			PrintWriter printwtr = new PrintWriter(file2);
			char[] s = {'c','a','a','t'};
			char[] t = {'t','a','a','r'};
			
			printstr.print(s);
			printstr.print(t);
			//PrintStream does not need these methods to print
			//the character arrays however, it does not hurt to have them
			printstr.flush();
			printstr.close();
			
			printwtr.append('c');
			//PrintWriter needs these methods to successfully
			//append the char 'c' to the letter
			printwtr.flush();
			printwtr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
