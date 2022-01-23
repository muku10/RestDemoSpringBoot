package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Product;
import com.web.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	public ProductRepository repo;
	
	public List<Product> productLists(){
		return repo.findAll();
	}
	public void saveProduct(Product product) {
		repo.save(product);
	}
	
	public Product getProduct(Integer id) {
		return repo.findById(id).get();
	}
	public void deleteProduct(Integer id) {
		 repo.deleteById(id);
	}
	public List<Product> getProductByName(String name){
		return (List<Product>)repo.findByName(name);
	}
	public List<Product> getByNameAndPrice(String name,Float price){
		return (List<Product>)repo.findByNameAndPrice(name,price);
	}
}
