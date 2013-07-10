package com.bookstore.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.bookstore.book.Book;
import com.bookstore.order.Order;
import com.bookstore.order.OrderDAO;
import com.bookstore.service.representation.OrderRepresentation;

/**
 * This class' responsibility is to manage the workflow of
 * accessing/creating/updating/deleting resources using the OrderDOA object.
 * 
 */
public class OrderActivity {

	private static OrderDAO dao = new OrderDAO();

	public OrderActivity() {
	}

	public Set<OrderRepresentation> getOrders() {

		Set<Order> Orders = new HashSet<Order>();
		Set<OrderRepresentation> OrderRepresentations = new HashSet<OrderRepresentation>();
		Orders = dao.getAllOrders();

		Iterator<Order> it = Orders.iterator();
		while (it.hasNext()) {
			Order order = (Order) it.next();
			OrderRepresentation OrderRepresentation = new OrderRepresentation();
			OrderRepresentation.setFirstName(order.getFirstName());
			OrderRepresentation.setLastName(order.getLastName());
			OrderRepresentation.setId(order.getId());
			OrderRepresentation.setAddress(order.getAddress());
			OrderRepresentation.setBook(order.getBook());
			OrderRepresentation.setCard(order.getCard());
			// now add this representation in the list
			OrderRepresentations.add(OrderRepresentation);
		}
		return OrderRepresentations;
	}

	public OrderRepresentation getOrder(int id) {

		Order order = dao.getOrder(id);

		OrderRepresentation orderRep = new OrderRepresentation();
		orderRep.setFirstName(order.getFirstName());
		orderRep.setLastName(order.getLastName());
		orderRep.setId(order.getId());
		orderRep.setAddress(order.getAddress());
		orderRep.setCard(order.getCard());
		orderRep.setBook(order.getBook());
		return orderRep;
	}

	public String cancelOrder(int id) {

		if(dao.cancelOrder(id))
		return "OK";
		else 
			return "Fail";
	}

	public OrderRepresentation createOrder(String lastName, String firstName,
			int card, String address, Book book) {

		Order order = new Order();
		order = dao.addOrder(lastName,
				firstName, card, address, book);
		OrderRepresentation orderRep = new OrderRepresentation();
		orderRep.setFirstName(order.getFirstName());
		orderRep.setLastName(order.getLastName());
		orderRep.setId(order.getId());
		orderRep.setCard(order.getCard());
		orderRep.setAddress(order.getAddress());
		orderRep.setBook(order.getBook());

		return orderRep;
	}

}
