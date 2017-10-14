package com.jobreadyprogrammer.aggregator.aggregators;

import java.util.ArrayList;
import java.util.List;

public abstract class Aggregator {

	List<Double> numbers;

	public Aggregator() {
		numbers = new ArrayList<Double>();
	}

	public Aggregator(List<Double> numbers) {
		this.numbers = numbers;
	}

	public void add(double number) {
		numbers.add(number);
	}

	public abstract double calculate();

}
