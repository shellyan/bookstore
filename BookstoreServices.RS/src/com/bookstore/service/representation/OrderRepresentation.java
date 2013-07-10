package com.bookstore.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.bookstore.book.Book;
import com.bookstore.order.Order.OrderState;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRepresentation {

	private int id;
	private OrderState orderState = OrderState.open;
	private String lastName;
	private String firstName;
	private int card;
	private String address;
	private Book book;
	

	
	public OrderRepresentation() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setCard(int card) {
		this.card = card;
	}

	public int getCard() {
		return card;
	}

	public String getAddress() {
		return address;
	}

	public Book getBook() {
		return book;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getState() {
		return orderState.toString();
	}

	public void cancel() {
		orderState = OrderState.canceled;
	}

	public void orderDelivered() {
		orderState = OrderState.delivered;
	}

	public void orderClosed() {
		orderState = OrderState.closed;
	}

	public void orderPaid() {
		orderState = OrderState.paid;
	}
	
}
