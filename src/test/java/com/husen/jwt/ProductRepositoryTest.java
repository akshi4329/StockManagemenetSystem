package com.husen.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

import com.husen.jwt.dao.ProductDetailsRepository;
import com.husen.jwt.entity.CategoryDetails;
import com.husen.jwt.entity.ProductDetails;
import com.husen.jwt.entity.WarehouseDetails;
import com.husen.jwt.service.ProductDetailsService;

@SpringBootTest
public class ProductRepositoryTest {
	@MockBean
	private ProductDetailsRepository repo;
	
	@Autowired
	private ProductDetailsService serv2;
	
	/*@Test
	public void getproducttest() {
		List<ProductDetails> listOfProductDetails = new ArrayList<>();
		ProductDetails productDetails = new ProductDetails(1,"p1",32,2,"11032000",new CategoryDetails(1,"c1",null),new WarehouseDetails(1,"amd","w1",null));
		listOfProductDetails.add(productDetails);
		when(repo.findAll()).thenReturn(listOfProductDetails);
		assertEquals(1,serv2.findAll().size());
	}*/
	
	
	@Test
	public void findallproducttest() {
		when(repo.findAll()).thenReturn(List.of(new ProductDetails(1,"p1",32,2,"11032000",new CategoryDetails(1,"c1",null),new WarehouseDetails(1,"amd","w1",null))));
		assertEquals(1, serv2.findAll().size());
	}
	
	
	@Test
	public void saveproducttest() {
		ProductDetails productdetails = new ProductDetails(2,"p2",32,2,"11032000",new CategoryDetails(1,"c1",null),new WarehouseDetails(1,"amd","w1",null));
		when(repo.save(productdetails)).thenReturn(productdetails);
		assertEquals(productdetails, serv2.saveproduct(productdetails));
	}
	
	
	
	@Test
	public void deleteproducttest() {
		//ProductDetails productdetails = new ProductDetails(2,"p2",32,2,"11032000",new CategoryDetails(1,"c1",null),new WarehouseDetails(1,"amd","w1",null));
		serv2.deleteproduct(2);
		verify(repo, times(1)).deleteById(2);
		//assertNull(repo.findById(2));
		
	}
	
}
