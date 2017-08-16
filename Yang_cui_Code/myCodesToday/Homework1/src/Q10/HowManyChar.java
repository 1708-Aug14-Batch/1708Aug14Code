package Q10;

public class HowManyChar {
	public static void main(String[] args){
		int count=0;
		for(String element : args){
			count=count+element.length();
		}
		System.out.println(count);
	}
}
