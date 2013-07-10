package com.bookstore.client;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import sun.security.action.GetBooleanAction;

import com.bookstore.book.Book;
import com.bookstore.service.representation.OrderRequest;

public final class OrderServiceClient {

	private OrderServiceClient() {
	}

	public static void main(String args[]) throws Exception {

		List<Object> providers = new ArrayList<Object>();
		JacksonJsonProvider provider = new JacksonJsonProvider();
		provider.addUntouchable(Response.class);
		providers.add(provider);

		/*****************************************************************************************
		 * GET METHOD: GET ORDER BY ID NUMBER
		 *****************************************************************************************/
		System.out
				.println("GET METHOD .........................................................");
		WebClient getClient = WebClient.create("http://localhost:8080",
				providers);

		// Configuring the CXF logging interceptor for the outgoing message
		WebClient.getConfig(getClient).getOutInterceptors()
				.add(new LoggingOutInterceptor());
		// Configuring the CXF logging interceptor for the incoming response
		WebClient.getConfig(getClient).getInInterceptors()
				.add(new LoggingInInterceptor());

		// change application/xml to get in xml format
		getClient = getClient.accept("application/json")
				.type("application/json").path("/bookstore/order/3");

		// The following lines are to show how to log messages without the CXF
		// interceptors
		String getRequestURI = getClient.getCurrentURI().toString();
		System.out.println("Client GET METHOD Request URI:  " + getRequestURI);
		String getRequestHeaders = getClient.getHeaders().toString();
		System.out.println("Client GET METHOD Request Headers:  "
				+ getRequestHeaders);

		// to see as raw XML/json
		String response = getClient.get(String.class);
		System.out.println("GET METHOD Response: ...." + response);
		/*****************************************************************************************
		 * GET METHOD: GET ALL ORDERS
		 *****************************************************************************************/
		System.out.println("**********GET METHOD: GET ALL ORDERSS**********");
		getClient = WebClient.create("http://localhost:8080", providers);

		// Configuring the CXF logging interceptor for the outgoing message
		WebClient.getConfig(getClient).getOutInterceptors()
				.add(new LoggingOutInterceptor());
		// Configuring the CXF logging interceptor for the incoming response
		WebClient.getConfig(getClient).getInInterceptors()
				.add(new LoggingInInterceptor());

		// change application/xml to get in xml format
		getClient = getClient.accept("application/json")
				.type("application/json").path("/bookstore/order/");

		// The following lines are to show how to log messages without the CXF
		// interceptors
		getRequestURI = getClient.getCurrentURI().toString();
		System.out.println("Client GET METHOD Request URI:  " + getRequestURI);
		getRequestHeaders = getClient.getHeaders().toString();
		System.out.println("Client GET METHOD Request Headers:  "
				+ getRequestHeaders);

		// to see as raw XML/json
		response = getClient.get(String.class);
		System.out.println("GET METHOD Response: ...." + response);

		/*****************************************************************************************
		 * GET METHOD SEARCH FOR BOOK
		 *****************************************************************************************/

		System.out.println("**********GET METHOD SEARCH FOR BOOK**********");
		WebClient getBookClient = WebClient.create("http://localhost:8080",
				providers);
		WebClient.getConfig(getBookClient).getOutInterceptors()
				.add(new LoggingOutInterceptor());
		WebClient.getConfig(getBookClient).getInInterceptors()
				.add(new LoggingInInterceptor());

		// change application/xml to get in xml format
		getBookClient = getBookClient.accept("application/json")
				.type("application/json")
				.path("/bookstore/book/Scala in Depth");

		String getAllRequestURI = getBookClient.getCurrentURI().toString();
		System.out.println("Client GET METHOD Request URI:  "
				+ getAllRequestURI);
		String getAllRequestHeaders = getBookClient.getHeaders().toString();
		System.out.println("Client GET METHOD Request Headers:  "
				+ getAllRequestHeaders);

		// to see as raw XML/json
		String getAllResponse = getBookClient.get(String.class);
//		Book book = getBookClient.get(Book.class);
		System.out.println("GET METHOD Response for searching book: \n"
				+ getAllResponse);

		/*****************************************************************************************
		 * POST METHOD TO CREATE AN ORDER
		 *****************************************************************************************/
		
		
		 System.out.println("********** POST METHOD TO CREATE AN ORDER**********");
	        WebClient postClient = WebClient.create("http://localhost:8080", providers);
	        WebClient.getConfig(postClient).getOutInterceptors().add(new LoggingOutInterceptor());
	        WebClient.getConfig(postClient).getInInterceptors().add(new LoggingInInterceptor());
	                 
	        // change application/xml  to application/json get in json format
	        postClient = postClient.accept("application/xml").type("application/json").path("/bookstore/order");
	     	
	        String postRequestURI = postClient.getCurrentURI().toString();
	        System.out.println("Client POST METHOD Request URI:  " + postRequestURI);
	        String postRequestHeaders = postClient.getHeaders().toString();
	        System.out.println("Client POST METHOD Request Headers:  " + postRequestHeaders);
	        
	        
	    	OrderRequest orderRequest = new OrderRequest();
			orderRequest.setFirstName("Michael");
			orderRequest.setLastName("Gerard");
			orderRequest.setAddress("123 W bbway");
			orderRequest.setCard(444444444);
			orderRequest.setBook(new Book("Testing", "author", "12",
					"description", 123));
			
			 javax.ws.rs.core.Response responsePost = postClient.post(orderRequest);
	        System.out.println("POST MEDTHOD Response ........." + responsePost);
	        

			/*****************************************************************************************
			 * USE GET METHOD CHECK IF ORDER IS ADDED
			 *****************************************************************************************/
	        System.out.println("********** USE GET METHOD CHECK IF ORDER IS ADDED**********");
	        
	        response = getClient.get(String.class);
			System.out.println("GET METHOD Response: ...." + response);

			/*****************************************************************************************
			 * DELETE METHOD : CHANGE STATE OF EXISTING ORDER (YOU DIDNT ACTUALLY
			 * DELETE, JUST MODIFIED THE STATE)
			 *****************************************************************************************/
		System.out
				.println("********** DELETE METHOD : CHANGE STATE OF EXISTING ORDER (YOU DIDNT ACTUALLY DELETE, JUST MODIFIED THE STATE)**********");
		WebClient deleteClient = WebClient.create("http://localhost:8080",
				providers);
		WebClient.getConfig(deleteClient).getOutInterceptors()
				.add(new LoggingOutInterceptor());
		WebClient.getConfig(deleteClient).getInInterceptors()
				.add(new LoggingInInterceptor());

		// change application/xml to application/json get in json format
		deleteClient = deleteClient.accept("application/xml")
				.type("application/json").path("/bookstore/order/3");

		String deleteRequestURI = deleteClient.getCurrentURI().toString();
		System.out.println("Client DELETE METHOD Request URI:  "
				+ deleteRequestURI);
		String deleteRequestHeaders = deleteClient.getHeaders().toString();
		System.out.println("Client DELETE METHOD Request Headers:  "
				+ deleteRequestHeaders);

		javax.ws.rs.core.Response responseDelete = deleteClient.delete();
		System.out.println("DELETE MEDTHOD Response ......... "
				+ responseDelete.getStatus());

		System.exit(0);
	}
}