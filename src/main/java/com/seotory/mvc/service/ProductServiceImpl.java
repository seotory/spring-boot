package com.seotory.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seotory.mvc.dao.ProductDao;
import com.seotory.mvc.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public boolean insert(Product product) {
		return productDao.insert(product);
	}
	
	@Override
	public Product get(int id) {
		return productDao.get(id);
	}
	
}
