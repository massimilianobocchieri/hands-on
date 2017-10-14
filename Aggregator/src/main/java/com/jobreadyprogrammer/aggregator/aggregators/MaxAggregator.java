package com.jobreadyprogrammer.aggregator.aggregators;

import java.util.List;

public class MaxAggregator extends Aggregator{
	
	public MaxAggregator(List<Double> prices) {
		super(prices);
	}

	public double calculate() {
		double max = numbers.get(0);
		for(Double number : numbers)
			if(number > max)
				max = number;

		return max;
	}

}
