package com.skhanov.geekbrainsspring.persist.repo;

import com.skhanov.geekbrainsspring.persist.model.GoodsColor;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * GoodsColorRepository
 */
public interface GoodsColorRepository extends JpaRepository<GoodsColor, Long> {

    GoodsColor findByName(String name);
}