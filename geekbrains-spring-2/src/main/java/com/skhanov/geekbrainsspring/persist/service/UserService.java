package com.skhanov.geekbrainsspring.persist.service;

import com.skhanov.geekbrainsspring.persist.model.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public interface UserService extends UserDetailsService, CommonCrudInterface<User>{

  

    User findByUserName(String userName);   

    @Override
    default UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public boolean deleteUser(User user);

}