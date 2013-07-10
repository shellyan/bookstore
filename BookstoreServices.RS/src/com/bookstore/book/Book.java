package com.bookstore.book;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Book")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	public String title;
	public String author;
	public String isbn;
	public double price;
	public String description;

	public Book() {
	}

	public Book(String title, String author, String isbn, String description,
			double price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.description = description;

	}

	
	public void  setAuthor(String author){
		this.author=author;
	}
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDescription(String description){
		this.description=description;
	}

	public void setIsbn(String isbn){
		this.isbn=isbn;
	}
}
