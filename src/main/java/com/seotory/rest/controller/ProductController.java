package com.seotory.rest.controller;

import java.util.Collections;
import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seotory.rest.domain.Product;
import com.seotory.rest.service.ProductService;

@RestController
public class ProductController {
	
//	@Autowired 
//	private EntityLinks entityLinks;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(path = ProductURL.SAVE, method = RequestMethod.POST)
	public ResponseEntity<?> save(@Valid @RequestBody Product product) {
		
		HttpHeaders headers = new HttpHeaders();
//		Link link = entityLinks.linkToSingleResource(Order.class, orderId);
//		headers.setLocation(linkTo(ProductController.class).slash(product).toUri());
		
		return ResponseEntity.ok(Collections.singletonMap("result", productService.save(product)));
	}
	
	@RequestMapping(path = ProductURL.GET, method = RequestMethod.GET)
	public ResponseEntity<?> get(@PathVariable("id") int id) {
		Product product = productService.get(id);
		return ResponseEntity.ok(product);
	}
	
	@RequestMapping(path = ProductURL.GET_ALL, method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(productService.getAll());
	}
	
	@RequestMapping(path = ProductURL.REMOVE, method = RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable("id") int id) {
		return ResponseEntity.ok(Collections.singletonMap("result", productService.remove(id)));
	}
	
	@RequestMapping(path = ProductURL.INFO, method = RequestMethod.GET)
	public ResponseEntity<?> info () {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("sum", 0);
		data.put("orderPrice", productService.getOrderByPrice());
		data.put("overPrice", productService.getOverPrice(50000));
		return ResponseEntity.ok(data);
	}
}
