package com.skhanov.geekbrainsspring;

import static org.junit.Assert.assertEquals;

import com.skhanov.geekbrainsspring.persist.model.GoodsColor;
import com.skhanov.geekbrainsspring.persist.model.Role;
import com.skhanov.geekbrainsspring.persist.model.User;
import com.skhanov.geekbrainsspring.persist.repo.GoodsColorRepository;
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
	private GoodsColorRepository goodsColorRepository;

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
		GoodsColor goodsColor = goodsColorRepository.findByName("black");
		assertEquals("black", goodsColor.getName());
	}

}