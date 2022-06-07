package com.husen.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.husen.jwt.dao.UserDao;
import com.husen.jwt.entity.Role;
import com.husen.jwt.entity.User;
import com.husen.jwt.service.UserService;

@SpringBootTest
public class UserRepositoryTest {
	@MockBean
	private UserDao userdao;
	
	@Autowired
	private UserService uservice;
	
	@Test
	// add Role
	public void insertUserTest() {
	Role adminRole = new Role("User","User Role");
	Set<Role> adminRoles = new HashSet<>();
	adminRoles.add(adminRole);
	
	// Register new User
	User user = new User("akshi123","akshi","bavisi","akshi123",adminRoles);
	when(userdao.save(user)).thenReturn(user);
	assertEquals(user, uservice.registerNewUser(user));
	}
	
	
	
	
}
