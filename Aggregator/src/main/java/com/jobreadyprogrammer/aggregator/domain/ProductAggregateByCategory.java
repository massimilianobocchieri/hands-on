package com.jobreadyprogrammer.aggregator.domain;

//Data Structure
public class ProductAggregateByCategory {

	private String category;
	private double averagePrice;
	private double totalPrice;
	private double highestPrice;
	private int numberOfItems;
	
	public ProductAggregateByCategory(String category, double averagePrice, double totalPrice, double highestPrice,
			int numberOfItems) {
		this.category = category;
		this.averagePrice = averagePrice;
		this.totalPrice = totalPrice;
		this.highestPrice = highestPrice;
		this.numberOfItems = numberOfItems;
	}

	public String getCategory() {
		return category;
	}

	public double getAveragePrice() {
		return averagePrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public double getHighestPrice() {
		return highestPrice;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	@Override
	public String toString() {
		return "ProductAggregateByCategory [category=" + category + ", averagePrice=" + averagePrice + ", totalPrice="
				+ totalPrice + ", highestPrice=" + highestPrice + ", numberOfItems=" + numberOfItems + "]";
	}
	
	
	
	
}
