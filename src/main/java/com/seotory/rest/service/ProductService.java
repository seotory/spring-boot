package com.seotory.rest.service;

import java.util.ArrayList;

import com.seotory.rest.domain.Product;

public interface ProductService {
	
	public boolean save(Product product);
	public boolean remove(int id);
	public Product get(int id);
	public ArrayList<Product> getAll();
	public ArrayList<Product> getOrderByPrice();
	public ArrayList<Product> getOverPrice(int price);
	

}
