package com.skhanov.geekbrainsspring.persist.service;

import java.util.List;

import com.skhanov.geekbrainsspring.persist.model.ProductColor;
import com.skhanov.geekbrainsspring.persist.repo.ProductColorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductColorServiceImpl implements ProductColorService {

    @Autowired
    private ProductColorRepository productColorRepository;

    @Override
    public ProductColor findById(Long id) {
        return productColorRepository.findById(id).get();
    }

    @Override
    public List<ProductColor> findAll() {
        return productColorRepository.findAll();
    }

    @Override
    public boolean save(ProductColor e) {
        productColorRepository.save(e);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        productColorRepository.deleteById(id);
        return true;
    }

    
}