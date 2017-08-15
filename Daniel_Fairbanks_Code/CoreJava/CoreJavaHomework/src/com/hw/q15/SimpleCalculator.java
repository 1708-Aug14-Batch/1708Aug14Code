package com.hw.q15;

public class SimpleCalculator implements CalculatorInterface {

	public float addition(float val1, float val2) {
		return val1 + val2;
	}

	public float subtraction(float val1, float val2) {
		return val1 - val2;
	}

	public float multiplication(float val1, float val2) {
		return val1 * val2;
	}

	public float division(float val1, float val2) {
		return val1 / val2;
	}
}
