package com.skhanov.geekbrainsspring.persist.service;

import java.util.List;

import com.skhanov.geekbrainsspring.persist.model.Product;

/**
 * ProductService
 */
public interface ProductService {

    Product findById(Long id);

    boolean save(Product product);

    List<Product> findAll();

    boolean deleteById(Long id);

    boolean deleteProductPicture(Long id, Product product);
}