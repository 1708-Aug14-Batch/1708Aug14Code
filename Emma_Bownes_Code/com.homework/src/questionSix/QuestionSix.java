package questionSix;

public class QuestionSix {
	
	public static void even(int n) {
		int x = n -2;
		if(x>0) {
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
		even(6);
		even(5);
		even(24);
	}

}
