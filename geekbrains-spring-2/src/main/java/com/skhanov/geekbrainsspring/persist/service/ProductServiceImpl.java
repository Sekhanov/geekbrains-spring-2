package com.skhanov.geekbrainsspring.persist.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.skhanov.geekbrainsspring.persist.model.Picture;
import com.skhanov.geekbrainsspring.persist.model.Product;
import com.skhanov.geekbrainsspring.persist.repo.PictureRepository;
import com.skhanov.geekbrainsspring.persist.repo.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository; 

    @Override
    @Transactional
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    @Transactional
    public boolean save(Product product) {
        if (product.getPictures() == null) {
            product.setPictures(new ArrayList<>());
        }
        if (product.getNewPictures() != null) {
            for (MultipartFile pict : product.getNewPictures()) {
                try {
                    product.getPictures().add(new Picture(pict.getContentType(), pict.getName(), pict.getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        productRepository.save(product);
        return true;
    }

    @Override
    @Transactional
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteProductPicture(Long id, Product product) {
        Picture picture = null;
        for (Picture p : product.getPictures()) {
            if(p.getId() == id) {
                picture = p;
            }
        }
        product.getPictures().remove(picture);  
        productRepository.save(product);
        return false;
    }

}