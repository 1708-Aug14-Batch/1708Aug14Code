package questionSix;

public class CheckEven {
	
	public static void even(int n) {
		int x = n -2;
		if(x>0) {
			//if x>0, this will recursively call itself again
			even(x);
		}
		else if(x==0){
			System.out.println("This number is even");
		}
		else {
			System.out.println("This number is odd");
		}
	}
	
		
	public static void main(String[] args) {
		even(8);
		even(90);
		even(7);
	}

}
