package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
   List<Product> findByName(String name);
   List<Product> findByNameAndPrice(String name,Float price);
}
