package com.jobreadyprogrammer.aggregator.processors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jobreadyprogrammer.aggregator.common.Utility;
import com.jobreadyprogrammer.aggregator.domain.Product;

public class ProductDataProcessor {

	private ProductFileReader fileReader;
	private List<Product> products;

	public ProductDataProcessor(ProductFileReader fileReader) {
		this.fileReader = fileReader;
		this.products = new ArrayList<Product>();
	}

	public void process() {
		try {
			List<String> rowData = fileReader.readFileData();
			for (String line : rowData)
				products.add(this.getProduct(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Product> getProducts() {
		return this.products;
	}

	private Product getProduct(String line) {
		String[] fields = line.split(",");
		Product product = new Product(Utility.stripSlashes(fields[0]), Utility.stripSlashes(fields[1]),
				Double.parseDouble(fields[2]));
		return product;
	}

}
