package com.jobreadyprogrammer.aggregator.aggregators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jobreadyprogrammer.aggregator.domain.Product;
import com.jobreadyprogrammer.aggregator.domain.ProductAggregateByCategory;
import com.jobreadyprogrammer.aggregator.processors.ProductDataProcessor;

public class ProductAggregator {

	List<Product> products;

	public ProductAggregator(ProductDataProcessor productDataProcessor) {
		productDataProcessor.process();
		this.products = productDataProcessor.getProducts();
	}

	public List<ProductAggregateByCategory> aggregate() {
		Map<String, List<Double>> productPricesByCategory = this.getProductPricesByCategory();
		List<ProductAggregateByCategory> productAggregatedByCategory = new ArrayList<>();

		// Lambda@Java 8 , Syntactic sugar...
		productPricesByCategory.forEach((category, prices) -> {
			Aggregator avgAggregator = new MeanAggregator(prices);
			Aggregator maxAggregator = new MaxAggregator(prices);
			Aggregator totalAggregator = new TotalAggregator(prices);
			Aggregator countAggregator = new CountAggregator(prices);

			productAggregatedByCategory.add(new ProductAggregateByCategory(category, avgAggregator.calculate(),
					totalAggregator.calculate(), maxAggregator.calculate(), (int) countAggregator.calculate()));

		});

		return productAggregatedByCategory;
	}

	private Map<String, List<Double>> getProductPricesByCategory() {
		Map<String, List<Double>> productPricesByCategory = new HashMap<>();
		for (Product product : products)
			addToproductPricesByCategory(product, productPricesByCategory);

		return productPricesByCategory;
	}

	// @TODO: change signature
	private void addToproductPricesByCategory(Product product, Map<String, List<Double>> productPricesByCategory) {
		String productCategory = product.getCategory();

		if (!productPricesByCategory.containsKey(productCategory))
			productPricesByCategory.put(productCategory, new ArrayList<Double>());

		List<Double> salesPrices = productPricesByCategory.get(productCategory);
		salesPrices.add(product.getSalesPrice());
		productPricesByCategory.put(productCategory, salesPrices);
	}
}
