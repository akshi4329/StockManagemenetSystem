package com.husen.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.husen.jwt.dao.ProductCategoriesRepository;
import com.husen.jwt.entity.CategoryDetails;
import com.husen.jwt.service.ProductCategoriesService;

@SpringBootTest
public class CategoryRepositoryTest {
	@MockBean
	private ProductCategoriesRepository repo;
	
	@Autowired
	private ProductCategoriesService serv;
	
	@Test
	public void findallcategorytest() {
		when(repo.findAll()).thenReturn(Stream.of(new CategoryDetails(1,"c1",null), new CategoryDetails(2,"c2",null)).collect(Collectors.toList()));
		assertEquals(2, serv.findAll().size());
	}
	@Test
	public void savecategorytest() {
		CategoryDetails categorydetails = new CategoryDetails(3,"c3",null);
		when(repo.save(categorydetails)).thenReturn(categorydetails);
		assertEquals(categorydetails, serv.savecategory(categorydetails));
	}
	
	
	
	
	

}
