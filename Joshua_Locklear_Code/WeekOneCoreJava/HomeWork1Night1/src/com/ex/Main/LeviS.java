/*
 * This class represents the idea of inheritance because it gains
 * the use of the getter and setter methods
 */
package com.ex.Main;

public class LeviS extends Shirt {
	LeviS(String brand,String material,double cost,String store){
		super(brand, material, cost, store);
	}
	public String getMaterial(){
		return "This shirt is made out of "+ material;
	}
}
