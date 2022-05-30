package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository prepo;
	
	public Product saveproduct(Product product) {
		return prepo.save(product);
	}
	
	public List<Product> findAll() {
        return prepo.findAll();
    }
	
	public Product updateproduct(Product product,int pid) {
		return prepo.save(product);
	}
	
	public void deleteproduct(int pid) {
		prepo.deleteById(pid);
	}
}
