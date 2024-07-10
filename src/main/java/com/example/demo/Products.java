package com.example.demo;

public class Products {
	
	private int id;
	private String title;
	private double price;
	private String category;
	private String description;
	
	//costruttore
	public Products(int id, String title, double price, String category, String description) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.price = price;
		this.description = description;
	}
	
	//getters e setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
