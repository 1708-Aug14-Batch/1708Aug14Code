package dayone;

public class Main {
	
	public static void main(String[] args) {
		
		//Item poorGame = new VideoGame();
		Item kingdomHearts3 = new VideoGame("Kingdom Hearts 3", 59.99, "Defeating the heartless!");
		VideoGame persona5 = new VideoGame("Persona 5", 59.99, "Becoming the master of your true self!");
		VideoGame horizonZeroDawn = new VideoGame();
		
		System.out.println(kingdomHearts3.getItemName() + " sells for " + kingdomHearts3.getPrice() + " and is about " + kingdomHearts3.getDescription());
		System.out.println(persona5.getItemName() + " sells for " + persona5.getPrice() + " and is about " + persona5.getDescription());
		
		System.out.println(horizonZeroDawn.getItemName() + " sells for " + horizonZeroDawn.getPrice() + " and is about " + horizonZeroDawn.getDescription());
		horizonZeroDawn.setPrice(25.00);
		System.out.println(horizonZeroDawn.getItemName() + " sells for " + horizonZeroDawn.getPrice() + " and is about " + horizonZeroDawn.getDescription());
		
		System.out.println("In 3 years the value of Kingdom Hearts 3 will be $" + kingdomHearts3.decreaseValue(3));
		System.out.println("In 2 years the value of Persona 5 will be $" + persona5.decreaseValue(2));
		
		horizonZeroDawn.priceCheck("Best Buy", 59.99, "Gamestop", 29.99);
		persona5.priceCheck("Target", kingdomHearts3.getPrice(), "Amazon", 39.99);
		
	}

}
