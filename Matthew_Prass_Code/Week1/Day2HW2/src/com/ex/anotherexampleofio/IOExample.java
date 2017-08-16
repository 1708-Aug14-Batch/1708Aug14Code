package com.ex.anotherexampleofio;

import java.io.*;
public class IOExample {
	
	static PipedWriter pw = new PipedWriter();
	static PipedReader pr = new PipedReader();
	//static String filename = "src/com/ex/files/log.txt";
	//thought piped reader/writer was pretty interesting...
	public static void main(String[] args){
		
		
		//reader must be connected to writer
		try {
			pr.connect(pw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		writePipe();
		readPipe();
	}
	
	//write from pipe
	static void writePipe()
	{
		try {
			for(int i = 65;i<=70; i++)
			{
				pw.write((char)i);
			}
			pw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//read from pipe (requires a PipeWriter)
	static void readPipe()
	{
		try {
			int i;
			while((i = pr.read()) != -1)
			{
				System.out.println((char)i);
			}
			pr.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	

}
