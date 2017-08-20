package question18;

public class Dog extends Animal {

	public Dog(final int theNumberOfLegs, final String theHairColor, final String theName,
			final String theLocation, final int theNumberOfDogs, final int thePopulation ) {
		super(theNumberOfLegs, theHairColor, theName, theLocation, theNumberOfDogs, thePopulation);
	}

	public void calculateNumberAnimals(int animal, int population) {
		int numberOfAnimals = (animal * population)/10;
		System.out.println("The Number of animals:" + numberOfAnimals);

	}

	@Override
	public boolean isAnimal(int legs) {
		if(legs >= 2){
			return true;
		}
		return false;

	}

	@Override
	public String getMyLocation() {

		return getMyLocation();
	}

	public boolean isUpper(String s) {

		if(s.toUpperCase().equals(s)){
			return true;
		}

		return false;
	}

	@Override
	public String convertToLowerCase(String s) {

		return s.toUpperCase();
	}

	@Override
	public int convertStringtoInt(String s) {
		int result = 0;
		for(int i = 0; i < s.length(); ++i) {
			char ch = s.charAt(i);
			if (!s.isEmpty()) {
				result = (int)ch - (int)'a' + 1;		   // t += String.valueOf(result);

			}
		}
		return result + 10;

	}
}




