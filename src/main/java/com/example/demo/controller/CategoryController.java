package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;

import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class CategoryController {
	@Autowired
	CategoryService cservice;
	
	@PostMapping("")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		return new ResponseEntity<Category>(cservice.savecategory(category), HttpStatus.CREATED );
	}
	 
	@GetMapping("/all")
	public List<Category> getAllproducts(){
		return cservice.findAll();
	}
}
