package com.seotory.rest.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seotory.rest.domain.Product;
import com.seotory.rest.domain.RestResponse;
import com.seotory.rest.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(path = ProductURL.SAVE, method = RequestMethod.POST)
	public ResponseEntity<?> save(@Valid @RequestBody Product product) {
		RestResponse restResponse = 
				new RestResponse(HttpStatus.OK, "SUCCESS", productService.save(product));
		return ResponseEntity.status(restResponse.getStatus()).body(restResponse);
	}
	
	@RequestMapping(path = ProductURL.GET, method = RequestMethod.GET)
	public ResponseEntity<?> get(@PathVariable("id") int id) {
		Product product = productService.get(id);
		RestResponse restResponse = new RestResponse();
		if (product != null) {
			restResponse.setStatus(HttpStatus.OK)
				.setMessage("SUCCESS")
				.setData(product);
			
		} else {
			restResponse.setStatus(HttpStatus.NOT_FOUND)
				.setMessage("not found")
				.setData(null);
		}
		
		return ResponseEntity.status(restResponse.getStatus()).body(restResponse);
	}
	
	@RequestMapping(path = ProductURL.GET_ALL, method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		RestResponse restResponse = 
				new RestResponse(HttpStatus.OK, "SUCCESS", productService.getAll());
		return ResponseEntity.status(restResponse.getStatus()).body(restResponse);
	}
	
	@RequestMapping(path = ProductURL.REMOVE, method = RequestMethod.DELETE)
	public ResponseEntity<?> remove(@PathVariable("id") int id) {
		RestResponse restResponse = 
				new RestResponse(HttpStatus.OK, "SUCCESS", productService.remove(id));
		return ResponseEntity.status(restResponse.getStatus()).body(restResponse);
	}
	
	@RequestMapping(path = ProductURL.INFO, method = RequestMethod.GET)
	public ResponseEntity<?> info () {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("sum", 0);
		data.put("orderPrice", productService.getOrderByPrice());
		data.put("overPrice", productService.getOverPrice(50000));
		RestResponse restResponse = new RestResponse(HttpStatus.OK, "SUCCESS", data);
		return ResponseEntity.status(restResponse.getStatus()).body(restResponse);
	}
	
}
