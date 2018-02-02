package com.seotory.mvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.seotory.mvc.domain.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	// 자바는 원소값(int 같은..)을 컬랙션에 넣을 수 없다. 컬렉션은 참조 객체만 담을 수 있기 때문이다.
	private Map<Integer, Product> data = new HashMap<Integer, Product>();
	
	@Override
	public boolean insert(Product product) {
		// TODO Auto-generated method stub
		if (! data.containsKey(product.getId())) {
			data.put(product.getId(), product);
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	public Product get(int id) {
		// TODO Auto-generated method stub
		return data.get(id);
	}
	
}
