package com.seotory.mvc.dao;

import com.seotory.mvc.domain.Product;

public interface ProductDao {
	
	public boolean insert(Product product);
	public Product get(int id);

}
