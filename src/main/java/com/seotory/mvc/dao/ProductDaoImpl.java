package com.seotory.mvc.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.seotory.mvc.domain.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	// �ڹٴ� ���Ұ�(int ����..)�� �÷��ǿ� ���� �� ����. �÷����� ���� ��ü�� ���� �� �ֱ� �����̴�.
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
