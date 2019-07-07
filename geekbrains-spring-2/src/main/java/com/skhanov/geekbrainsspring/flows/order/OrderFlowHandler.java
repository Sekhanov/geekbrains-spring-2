package com.skhanov.geekbrainsspring.flows.order;


import java.util.Set;
import java.util.stream.Collectors;

import com.skhanov.geekbrainsspring.flows.order.ProductCart.ProductCartItem;
import com.skhanov.geekbrainsspring.persist.service.CartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * OrderFlowHandler
 */
@Component
public class OrderFlowHandler {
    
    private static final String SUCCESS = "success"; 
    private static final String FAILURE = "failure";  
    
    
    @Autowired
    private CartService cartService;


    public OrderModel init() {
        return new OrderModel();
    }

    public void fillProductCart(ProductCart productCart) {
        Set<ProductCartItem> productCartItems = cartService.getAllItems().stream().map(e -> {
            ProductCartItem productCartItem = new ProductCartItem();
            if(e.getNewPictures() != null) {
                productCartItem.setMainPicture(e.getNewPictures()[0]);
            }            
            productCartItem.setProductName(e.getProductBrand() + " " +  e.getModel());
            productCartItem.setQuantity(1);
            productCartItem.setShortDescription(e.getShortDescription());
            return productCartItem;
        }).collect(Collectors.toSet());

        productCart.setProductCartItems(productCartItems);
    } 
    
}