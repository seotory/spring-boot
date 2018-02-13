package com.seotory.rest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.seotory.rest.domain.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	// 자바 컬랙션에서는 참조 타입의 객제만 사용 할 수 있기 때문에 int 대신에 Integer를 사용한다.
	private Map<Integer, Product> data = new HashMap<Integer, Product>();
	
	private static int count = 0;
	
	private Random r = new Random();
	
	@Override
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		count += 1;
		int id = count;
		product.setId(id);
		product.setPrice(r.nextInt(100000+1) + 10);
		product.setRegDts(new Date());
		data.put(id, product);
		return true;
	}
	
	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		if (data.remove(id) != null) {
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
	
	@Override
	public ArrayList<Product> getAll() {
		// TODO Auto-generated method stub
		ArrayList<Product> list = new ArrayList<Product>(data.values());
		return list;
	}
	
}
