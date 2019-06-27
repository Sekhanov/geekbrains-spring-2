package com.skhanov.geekbrainsspring.controller;

import javax.validation.Valid;

import com.skhanov.geekbrainsspring.persist.model.ProductBrand;
import com.skhanov.geekbrainsspring.persist.service.ProductBrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BootAdminProductBrandController
 */
@Controller
@RequestMapping("admin/product-brands")
public class BootAdminProductBrandController {

    private static final String PAGE_HEADER = "pageHeader";

    @Autowired
    private ProductBrandService productBrandService;

    @GetMapping
    public String showProductBrands(Model model) {
        model.addAttribute(PAGE_HEADER, "all product Brands");
        model.addAttribute("productBrands", productBrandService.findAll());
        return "/admin/product-brands";
    }

    @GetMapping("create")
    public String createProductBrand(Model model) {
        model.addAttribute(PAGE_HEADER, "add brand");
        model.addAttribute("productBrand", new ProductBrand());
        return "/admin/product-brand-form";
    }

    @GetMapping("edit/{id}")
    public String editBrand(Model model, @PathVariable("id") Long id) {
        model.addAttribute(PAGE_HEADER, "edit brand");
        model.addAttribute("productBrand", productBrandService.findById(id));
        return "/admin/product-brand-form";
    }

    @GetMapping("delete/{id}")
    public String deleteBrand(@PathVariable("id") Long id) {
        productBrandService.deleteById(id);
        return "redirect:/admin/product-brands";
    }

    @PostMapping
    public String persistBrand(@Valid ProductBrand productBrand, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "admin/product-brand-form";
        }
        productBrandService.save(productBrand);
        return "redirect:/admin/product-brands";
    }


    
}