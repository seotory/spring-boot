package com.seotory.mvc.service;

import com.seotory.mvc.domain.Product;

public interface ProductService {
	
	public boolean insert(Product product);
	public Product get(int id);

}
