package com.hw.week01.q15;

public class Operations implements Operable {

	@Override
	public int addition(int operand1, int operand2) {
		return operand1 + operand2;
	}

	@Override
	public int substraction(int operand1, int operand2) {
		return operand1 - operand2;
	}

	@Override
	public int multiplication(int operand1, int operand2) {
		return operand1 * operand2;
	}

	@Override
	public double division(double operand1, double operand2) {
		return operand1 / operand2;
	}

}
