package com.cisco.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/products")
public class ProductResource {

	private static Map<Integer, Product> productMap = new HashMap<>();
	private static AtomicInteger ai = new AtomicInteger(0);
	static {
		
		Product p = new Product("pone", "this is first product", 123);
		p.setId(ai.incrementAndGet());
		productMap.put(p.getId(), p);
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProduct(@PathParam("id") Integer productId) {
		for(Map.Entry<Integer, Product> pmap:productMap.entrySet()) {
			if(productId.equals(pmap.getKey()))
				return pmap.getValue();
		}
		return null;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts() {
		List<Product> plist = new ArrayList<>();
		for(Map.Entry<Integer, Product> pmap:productMap.entrySet()) {
			plist.add(pmap.getValue());
		}
		return plist;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Product product) {
		product.setId(ai.incrementAndGet());
		productMap.put(product.getId(), product);
		
		return Response.ok().build();
		
		
	}
	
	

}
