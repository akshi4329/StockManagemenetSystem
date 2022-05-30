package com.example.demo.controller;

import java.util.List;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;


@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {
	@Autowired
	ProductService service;
	
	
	
	
	@PostMapping("")
	private ResponseEntity<Product> saveproduct(@RequestBody Product product) {
		service.saveproduct(product);
		return new ResponseEntity<Product>(service.saveproduct(product),HttpStatus.CREATED);
	}
	
	
	
	
	 @GetMapping("/all")
	 public List<Product> getAllproducts(){
	        return service.findAll();
	  }
	 
	 @PutMapping("/update/{pid}")
	 public Product updateproduct(@RequestBody Product product,@PathVariable("pid") int pid) {
		 return service.updateproduct(product,pid);
	 }
	 
	 @DeleteMapping("/delete/{pid}")
	 public void deleteproduct(@PathVariable("pid") int pid) {
		 service.deleteproduct(pid);
	 }
	 
	
}
