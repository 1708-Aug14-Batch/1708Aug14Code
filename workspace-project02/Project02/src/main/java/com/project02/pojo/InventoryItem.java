//package com.project02.pojo;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="inv_item")
//public class InventoryItem {
//	
//	@Id
//	@Column(name="inv_item_id")
//	@SequenceGenerator(name="inv_item_id_seq", sequenceName="inv_item_id_seq")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="inv_item_id_seq")
//	private int intentoryItemID;
//	
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="department_id")
//	private Department department;
//	
//	@Column(name="unit_price")
//	private double unitPrice;
//	
//	@Column(name="quantity")
//	private int quantity;
//	
//	@Column(name="description")
//	private String description;
//	
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="discount_id")
//	private Discount discount;
//	
//	@Column(name="image")
//	private String image;
//	
//	@Column(name="rating")
//	private int rating;
//
//	public InventoryItem() {}
//	
//	public InventoryItem(int intentoryItemID, Department department, double unitPrice, int quantity, String description,
//			Discount discount, String image, int rating) {
//		this.intentoryItemID = intentoryItemID;
//		this.department = department;
//		this.unitPrice = unitPrice;
//		this.quantity = quantity;
//		this.description = description;
//		this.discount = discount;
//		this.image = image;
//		this.rating = rating;
//	}
//
//	public int getIntentoryItemID() {
//		return intentoryItemID;
//	}
//
//	public void setIntentoryItemID(int intentoryItemID) {
//		this.intentoryItemID = intentoryItemID;
//	}
//
//	public Department getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}
//
//	public double getUnitPrice() {
//		return unitPrice;
//	}
//
//	public void setUnitPrice(double unitPrice) {
//		this.unitPrice = unitPrice;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public Discount getDiscount() {
//		return discount;
//	}
//
//	public void setDiscount(Discount discount) {
//		this.discount = discount;
//	}
//
//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}
//
//	public int getRating() {
//		return rating;
//	}
//
//	public void setRating(int rating) {
//		this.rating = rating;
//	}
//	
//}
