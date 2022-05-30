package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Warehouse;
import com.example.demo.repository.WarehouseRepository;

@Service
public class WarehouseService {
	@Autowired
	WarehouseRepository wrepo;
	
	public Warehouse saveproduct(Warehouse warehouse) {
        return wrepo.save(warehouse);
    }
	public List<Warehouse> findAll() {
        return wrepo.findAll();
    }
	

	
}
