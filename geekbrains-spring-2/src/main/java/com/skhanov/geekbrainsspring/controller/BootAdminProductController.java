package com.skhanov.geekbrainsspring.controller;

import com.skhanov.geekbrainsspring.persist.model.Product;
import com.skhanov.geekbrainsspring.persist.repo.ProductBrandRepository;
import com.skhanov.geekbrainsspring.persist.repo.ProductColorRepository;
import com.skhanov.geekbrainsspring.persist.repo.ProductTypeRepository;
import com.skhanov.geekbrainsspring.persist.service.ProductService;
import com.skhanov.geekbrainsspring.persist.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("admin/products")
public class BootAdminProductController {

    private static final String PAGE_HEADER = "pageHeader";

    @Autowired
    @Lazy
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductBrandRepository productBrandRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ProductColorRepository productColorRepository;

    @GetMapping
    public String showProducts(Model model) {
        model.addAttribute(PAGE_HEADER, "All Products");
        model.addAttribute("products", productService.findAll());
        return "admin/products";
    }

    @GetMapping("create")
    public String createProduct(Model model) {
        model.addAttribute(PAGE_HEADER, "Create product");
        model.addAttribute("product", new Product());
        model.addAttribute("productTypes", productTypeRepository.findAll());
        model.addAttribute("productBrands", productBrandRepository.findAll());
        model.addAttribute("productColors", productColorRepository.findAll());
        return "/admin/product-form";
    }

    @GetMapping("edit/{id}")
    public String editProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute(PAGE_HEADER, "Edit product");
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("productTypes", productTypeRepository.findAll());
        model.addAttribute("productBrands", productBrandRepository.findAll());
        model.addAttribute("productColors", productColorRepository.findAll());
        return "admin/product-form";
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/admin/products";
    }

    // @PostMapping
    // public String persistProduct(Product product, BindingResult bindingResult) {
    //     // if (bindingResult.hasErrors()) {            
    //     //     return "admin/product-form";
    //     // }
    //     productService.save(product);
    //     return "redirect:/admin/products";
    // }

    @PostMapping
    public String adminUpsertProduct(Model model, RedirectAttributes redirectAttributes, Product product) {
        model.addAttribute("activePage", "Products");

        try {
            productService.save(product);
        } catch (Exception ex) {            
            redirectAttributes.addFlashAttribute("error", true);
            if (product.getId() == null) {
                return "redirect:/admin/product/create";
            }
            return "redirect:/admin/product/" + product.getId() + "/edit";
        }
        return "redirect:/admin/products";
    }

}