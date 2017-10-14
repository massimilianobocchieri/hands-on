package com.jobreadyprogrammer.aggregator.clients;

import com.jobreadyprogrammer.aggregator.aggregators.ProductAggregator;
import com.jobreadyprogrammer.aggregator.formatters.ProductFormatter;
import com.jobreadyprogrammer.aggregator.processors.ProductDataProcessor;
import com.jobreadyprogrammer.aggregator.processors.ProductFileReader;

public class App {

	public static void main(String[] args) {

		ProductDataProcessor productDataProcessor = new ProductDataProcessor(new ProductFileReader("products.csv"));
		productDataProcessor.process();
		
		ProductAggregator aggregator = new ProductAggregator(productDataProcessor);
		ProductFormatter formatter = new ProductFormatter(aggregator.aggregate());
		formatter.format();
		
	}

}
