package com.skhanov.geekbrainsspring;

import com.skhanov.geekbrainsspring.persist.model.Role;
import com.skhanov.geekbrainsspring.persist.model.User;
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

	@Test
	public void userPersist() {
		User user = userRepository.findByUserName("user");
		System.out.println(user.getPassword());
	}

	@Test
	public void rolePersist() {
		Role role = roleRepository.findByName("ROLE_ADMIN");
		System.out.println(role.getName());
	}

}
