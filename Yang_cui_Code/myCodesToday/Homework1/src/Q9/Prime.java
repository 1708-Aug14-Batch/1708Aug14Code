package Q9;

import java.util.ArrayList;
import java.util.List;

public class Prime {
	public static void main(String[] args){
		new Prime();
	}
	
	public Prime(){
		List<Integer> numbers= new ArrayList<Integer>();
		List<Integer> prime= new ArrayList<Integer>();
		
		for(int i=1; i<=100; i++)
			numbers.add(i);
		
		for(int i=0; i<numbers.size(); i++)
			if(isPrime(numbers.get(i)))
				prime.add(numbers.get(i));
		
		for(int i=0; i<prime.size(); i++)
			System.out.println(prime.get(i));
	}
	
	public boolean isPrime(int number){
		if(number==1)
			return true;
		else
		{
			for(int i=2; i<number; i++)
				if(number%i==0)
					return false;
				else;
			return true;
		}
	}
}
