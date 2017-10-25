package lemur;

public class LemurMain {

	public static void main(String[] args) {
		Lemur lemur = new Lemur();
		System.out.println(lemur.age);
		
		HasTail hasTail = lemur;
		System.out.println(hasTail.isTailStriped()); // The reference type determines which methods can be called
													 // The object type determines which methods are called
													 // The HasTail reference type makes isTailStriped available for use
													 // But the Lemur object type makes the method return false
		
		Primate primate = lemur;
		System.out.println(primate.hasHair()); // Changing the reference type to Primate hides isTailStriped
											   // But it makes hasHair available for use
		
//		System.out.println(primate.age); // This is not possible. Even though the Lemur object has an age property
										 // It is impossible to call, because the reference type Primate
										 // Does not have an age property
	}

}
