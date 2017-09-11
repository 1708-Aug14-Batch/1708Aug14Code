package OOP_principles;

public class TestAnimals {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Ape ape = new Ape();
		Dog dog = new Dog();
		
		System.out.println("      Cat      ");
		System.out.println("---------------");
		System.out.println("Legs: " + cat.noOfLegs);
		System.out.println("Tame: " + cat.isTame());
		System.out.println("Pet: " + cat.isPet());
		System.out.println("Food: " + cat.isFood());
		
		System.out.println();

		System.out.println("      Ape      ");
		System.out.println("---------------");
		System.out.println("Legs: " + ape.noOfLegs);
		System.out.println("Tame: " + ape.isTame());
		System.out.println("Pet: " + ape.isPet());
		System.out.println("Food: " + ape.isFood());

		System.out.println();
		
		System.out.println("      Dog      ");
		System.out.println("---------------");
		System.out.println("Legs: " + dog.noOfLegs);
		System.out.println("Tame: " + dog.isTame());
		System.out.println("Pet: " + dog.isPet());
		System.out.println("Food: " + dog.isFood());
		
		dog.setBreed("Beagle");
		System.out.println("Breed: " + dog.getBreed());
	}
	
}
