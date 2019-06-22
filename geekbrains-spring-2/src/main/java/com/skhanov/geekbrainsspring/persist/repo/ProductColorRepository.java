package com.skhanov.geekbrainsspring.persist.repo;

import com.skhanov.geekbrainsspring.persist.model.ProductColor;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * GoodsColorRepository
 */
public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {

    ProductColor findByName(String name);
}