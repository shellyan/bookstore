package com.bookstore.order;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.bookstore.book.Book;
import com.bookstore.book.BookDAO;

public class OrderDAO {

	
	private BookDAO bookDAO = new BookDAO();
	private Set<Order> orderDAO = new HashSet<Order>();
	private Order order1 = new Order(1, "Shell", "Yan", 1111111111,
			"1046 w rosemont", bookDAO.getBook("Scala for the Impatient"));
	private Order order2 = new Order(2, "Fang", "Liao", 222222222,
			"234 w braodway", bookDAO.getBook("Programming in Scala"));
	private Order order3 = new Order(3, "Ron", "Rockman", 333333333,
			"452 s biggerway", bookDAO.getBook("Scala in Depth"));

	public OrderDAO() {
		orderDAO.add(order1);
		orderDAO.add(order2);
		orderDAO.add(order3);

	}

	public Set<Order> getAllOrders() {
		return orderDAO;

	}

	public Order getOrder(int id) {

		Iterator<Order> it = orderDAO.iterator();
		while (it.hasNext()) {
			Order order = (Order) it.next();
			if (order.getId() == id) {
				return order;

			}
		}
		return null;

	}

	public Order addOrder(String lastName, String firstName, int card,
			String address, Book book) {

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000);
        
		Order order = new Order(randomInt,lastName,firstName,card,address,book);
		orderDAO.add(order);
		return order;
	}

	public boolean cancelOrder(int id) {
		Iterator<Order> it = orderDAO.iterator();
		while (it.hasNext()) {
			Order order = (Order) it.next();
			if (order.getId() == id) {
				order.cancel();
				return true;
			}
		}
		return false;
	}

}