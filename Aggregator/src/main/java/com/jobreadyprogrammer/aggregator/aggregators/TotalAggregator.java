package com.jobreadyprogrammer.aggregator.aggregators;

import java.util.List;

public class TotalAggregator extends Aggregator {

	public TotalAggregator(List<Double> prices) {
		super(prices);
	}

	public double calculate() {
		double result = 0.00;

		for (Double number : numbers)
			result += number;

		return result;
	}

}
