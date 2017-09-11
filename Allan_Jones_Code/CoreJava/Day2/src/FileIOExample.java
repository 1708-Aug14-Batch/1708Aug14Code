

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class FileIOExample {
	static String filename = "src/com/ex/files/log.txt";
	static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	public static void main(String[] args) {
		//writeMessage("Hello Genesis!");
		//readMessage();
		readMessage2();
		
	}
	
	static void writeMessage(String message) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true));) {
			bw.write(timestamp + " " + message + "\n");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void readMessage() {
		String sCurrentLine;
		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static ArrayList<String> readMessage2() {
		ArrayList<String> messages = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line = br.readLine()) != null) {
				messages.add(line);
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

	
	
	
	
	
	
	
	
	