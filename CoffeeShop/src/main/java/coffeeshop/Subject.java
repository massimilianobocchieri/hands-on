package coffeeshop;

import domain.WaitingCustomer;

//Subject Interface
public interface Subject {

	public void takeOrder(WaitingCustomer customer);

	public void farewell(WaitingCustomer customer);

}
