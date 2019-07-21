package com.skhanov.geekbrainsspring.persist.repo;


import com.skhanov.geekbrainsspring.persist.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

    
    Role findByName(String name);
}
