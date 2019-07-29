package com.skhanov.geekbrainsspring.controller;

import javax.validation.Valid;

import com.skhanov.geekbrainsspring.persist.model.ProductType;
import com.skhanov.geekbrainsspring.persist.service.ProductTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/product-types")
public class BootAdminProductTypeController {

    private static final String PAGE_HEADER = "pageHeader";

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping
    public String showProductTypes(Model model) {
        model.addAttribute(PAGE_HEADER, "all product Types");
        model.addAttribute("productTypes", productTypeService.findAll());
        return "/admin/product-types";
    }

    @GetMapping("create")
    public String createProductType(Model model) {
        model.addAttribute(PAGE_HEADER, "Create product-type");
        model.addAttribute("productType", new ProductType());
        return "/admin/product-type-form";
    }

    @GetMapping("edit/{id}")
    public String editProductType(Model model, @PathVariable("id") Long id) {
        model.addAttribute(PAGE_HEADER, "edit product type");
        model.addAttribute("productType", productTypeService.findById(id));
        return "/admin/product-type-form";
    }

    @GetMapping("delete/{id}")
    public String deleteProductType(@PathVariable("id") Long id) {
        productTypeService.deleteById(id);
        return "redirect:/admin/product-types";
    }

    @PostMapping
    public String persistProductType(@Valid ProductType productType, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/product-type-form";
        }
        productTypeService.save(productType);
        return "redirect:/admin/product-types";
    }

    
}