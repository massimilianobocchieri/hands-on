package com.jobreadyprogrammer.aggregator.domain;

//Data Structure
public class Product {

	private String name;
	private String category;
	private double salesPrice;

	public Product(String name, String category, double salesPrice) {
		this.name = name;
		this.category = category;
		this.salesPrice = salesPrice;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getSalesPrice() {
		return salesPrice;
	}
	
}
