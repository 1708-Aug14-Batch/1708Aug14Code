import java.util.Timer;

public class Main {

	public static void main(String[] args) {
		Timer timer = new Timer();
		MyTask myTask = new MyTask();
		timer.scheduleAtFixedRate(myTask, 0, 5000);
	}

}
