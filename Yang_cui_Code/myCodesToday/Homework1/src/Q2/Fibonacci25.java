package Q2;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci25 {
	
	public static void main(String[] args){
		new Fibonacci25();
	}
	
	public Fibonacci25(){
		List<Integer> fib25 =new ArrayList<Integer>();
		fib25.add(1);
		fib25.add(1);
		
		for(int i=1; i<=25; i++)
			fib25.add(fib25.get(i)+fib25.get(i-1));
		
		for(int i=0; i<fib25.size(); i++)
			System.out.println(fib25.get(i));
	}
}
