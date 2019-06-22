package com.skhanov.geekbrainsspring.persist.repo;

import com.skhanov.geekbrainsspring.persist.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * GoodRepository
 */
public interface ProductRepository extends JpaRepository<Product, Long>{

    
}