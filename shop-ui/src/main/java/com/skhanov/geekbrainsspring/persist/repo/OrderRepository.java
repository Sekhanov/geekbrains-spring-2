package com.skhanov.geekbrainsspring.persist.repo;

import com.skhanov.geekbrainsspring.persist.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OrderRepository
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    
}