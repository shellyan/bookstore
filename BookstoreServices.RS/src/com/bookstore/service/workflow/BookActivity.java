package com.bookstore.service.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.bookstore.book.Book;
import com.bookstore.book.Book;
import com.bookstore.book.BookDAO;
import com.bookstore.service.representation.BookRepresentation;


/**
 * This class' responsibility is to manage the workflow of accessing/creating/updating/deleting resources
 * using the BookDOA object.  
 *
 */
public class BookActivity {

	private static BookDAO dao = new BookDAO();
	

	
	public BookRepresentation getBook(String title) {
		
		Book book = dao.getBook(title);
		
		BookRepresentation bookRep = new BookRepresentation();
		bookRep.setTitle(book.getTitle());
		bookRep.setPrice(book.getPrice());
		bookRep.setAuthor(book.getAuthor());
		bookRep.setIsbn(book.getIsbn());
		bookRep.setDescription(book.getDescription());
		return bookRep;
	}
	
	public BookRepresentation addBook(String title, String author, String isbn, String description, double price) {
		
		Book book = dao.addBook(title,  author,  isbn,  description,  price);
		
		BookRepresentation bookRep = new BookRepresentation();
		bookRep.setTitle(book.getTitle());
		bookRep.setPrice(book.getPrice());
		bookRep.setAuthor(book.getAuthor());
		
		return bookRep;
	}
	
	public String deleteBook(String title) {
		
		dao.deleteBook(title);
		
		return "OK";
	}
	
}
