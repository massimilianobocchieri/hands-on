package com.jobreadyprogrammer.aggregator.aggregators;

import java.util.List;

public class CountAggregator extends Aggregator {

	public CountAggregator(List<Double> prices) {
		super(prices);
	}

	public double calculate() {
		return numbers.size();
	}

}
