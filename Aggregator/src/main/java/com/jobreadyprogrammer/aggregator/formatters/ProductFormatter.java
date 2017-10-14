package com.jobreadyprogrammer.aggregator.formatters;

import java.util.List;

import com.jobreadyprogrammer.aggregator.domain.ProductAggregateByCategory;

public class ProductFormatter {
	
	private List<ProductAggregateByCategory> items;

	public ProductFormatter(List<ProductAggregateByCategory> items) {
		this.items = items;
	}
	

	public void format(){
		for (ProductAggregateByCategory item: items)
			printItem(item);
	}
	
	private void printItem(ProductAggregateByCategory item){
		System.out.println(item.getCategory());
		System.out.println("---------------------------");
		System.out.println(String.format("average_price=%.2f",item.getAveragePrice()));
		System.out.println(String.format("total_sales_value=%.2f",item.getTotalPrice()));
		System.out.println(String.format("number_of_products=%d",item.getNumberOfItems()));
		System.out.println(String.format("most_expensive=%.2f",item.getHighestPrice()));
		System.out.println();
		
	}

}
