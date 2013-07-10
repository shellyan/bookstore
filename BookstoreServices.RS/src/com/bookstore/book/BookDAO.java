package com.bookstore.book;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.bookstore.order.Order;

public class BookDAO {

	private Set<Book> bookDAO = new HashSet<Book>();


	public BookDAO() {
		bookDAO.add(new Book(
				"Scala for the Impatient",
				"Cay S. Horstmann",
				"0321774094",
				"Scala is a modern programming language for the Java Virtual Machine (JVM) that combines the best features of object-oriented and functional programming languages. Using Scala, you can write programs more concisely than in Java, as well as leverage the full power of concurrency. Since Scala runs on the JVM, it can access any Java library and is interoperable with Java frameworks.",
				0));
		bookDAO.add(new Book(
				"Programming in Scala",
				"Martin Odersky",
				"0981531644",
				"Scala is an object-oriented programming language for the Java Virtual Machine. In addition to being object-oriented, Scala is also a functional language, and combines the best approaches to OO and functional programming. In Italian, Scala means a stairway, or steps--indeed, Scala lets you step up to a programming environment that incorporates some of the best recent thinking in programming language design while also letting you use all your existing Java code. Artima is very pleased to publish a new edition of the best-selling book on Scala, written by the designer of the language, Martin Odersky. Co-authored by Lex Spoon and Bill Venners, this book takes a step-by-step tutorial approach to teaching you Scala. Starting with the fundamental elements of the language, Programming in Scala introduces functional programming from the practitioner's perspective, and describes advanced language features that can make you a better, more productive developer.",
				34.62));
		bookDAO.add(new Book(
				"Scala in Depth",
				"Joshua D. Suereth",
				"1935182706",
				"Scala in Depth is a unique new book designed to help you integrate Scala effectively into your development process. By presenting the emerging best practices and designs from the Scala community, it guides you through dozens of powerful techniques example by example.",
				28.55));

	}

	public Book addBook(String title, String author, String ISBN,
			String description, double price) {
		return new Book(title, author, ISBN, description, price);

	}

	public Book getBook(String title) {

		Iterator<Book> it = bookDAO.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			if (book.getTitle().equals(title)) {
				return book;

			}
		}
		return null;
	}

	public void deleteBook(String title) {
		Iterator<Book> it = bookDAO.iterator();
		while (it.hasNext()) {
			Book book = (Book) it.next();
			if (book.getTitle().equals(title)) {
				bookDAO.remove(book);
				return;
			}
		}
	}

	public Set<Book> getAllBooks() {
		return bookDAO;
	}
}
