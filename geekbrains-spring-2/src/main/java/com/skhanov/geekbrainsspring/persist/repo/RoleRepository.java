package com.skhanov.geekbrainsspring.persist.repo;


import com.skhanov.geekbrainsspring.persist.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {

    // @Query("from Role r where name = :name")
    Role findByName(String name);
}
