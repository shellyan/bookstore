package com.bookstore.service;

import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import com.bookstore.book.Book;
import com.bookstore.service.representation.BookRepresentation;
import com.bookstore.service.representation.OrderRepresentation;
import com.bookstore.service.representation.OrderRequest;
import com.bookstore.service.workflow.BookActivity;
import com.bookstore.service.workflow.OrderActivity;


@Path("/bookstore/")
public class BookstoreResource implements BookstoreService {
	
	private BookActivity bookActivity = new BookActivity();
	private OrderActivity orderActivity = new OrderActivity();


	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/book/{bookId}")
	public BookRepresentation getBook(@PathParam("bookId") String bookId) {
		System.out
				.println("GET METHOD Request for specific book .............");
		return bookActivity.getBook(bookId);
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/order")
	public Set<OrderRepresentation> getOrders() {
		System.out.println("GET METHOD Request for all Orders .............");
		return orderActivity.getOrders();
	}

	//
	@GET
	@Produces({ "application/xml", "application/json" })
	@Path("/order/{orderId}")
	public OrderRepresentation getOrder(@PathParam("orderId") int id) {
		System.out
				.println("GET METHOD Request from Client with OrderRequest String ............."
						+ id);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrder(id);
	}

	
	
	@POST
	@Produces({ "application/xml", "application/json" })
	@Path("/order")
	public OrderRepresentation createOrder(OrderRequest orderRequest) {
		
		return orderActivity.createOrder(orderRequest.getLastName(),
				orderRequest.getFirstName(), orderRequest.getCard(),
				orderRequest.getAddress(), orderRequest.getBook());
		}




	@DELETE
	@Produces({ "application/xml", "application/json" })
	@Path("/order/{orderId}")
	public Response cancelOrder(@PathParam("orderId") int id) {
		System.out
				.println("Server is trying to delete ............."
						+ id);
		String res = orderActivity.cancelOrder(id);
		if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}

}