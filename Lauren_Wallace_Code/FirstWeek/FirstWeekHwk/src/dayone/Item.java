package dayone;

//Inheritance occurs as this class implements the Buyable interface
public abstract class Item implements Buyable{
	
	private String itemName = " ";
	private double price = 0;
	private String description = " ";

	//default constructor for an item
	public Item() {
		this.itemName = "Item";
		this.price = 4.99;
	}
	
	//Overloading the default constructor as the parameters are different
	public Item(String item, double price, String description) {
		this.itemName = item;
		this.price = price;
		this.description = description;
	}
	
	//provides encapsulation by requiring other classes to use this method to see 
	//the variable value
	public String getItemName() {
		return itemName;
	}

	//provides encapsulation by requiring other classes to use this method to change
	//the variable value
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	//provides encapsulation by requiring other classes to use this method to see 
	//the variable value
	public double getPrice() {
		return price;
	}

	//provides encapsulation by requiring other classes to use this method to change
	//the variable value
	public void setPrice(double price) {
		this.price = price;
	}

	//provides encapsulation by requiring other classes to use this method to see 
	//the variable value
	public String getDescription() {
		return description;
	}

	//Provides encapsulation by requiring other classes to use this method to change
	//the variable value
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	//An example of Polymorphism since it overrides the priceCheck method in Buyable
	public void priceCheck(String store1, double price1, String store2, double price2) {
		// TODO Auto-generated method stub
		if(price1 < price2) {
			System.out.println(store1 + " has the better deal at " + price1);
		}
		System.out.println(store2 + " had the better deal at " + price2);
	}

	@Override
	//This overrides the method description() in Buyable
	public void description() {
		// TODO Auto-generated method stub
		System.out.println("This is a generic item!");
	}
}
