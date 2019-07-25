package com.skhanov.geekbrainsspring;

import static org.junit.Assert.assertEquals;

import com.skhanov.geekbrainsspring.persist.model.Product;
import com.skhanov.geekbrainsspring.persist.model.ProductColor;
import com.skhanov.geekbrainsspring.persist.model.Role;
import com.skhanov.geekbrainsspring.persist.model.User;
import com.skhanov.geekbrainsspring.persist.repo.ProductColorRepository;
import com.skhanov.geekbrainsspring.persist.repo.ProductRepository;
import com.skhanov.geekbrainsspring.persist.repo.RoleRepository;
import com.skhanov.geekbrainsspring.persist.repo.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersistTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ProductColorRepository goodsColorRepository;
	@Autowired 
	private ProductRepository goodRepository;

	@Test
	public void userPersist() {
		User user = userRepository.findByUserName("admin");
		assertEquals("admin", user.getUserName());
	}	

	@Test
	public void rolePersist() {
		Role role = roleRepository.findByName("ROLE_ADMIN");
		assertEquals("ROLE_ADMIN", role.getName());
	}

	@Test
	public void goodsColorPersist() {
		ProductColor goodsColor = goodsColorRepository.findByName("black");
		assertEquals("black", goodsColor.getName());
	}

	@Test 
	public void goodsPersist() {
		Product goods = goodRepository.findById(1l).get();
		System.out.println(goods);
		
	}

}
