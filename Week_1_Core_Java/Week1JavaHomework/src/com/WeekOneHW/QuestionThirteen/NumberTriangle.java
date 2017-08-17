package com.WeekOneHW.QuestionThirteen;

public class NumberTriangle {

	public static void main(String[] args) {
		int counter = 1, max = 1; //Variables used to step through the triangle. Counter steps through while Max is the max number of steps
		int numberSwitch = 0; //Variable used to output to the console
		do {
			if(numberSwitch == 0) { //If numberSwitch is 0 (which it is by default)
				System.out.print(0); //Print out 0
				numberSwitch = 1; //Then switch numberSwitch to 1
				counter++; //And increment the counter
			}
			else if(numberSwitch == 1) { //Same thing as above but with 1
				System.out.print(1);
				numberSwitch = 0;
				counter++;
			}
			if(counter > max) { //If the counter variable exceed max after the increment 
				max++; //Increment the max to repeat the process and add more steps.
				counter = 1; //Reset the counter to 1
				System.out.print("\n"); //Finally add a new line character
			}
		}while(max < 5); //Caps out the max lines at 4

	}

}
