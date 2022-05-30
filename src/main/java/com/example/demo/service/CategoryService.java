package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository crepo;
	
	public Category savecategory(Category category) {
		return crepo.save(category);
	}
	
	public List<Category> findAll(){
		return crepo.findAll();
	}
}
