package com.skhanov.geekbrainsspring.persist.service;

import java.util.List;

import com.skhanov.geekbrainsspring.persist.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * UserService
 */
public interface UserService extends UserDetailsService {

    User findById(Long id);

    User findByUserName(String userName);

    boolean save(User user);

    List<User> findAll();

    boolean deleteUser(User user);

}