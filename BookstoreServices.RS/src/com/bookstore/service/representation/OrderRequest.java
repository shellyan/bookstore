package com.bookstore.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.bookstore.book.Book;
import com.bookstore.order.Order.OrderState;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRequest {

	private String firstName;
	private String lastName;
	private int card;
	private String address;
	private Book book;
	private OrderState orderState = OrderState.open;

	
	public OrderRequest() {
	}

	public String getFirstName() {
		return firstName;

	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;

	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBook(Book book) {
		this.book = book;

	}

	public void setCard(int card) {
		this.card = card;
	}

	public int getCard() {
		return card;
	}

	public Book getBook() {
		return book;
	}

	public String getAddress() {
		return address;

	}

	public void setAddress(String address) {
		this.address = address;
	}
}
