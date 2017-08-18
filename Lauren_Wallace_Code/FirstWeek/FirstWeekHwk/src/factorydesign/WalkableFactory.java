package factorydesign;

public class WalkableFactory {

	//use getWalkable method to get an object of type Walkable
	public Walkable getWalkable(String walkableType) {
		if(walkableType == null) {
			return null;
		}
		if(walkableType.equalsIgnoreCase("DOG")) {
			return new Dog();
		}
		else if(walkableType.equalsIgnoreCase("PERSON")) {
			return new Person();
		}
		return null;
	}
}
