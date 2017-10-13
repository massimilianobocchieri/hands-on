package coffeeshop;

import java.util.LinkedList;
import java.util.List;

import domain.WaitingCustomer;

//Subject
public class CoffeeAttendent implements Subject {

	// Observers List
	private List<WaitingCustomer> customerList;
	private String completedDrink;

	public CoffeeAttendent() {
		customerList = new LinkedList<WaitingCustomer>();
	}

	public void takeOrder(WaitingCustomer customer) {
		customerList.add(customer);
	}

	public void prepareDrink(String drinktoPrepare) {
		completedDrink = drinktoPrepare;
		this.callOutCompletedOrder();
	}

	public void callOutCompletedOrder() {
		for (WaitingCustomer customer : customerList)
			customer.orderReady(completedDrink, this);
	}

	public void farewell(WaitingCustomer customer) {
		customerList.remove(customer);
	}
}
