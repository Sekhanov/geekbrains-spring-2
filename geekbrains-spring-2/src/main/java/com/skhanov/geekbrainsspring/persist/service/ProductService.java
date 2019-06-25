package com.skhanov.geekbrainsspring.persist.service;

import com.skhanov.geekbrainsspring.persist.model.Product;

/**
 * ProductService
 */
public interface ProductService extends CommonCrudInterface<Product> {  

    boolean deleteProductPicture(Long id, Product product);
}