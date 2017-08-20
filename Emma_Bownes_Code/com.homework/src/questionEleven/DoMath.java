package questionEleven;

//import questionElevenA;

public class DoMath {
	
	public static float sum(float a, float b) {
		Float A = a;
		Float B = b;
		return(Float.sum(A, B));
	}
	
	public static float multiply(float a, float b) {
		Long A = (long)a;
		Long B = (long)b;
		
		return Math.multiplyExact(A, B);
	}
	
	public static float distance(int time, float velocity) {
		float a = (float)time;

		return multiply(a, velocity);
	}
	
	public static float getVelocityChange(int time, float acceleration) {
		
		float timeF = (float)time;
		float velocity = multiply(acceleration,timeF);
		return velocity;
		
	}
	
	public static void main(String[] args) {
		
	float mass = questionElevenA.StoreFloats.mass;
	float acceleration = questionElevenA.StoreFloats.acceleration;
	
	System.out.println("Here we will find the approximate velocity of a dropped rock after 5 seconds");
	float v = getVelocityChange(5, acceleration);
	System.out.println(v);
	
	System.out.println("If the rock continues at the velocity for 12 seconds it will fall approximately "+distance(12, v)+" meters");
	
	System.out.println("The force of the 20g rock as it falls is approximately: ");
	System.out.println(multiply(mass,acceleration));
	}
	
	
}
