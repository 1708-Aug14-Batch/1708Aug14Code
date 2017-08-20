package question17;

import java.util.Scanner;

/**
 * . Write a program that calculates the simple interest on the principal, rate
 * of interest and number of years provided by the user. Enter principal, rate
 * and time through the console using the Scanner class. Interest = Principal*
 * Rate* Time
 * 
 * @author josh wurdemann
 * @version 8/20/2017
 *
 */
public class CalculateInterest {
	private final float myPrinciple;
	private final float myRate;
	private final float myTime; // in years
	
	
	public CalculateInterest(final float thePrinciple, final float theRate, final float theTime) {
		myPrinciple = thePrinciple;
		myRate = theRate;
		myTime = theTime;

	}
	
	
	public float getMyPrinciple() {
		return myPrinciple;
	}

	public float getMyRate() {
		return myRate;
	}

	public float getMyTime() {
		return myTime;
	}

	public float simpleInterestCalculator(float principle, float rate, float time) {
		float simpleInterest = principle * rate * time;
		System.out.println("The simple interest is:" + "$" + simpleInterest);
		return simpleInterest;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Pleaser enter Principle Amount");
		float amount = in.nextFloat();

		System.out.println("Pleaser enter the Rate you would like to earn your investment");
		float rate = in.nextFloat();

		System.out.println("Pleaser enter the number of years you would like to keep your invest");
		float time = in.nextFloat();
		CalculateInterest interest = new CalculateInterest(amount, rate, time);

		// simpleInterestCalculator(amount, rate, time);
		interest.simpleInterestCalculator(interest.getMyPrinciple(), interest.getMyRate(), interest.getMyTime());
		in.close();
	}

}
