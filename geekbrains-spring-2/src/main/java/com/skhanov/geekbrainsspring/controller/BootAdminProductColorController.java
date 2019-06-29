package com.skhanov.geekbrainsspring.controller;

import com.skhanov.geekbrainsspring.aspect.LogAfterExMethod;
import com.skhanov.geekbrainsspring.persist.model.ProductColor;
import com.skhanov.geekbrainsspring.persist.service.ProductColorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BootAdminProductColorController
 */
@Controller
@RequestMapping("/admin/product-colors")
public class BootAdminProductColorController {

    private static final String PAGE_HEADER = "pageHeader";

    @Autowired
    private ProductColorService productColorService;

    @GetMapping
    @LogAfterExMethod
    public String showProductColors(Model model) {
        model.addAttribute(PAGE_HEADER, "product colors");
        model.addAttribute("productColors", productColorService.findAll());
        return "admin/product-colors";
    }

    @GetMapping("create")
    public String createColor(Model model) {
        model.addAttribute(PAGE_HEADER, "create new product");
        model.addAttribute("productColor", new ProductColor());
        return "admin/product-color-form";
    }

    @GetMapping("edit/{id}")
    public String editColor(Model model, @PathVariable("id") Long id) {
        model.addAttribute(PAGE_HEADER, "Edit Color");
        model.addAttribute("productColor", productColorService.findById(id));
        return "admin/product-color-form";
    }

    @GetMapping("delete/{id}")
    public String deleteColor(@PathVariable("id") Long id) {
        productColorService.deleteById(id);
        return "redirect:/product-colors";

    }
}