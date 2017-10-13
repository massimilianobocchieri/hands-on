package domain;

import coffeeshop.Subject;

public class Customer implements WaitingCustomer {

	private String name;
	private String drinkOrdered;

	public Customer(String name, String drinkOrdered) {
		this.name = name;
		this.drinkOrdered = drinkOrdered;
	}

	public void orderReady(String preparedDrink, Subject attendent) {
		if (preparedDrink.equals(drinkOrdered))
			exitStore(attendent);
	}

	private void exitStore(Subject attendent) {
		System.out.println(String.format("%s ready, %s is leaving", drinkOrdered, name));
		attendent.farewell(this);
	}
}
