package domain;

import coffeeshop.Subject;

//Observer Interface
public interface WaitingCustomer {

	public void orderReady(String preparedDrink, Subject attendent);
}
