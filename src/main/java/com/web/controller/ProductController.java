package com.web.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Product;
import com.web.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	public ProductService service;
	
	@GetMapping("/products")
	public List<Product> productLists(){
		return service.productLists();
	}
	
	@GetMapping ("/products/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable Integer id) {
		try {
			Product product = service.getProduct(id);
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		}catch(NoSuchElementException e) {
		    return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	
	}
	
	@RequestMapping(method=RequestMethod.POST,value ="/products")
	public void saveProducts(@RequestBody Product product) {
		service.saveProduct(product);
	}
		
	@PostMapping("products/{id}")
	public void deleteProduct(@PathVariable Integer id) {
		service.deleteProduct(id);
	}
	@GetMapping("/products/name")
	public List<Product> getByName(@RequestParam String name) {
		return service.getProductByName(name);
	}
	@GetMapping("/product")
	public String product(){
		return "yes";
	}
}

