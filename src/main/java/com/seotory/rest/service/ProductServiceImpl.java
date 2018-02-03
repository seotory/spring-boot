package com.seotory.rest.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seotory.rest.dao.ProductDao;
import com.seotory.rest.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public boolean save(Product product) {
		return productDao.save(product);
	}
	
	@Override
	public boolean remove(int id) {
		return productDao.remove(id);
	}
	
	@Override
	public Product get(int id) {
		return productDao.get(id);
	}
	
	@Override
	public ArrayList<Product> getAll() {
		return productDao.getAll();
	}

	@Override
	public ArrayList<Product> getOrderByPrice() {
		ArrayList<Product> list = this.getAll();
		return list.stream()
				.sorted(Comparator.comparing(Product::getPrice))
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
	@Override
	public ArrayList<Product> getOverPrice(int price) {
		ArrayList<Product> list = this.getAll();
		return list.stream()
				.filter(product -> product.getPrice() >= price)
				.collect(Collectors.toCollection(ArrayList::new));
	}
	
}
