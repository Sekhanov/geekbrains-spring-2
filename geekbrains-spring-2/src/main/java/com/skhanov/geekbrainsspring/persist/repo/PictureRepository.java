package com.skhanov.geekbrainsspring.persist.repo;

import com.skhanov.geekbrainsspring.persist.model.Picture;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PictureRepository
 */
public interface PictureRepository extends JpaRepository<Picture, Long> {

    
}