package com.ex.IO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IOEx {

	static String filename = "src/com/ex/IO/log.txt";
	static String filename2 = "src/com/ex/IO/logfile.txt";
	public static void main(String[] args) {
		Date dNow = new Date( );
	    SimpleDateFormat ft = 
	    new SimpleDateFormat ("E MM/dd/yyyy HH:mm:ss");
	    writeMessage(ft.format(dNow)+": Hello! This was written/read buffered!");
	    readMessage();
	    writeMessageUnbuffered(ft.format(dNow)+": Hello this was written/read unbuffered!");
	    readMessageUnbuffered();
	}
	
	static void writeMessage(String message) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename,false));){
			bw.write(message + "\n");
			System.out.println("DONE");
		} catch (IOException e) {
			System.out.println("IO ERROR");
		}
	}
	
	static void readMessage() {
		try (BufferedReader br = new BufferedReader(new FileReader(filename));)
		{
			System.out.println(br.readLine());
		} catch (IOException e) {
			System.out.println("IO ERROR");
		}
	}
	
	static void writeMessageUnbuffered(String message) {
		byte data[] = message.getBytes();
	    Path p = Paths.get(filename2);

	    try (OutputStream out = new BufferedOutputStream(
	      Files.newOutputStream(p))){//, CREATE, APPEND))) {
	      out.write(data, 0, data.length);
	    } catch (IOException x) {
	      System.err.println(x);
	    }
	}
	
	static void readMessageUnbuffered() {
		Path file = Paths.get(filename2);
		try (InputStream in = Files.newInputStream(file);
		    BufferedReader reader =
		      new BufferedReader(new InputStreamReader(in))) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		    }
		} catch (IOException x) {
		    System.err.println(x);
		}
	}
}
