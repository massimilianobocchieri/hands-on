package com.jobreadyprogrammer.aggregator.aggregators;

import java.util.List;

public class MeanAggregator extends Aggregator {

	public MeanAggregator(List<Double> prices) {
		super(prices);
	}

	public double calculate() {

		if (numbers.isEmpty())
			return 0;

		double result = 0;
		double value = 0.00;

		for (Double number : numbers)
			value += number;

		result = value / numbers.size();

		return result;
	}

}
