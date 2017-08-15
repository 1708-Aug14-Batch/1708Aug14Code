package fourOOPPrinciples;

public abstract class Animal implements Living {
	
	protected String species;			// In Latin
	protected int averageLifespan;		// measured in years
	
	protected abstract void eat();
	
	protected void breathe() {
		System.out.println("The animal breathes deeply");
	};


	public String getSpecies() {
		return species;
	}

	public int getAverageLifespan() {
		return averageLifespan;
	}

}
