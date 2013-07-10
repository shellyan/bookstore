package com.bookstore.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.bookstore.book.Book;

@XmlRootElement(name = "Book")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class BookRepresentation {

	public String title;
	public String author;
	public String isbn;
	public double price;
	public String description;

	public BookRepresentation() {
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public String getAuthor() {
		return author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
