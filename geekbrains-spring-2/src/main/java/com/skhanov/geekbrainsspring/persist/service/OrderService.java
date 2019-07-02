package com.skhanov.geekbrainsspring.persist.service;

import com.skhanov.geekbrainsspring.persist.model.Order;

/**
 * OrderService
 */
public interface OrderService extends CommonCrudInterface<Order> {
        
    Order composeNewOrder();
}