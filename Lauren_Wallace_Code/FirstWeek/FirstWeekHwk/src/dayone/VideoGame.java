package dayone;

public class VideoGame extends Item {
	
	//default constructor
	public VideoGame() {
		this.setItemName("Video Game");
		this.setPrice(39.99);
		this.setDescription("This is a generic video game!");
	}
	
	//overloads the default constructor since the parameters are different
	public VideoGame(String name, double price, String description) {
		this.setItemName(name);
		this.setPrice(price);
		this.setDescription(description);
	}

	@Override
	public void priceCheck(String store1, double price1, String store2, double price2) {
		//utilizes Item's priceCheck method which already has the code needed
		super.priceCheck(store1, price1, store2, price2); 
	}

	@Override
	public int decreaseValue(int years) {
		// TODO Auto-generated method stub
		int value = 100;
		int decrease = (value / 2)/ years;
		
		return decrease;
	}

}
