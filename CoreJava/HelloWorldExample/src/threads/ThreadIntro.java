package threads;

public class ThreadIntro {
	
	public static void main(String[] args) {
		ExtendsThread et = new ExtendsThread();
		ImplementsRunnable ir = new ImplementsRunnable();
		
		Runnable lam = () -> {
			System.out.println("lambda expression");
		};
		
		Runnable anon = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println(i + " in AnonRunnable");
				}
			}
		};		
		
		Thread t1 = new Thread(ir);
		Thread t2 = new Thread(anon);
		Thread t3 = new Thread(lam);

		et.start();
		t1.start();
		t2.start();
		t3.start();
	}
}

// extends thread
class ExtendsThread extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " in ExtendsThread");
		}
	}
}

// implements runnable
class ImplementsRunnable implements Runnable {
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " in ImplementsRunnable");
		}
	}
}