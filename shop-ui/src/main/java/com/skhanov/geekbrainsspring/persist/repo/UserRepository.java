package com.skhanov.geekbrainsspring.persist.repo;

import com.skhanov.geekbrainsspring.persist.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    
    User findByUserName(String userName);
}
