package question18;

import java.util.Scanner;

public class AnimalApp  {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
			
		Dog newDog = new Dog(3, "Blue", "beagal", "France", 10, 5000 );
		
		/**Testing to see if methods work*/
		System.out.println(newDog.isUpper(newDog.getMyName()));
		System.out.println(newDog.convertToLowerCase(newDog.getMyName()));
		System.out.println(newDog.convertStringtoInt(newDog.getMyName()));
		
		
		
//		
//		if(newDog.isAnimal(newDog.getMyNumberOfLegs())){
//		System.out.println(newDog);
//		}
//		System.out.println("Please enter number of dogs in your city");
//		int numbDogs = in.nextInt();
//		newDog.setMyNumberOfDogs(numbDogs);
//		System.out.println("Please enter the poplation of your city");
//		int population = in.nextInt();
//		
//		newDog.setMyPopulation(population);
//		newDog.calculateNumberAnimals(newDog.getMyNumberOfDogs(), newDog.getMyPopulation());
//		
//		System.out.print(newDog.getMyLocation());
//		
//		
//		
//		
		in.close();
		
		
		
		
	}
}
