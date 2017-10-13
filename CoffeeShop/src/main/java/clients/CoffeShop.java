package clients;

import coffeeshop.CoffeeAttendent;
import domain.Customer;

public class CoffeShop {

	public static void main(String[] args) {

		CoffeeAttendent attendent = new CoffeeAttendent();
		Customer john = new Customer("John", "beer");
		Customer max = new Customer("Max", "gingerbeer");

		attendent.takeOrder(john);
		attendent.takeOrder(max);

		attendent.prepareDrink("gingerbeer");
		attendent.prepareDrink("beer");

	}

}
