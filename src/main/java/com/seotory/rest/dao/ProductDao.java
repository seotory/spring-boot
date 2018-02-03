package com.seotory.rest.dao;

import java.util.ArrayList;

import com.seotory.rest.domain.Product;

public interface ProductDao {
	
	public boolean save(Product product);
	public boolean remove(int id);
	public Product get(int id);
	public ArrayList<Product> getAll();

}
