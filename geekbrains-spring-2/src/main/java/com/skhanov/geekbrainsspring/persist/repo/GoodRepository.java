package com.skhanov.geekbrainsspring.persist.repo;

import com.skhanov.geekbrainsspring.persist.model.Goods;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * GoodRepository
 */
public interface GoodRepository extends JpaRepository<Goods, Long>{

    
}