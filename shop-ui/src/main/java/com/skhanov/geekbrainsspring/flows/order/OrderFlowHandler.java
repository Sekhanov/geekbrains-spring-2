package com.skhanov.geekbrainsspring.flows.order;


import java.util.List;
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
    
    // private static final String SUCCESS = "success"; 
    // private static final String FAILURE = "failure";  
    
    
    @Autowired
    private CartService cartService;


    public OrderModel init() {
        return new OrderModel();
    }

    public void fillProductCart(ProductCart productCart) {
        List<ProductCartItem> productCartItems = cartService.getAllItems().stream().map(e -> {
            ProductCartItem productCartItem = new ProductCartItem();
            productCartItem.setId(e.getId());
            if(e.getNewPictures() != null) {
                productCartItem.setMainPicture(e.getNewPictures()[0]);
            }            
            productCartItem.setProductName(e.getProductBrand().getName() + " " +  e.getModel());
            productCartItem.setQuantity(1);
            productCartItem.setShortDescription(e.getShortDescription());
            productCartItem.setPrice(e.getPrice().intValue());
            productCartItem.setItemTotalPrice();
            return productCartItem;            
        }).collect(Collectors.toList());

        productCart.setProductCartItems(productCartItems);
        productCart.setCartTotalPrice();
    } 

    public void cartUpdate(ProductCart productCart) {
        productCart.getProductCartItems().forEach(e -> e.setItemTotalPrice());
        productCart.setCartTotalPrice();
    }

    public void addCartInfo(OrderModel orderModel, ProductCart productCart) {
        orderModel.setProductCart(productCart);
    }

    public void addDeliveryInfo(OrderModel orderModel, DeliveryInfo deliveryInfo) {
        orderModel.setDeliveryInfo(deliveryInfo);
    }

    public void addPaymentInfo(OrderModel orderModel, Payment payment) {
        orderModel.setPayment(payment);
    }

    public void saveOrder(OrderModel orderModel) {
        //TODO save order to database
    }
    
}