package Q20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

	public static String fromFile(String filename) {

		String ret = "";

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.split(":");
				if (words.length == 4) {
					ret += "Name: " + words[0] + ' ' + words[1] + '\n';
					ret += "Age: " + words[2] + " years\n";
					ret += "State: " + words[3] + " State\n\n";
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return ret;
	}

	public static void main(String[] args) {

		System.out.println(fromFile("src/Q20/data.txt"));
	}
}