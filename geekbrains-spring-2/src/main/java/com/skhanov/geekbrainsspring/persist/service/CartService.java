package com.skhanov.geekbrainsspring.persist.service;

import java.util.List;

import com.skhanov.geekbrainsspring.persist.model.Product;

/**
 * CartService
 */
public interface CartService {

    void addItem(Long id);

    void removeItem(Long id);

    List<Product> getAllProducts();

    int getItemCount();

    void clearCart();

    
}