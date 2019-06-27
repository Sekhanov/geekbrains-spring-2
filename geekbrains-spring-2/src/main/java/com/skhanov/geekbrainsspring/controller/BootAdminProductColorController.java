package com.skhanov.geekbrainsspring.controller;

import com.skhanov.geekbrainsspring.persist.service.ProductColorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BootAdminProductColorController
 */
@Controller
@RequestMapping("/admin/product-colors")
public class BootAdminProductColorController {

    @Autowired
    private ProductColorService productColorService;

    @GetMapping
    public String showProductColors(Model model) {
        //TODO
        return "product-colors";
    }
}