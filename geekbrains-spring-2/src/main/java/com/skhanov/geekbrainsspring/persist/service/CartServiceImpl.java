package com.skhanov.geekbrainsspring.persist.service;

import java.util.ArrayList;
import java.util.List;

import com.skhanov.geekbrainsspring.persist.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/**
 * CartServiceImpl
 */
@Service("cartService")
@SessionScope
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductService productService;

    private List<Product> items;

    public CartServiceImpl() {
        items = new ArrayList<>();
    }

    @Override
    public void addItem(Long id) {
        boolean isItem = items.stream().anyMatch(p -> p.getId() == id);
        if(!isItem) {
            items.add(productService.findById(id));
        }
    }

    @Override
    public void removeItem(Long id) {
        for (Product p : items) {
            if(p.getId() == id) {
                items.remove(p);
            }
        }
    }

    @Override
    public List<Product> getAllItems() {
        return items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void clearCart() {
        items.clear();
    }

    
}