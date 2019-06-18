package com.skhanov.geekbrainsspring.persist.repo;

import com.skhanov.geekbrainsspring.persist.model.GoodsBrand;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * GoodsBrandRepository
 */
public interface GoodsBrandRepository extends JpaRepository<GoodsBrand, Long> {

    GoodsBrand findByName(String name);
}
