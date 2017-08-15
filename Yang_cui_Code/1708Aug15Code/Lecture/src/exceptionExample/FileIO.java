package exceptionExample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FileIO {
	static String filename="src/exceptionExample/log.txt";
	public static void main (String[] args){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String formattedDate = sdf.format(date);
		
		writeMessage("hellolplpl" + formattedDate);
	}
	
	static void writeMessage(String message){
		try(BufferedWriter bw=new BufferedWriter(new FileWriter(filename,true));){ // true = append false = overwrite
			bw.write(message+"\n");
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	/*static ArrayList<String> readMessage(){
		ArrayList<String> messages =new ArrayList<String>();
		try{(BufferedReader br=new BufferReader(new FileReader(filename));){
			String line=null;
			while((line=br.readLine())!=null){
				messages.add(line);
				System.out.println(line);
			}
	}catch (FileNotFoundException e){
		e.printStackTrace();
	}catch (IOException e){
		e.printStackTrace();
	}
	return null;
	}*/
}
