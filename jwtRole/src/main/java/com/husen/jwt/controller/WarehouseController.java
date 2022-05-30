package com.husen.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.husen.jwt.entity.WarehouseDetails;
import com.husen.jwt.service.WarehouseDetailsService;

@RestController
@RequestMapping("/warehouse")
@CrossOrigin
public class WarehouseController {
	@Autowired
	WarehouseDetailsService wservice;

	@PostMapping("/newWarehouse")
	@PreAuthorize("hasRole('Admin')")
	public ResponseEntity<WarehouseDetails> addWarehouse(@RequestBody WarehouseDetails warehouse) {
		return new ResponseEntity<WarehouseDetails>(wservice.saveproduct(warehouse), HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	@PreAuthorize("hasAnyRole('Admin','User')")
	public List<WarehouseDetails> getAllproducts() {
		return wservice.findAll();
	}

}
