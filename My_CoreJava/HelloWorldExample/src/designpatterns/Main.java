package designpatterns;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		singleton.hello();
		singleton.count = 10;
		System.out.println(singleton.count);
		Singleton another = Singleton.getInstance();
		System.out.println(another.count);
		
		ToolFactory factory = new ToolFactory();
		Scanner in = new Scanner(System.in);
		
		System.out.println("What tool?");
		String toolName = in.nextLine();
		
		ToolBox t = factory.workWithTool(toolName);
		System.out.println(t.workWithTool());
	}
}
