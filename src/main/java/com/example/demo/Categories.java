package com.example.demo;

public class Categories {
	private int id;
	private String name;
	
	//costruttore
	public Categories(int id, String name) {
		this.id = id;
		this.name = name;
	}

	//getters e setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
