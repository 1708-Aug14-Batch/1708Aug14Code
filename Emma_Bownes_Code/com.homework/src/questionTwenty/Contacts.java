package questionTwenty;

import java.io.*;

public class Contacts {
	static String filename = "src/questionTwenty/Data.txt";
	
	public static void write() {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename));){
			//creates writer
			bw.write("Mickey:Mouse:35:Arizona \n");
			bw.write("Hulk:Hogan:50:Virginia \n");
			bw.write("Roger:Rabbit:22:California \n");
			bw.write("Wonder:Woman:18:Montana \n");
			//writes each line to the file (I chose to do this through the program
			//as practice instead of just creating a text file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void read() {
		try(BufferedReader br = new BufferedReader(new FileReader(filename));){
			String line;
			while((line =br.readLine())!=null) {
				//will read the entire file one line at a time
				int sFirst = line.indexOf(":");
				int sLast = line.indexOf(":", sFirst+1);
				int sAge = line.lastIndexOf(":");
				//finds "stopping index" for each required piece of information
				//by finding the index of each ":"
				String first = line.substring(0, sFirst).trim();
				String last = line.substring(sFirst+1, sLast).trim();
				//sLast++;
				String age = line.substring(sLast+1, sAge).trim();
				//sAge++;
				String state = line.substring(sAge+1).trim();
				//retrieves the relevant part of the substring for each
				//piece of information
				System.out.println("Name: "+first+" "+last);
				System.out.println("Age: "+age+" years");
				System.out.println("State: "+state+" State");
				//Prints out information in desired format	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		write();
		read();
	}

}
