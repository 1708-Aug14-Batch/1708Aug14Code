package Q13;

import java.util.ArrayList;
import java.util.List;
import Q9.Prime;

public class NumTrickThreeSome {
	public static void main(String[] args){
		new NumTrickThreeSome();
	}
	
	public NumTrickThreeSome(){
		List<Integer> intgers = new ArrayList<Integer>();
		for(int i=1; i<=100; i++)
			intgers.add(i);
		System.out.println(addEven(intgers));
		System.out.println(addOdd(intgers));
		System.out.println(removePrime(intgers));
	}
	
	public int addEven(List<Integer> intgers){
		int sum=0;
		for(int i=0; i<intgers.size(); i++)
			if(intgers.get(i)%2==0)
				sum +=intgers.get(i);
		return sum;
	}
	
	public int addOdd(List<Integer> intgers){
		int sum=0;
		for(int i=0; i<intgers.size(); i++)
			if(intgers.get(i)%2==0);
			else
				sum +=intgers.get(i);
		return sum;
	}
	
	public List<Integer> removePrime(List<Integer> intgers){
		Prime p =new Prime();
		List<Integer> removeThese = new ArrayList<Integer>();
		for(int i=0; i<intgers.size(); i++)
			if(p.isPrime(intgers.get(i)))
				removeThese.add(i);
		for(int i=0; i<removeThese.size(); i++)
			intgers.remove(removeThese.get(i));
		return intgers;
	}
}
