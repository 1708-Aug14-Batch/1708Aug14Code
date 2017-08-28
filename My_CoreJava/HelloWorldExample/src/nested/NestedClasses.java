package nested;

public class NestedClasses {
	
	/*
	 * Benefits:
	 * - logical grouping of classes only used in one place
	 * - increases encapsulation
	 * - more readable and maintanable code
	 * 
	 * Types:
	 * - static - declared as a static member of another class
	 * 
	 */
	
	private int a = 2;
	private static int b = 5;
	
	static class StaticClass {
		void message() {
			System.out.println("inner class");
			System.out.println(b);
		}
	}
	
	class MemberClass {
		void message() {
			System.out.println("member class");
			System.out.println(a + b);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("main");
		
		class localClass {
			void message() {
				System.out.println("local class");
				System.out.println(b);
			}
		}
		
		// Practical example of anonymous class
		Runnable run = new Runnable() {

			@Override
			public void run() {
				System.out.println("doing things in new thread");
			}		
		};
		
		run.run();
	}
	
	MyInterface anonClass = new MyInterface() {

		@Override
		public void doThings() {
			System.out.println("anonymous things");
		}

		@Override
		public void doOtherThings() {
			System.out.println("anonymous other things");
		}		
	};
}

interface MyInterface {
	void doThings();
	void doOtherThings();
}

class Other {
	
}
