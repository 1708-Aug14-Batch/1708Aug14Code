package factorydesign;

public class FactoryDesignExample {

	public static void main(String[] args) {
		WalkableFactory walkables = new WalkableFactory();
		
		Walkable dog = walkables.getWalkable("DOG");
		dog.walk();
		
		System.out.println();
		
		Walkable person = walkables.getWalkable("PERSON");
		person.walk();

	}

}
