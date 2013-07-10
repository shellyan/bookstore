package com.bookstore.order;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;

import com.bookstore.book.Book;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String lastName;
	private String firstName;
	private String address;
	private Book book;
	private int card;
	private OrderState orderState = OrderState.open;

	public Order() {
	}

	public Order(int id, String lastName, String firstName, int card, String address,
			Book book) {
		this.id=id;
		this.lastName=lastName;
		this.firstName=firstName;
		this.card=card;
		this.address=address;
		this.book=book;

	
	}

	public enum OrderState {
		open, canceled, delivered, closed, paid
	};

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public Book getBook() {
		return book;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public void setBook(Book book) {
		this.book = book;
	}

	public void setId(int id) {
		this.id = id;
	}

}
