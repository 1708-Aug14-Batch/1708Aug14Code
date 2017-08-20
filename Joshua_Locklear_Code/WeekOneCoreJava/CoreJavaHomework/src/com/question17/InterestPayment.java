package com.question17;

public class InterestPayment{
	public double Payment(double userPrinc, double userRate, int userTime) {
		double interest = userPrinc * userRate * userTime;
		return interest;
	}
}