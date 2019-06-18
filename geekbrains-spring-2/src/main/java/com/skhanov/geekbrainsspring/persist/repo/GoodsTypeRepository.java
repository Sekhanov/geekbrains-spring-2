package com.skhanov.geekbrainsspring.persist.repo;

import com.skhanov.geekbrainsspring.persist.model.GoodsType;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * GoodsTypeRepository
 */
public interface GoodsTypeRepository extends JpaRepository<GoodsType, Long> {

    GoodsType findByName(String name);
}