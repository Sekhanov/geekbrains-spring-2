package com.skhanov.geekbrainsspring.persist.repo;

import com.skhanov.geekbrainsspring.persist.model.ProductBrand;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * GoodsBrandRepository
 */
public interface ProductBrandRepository extends JpaRepository<ProductBrand, Long> {

    ProductBrand findByName(String name);
}
