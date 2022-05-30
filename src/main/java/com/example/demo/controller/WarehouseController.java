package com.example.demo.controller;

import java.util.List;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.Warehouse;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.WarehouseRepository;
import com.example.demo.service.WarehouseService;

@RestController
@RequestMapping("/api/warehouse")
@CrossOrigin
public class WarehouseController {
	@Autowired
	WarehouseService wservice;

	
	 @PostMapping("")
	 public ResponseEntity<Warehouse> addWarehouse(@RequestBody Warehouse warehouse) {
	        return new ResponseEntity<Warehouse>(wservice.saveproduct(warehouse), HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/all")
	 public List<Warehouse> getAllproducts(){
	        return wservice.findAll();
	 }
	
	 
}
