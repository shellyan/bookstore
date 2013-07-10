package com.bookstore.service;


import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.bookstore.service.representation.BookRepresentation;
import com.bookstore.service.representation.OrderRepresentation;
import com.bookstore.service.representation.OrderRequest;



@WebService
public interface BookstoreService {
	   
	public Set<OrderRepresentation> getOrders();
	public OrderRepresentation getOrder(int orderId);
	public OrderRepresentation createOrder(OrderRequest orderRequest);
    public BookRepresentation getBook(String title);
    //public Response updateOrder(OrderRequest OrderRequest);
    public Response cancelOrder(int OrderId);
	
	

}
