package com.husen.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.husen.jwt.dao.WarehouseDetailsRepository;
import com.husen.jwt.entity.WarehouseDetails;
import com.husen.jwt.service.WarehouseDetailsService;

@SpringBootTest
public class WarehouseRepositoryTest {
	@Autowired
	WarehouseDetailsService wservice;
	
	@MockBean
	WarehouseDetailsRepository wrepo;
	
	@Test
	public void findallwarehousetest() {
		when(wrepo.findAll()).thenReturn(List.of(new WarehouseDetails(1,"amd","c1",null), new WarehouseDetails(2,"rjt","c2",null)));
		assertEquals(2,wservice.findAll().size());
	}
	
	@Test
	public void savewarehousetest() {
		WarehouseDetails warehousedetails = new WarehouseDetails(3,"sut","c3",null);
		when(wrepo.save(warehousedetails)).thenReturn(warehousedetails);
		assertEquals(warehousedetails,wservice.savewarehouse(warehousedetails));
	}
}
