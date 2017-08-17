package Day3;

import Day3.NestedClass.MyInterface;

/**
 *  Java allows us to write classes within other classes, these are called nested classes
 *  Benefits:
 *  - logical grouping of classes only used 
 *  in one place
 *  - logical grouping of classes only used
 *  in one place
 *  -increases encapsulation
 *  - more readable and maintatibe code
 *  Types:
 *  - staci - declared as a static member
 *  of another class
 * @author joshw
 * 
 */
public class NestedClass {

 int a = 0;
 static int b = 0;
/**
 *
 * @author joshw
 *
 */
static  class staticClass{
	void message(){
		System.out.println("hi my name is jr");
		System.out.println(b);
	}
}
class memberClass{
	void message(){
		System.out.println("hi my name is jr");
		System.out.println(a + b);
	}
}
 public static void main(String[] args) {
	System.out.println("jyo");
	class localClass{
		void message(){
			System.out.println("inside local class");
			System.out.println(b);

		}
	}
	 MyInterface annonclass = new MyInterface(){

		@Override
		public void doThings() {
			System.out.println("hi");
			
		}

		@Override
		public void doOtherthings() {
			
			System.out.println("hi");
		}
		    
		  
		 
	  };
}
	 interface MyInterface{
		  void doThings();
		  void doOtherthings();
	  }
 class Other{
	 int a;
	 String message;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
 }
}
