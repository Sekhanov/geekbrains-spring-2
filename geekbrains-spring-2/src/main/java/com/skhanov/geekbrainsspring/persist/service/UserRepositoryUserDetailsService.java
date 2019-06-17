package com.skhanov.geekbrainsspring.persist.service;

import com.skhanov.geekbrainsspring.persist.model.User;
import com.skhanov.geekbrainsspring.persist.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepository.findByUserName(username);
       if(user != null) {
           return user;
       }
       throw new UsernameNotFoundException("user " + username + "not found");
    }

    
}