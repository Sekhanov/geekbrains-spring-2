package com.skhanov.geekbrainsspring.controller;

import javax.validation.Valid;

import com.skhanov.geekbrainsspring.persist.model.Product;
import com.skhanov.geekbrainsspring.persist.model.ProductType;
import com.skhanov.geekbrainsspring.persist.model.User;
import com.skhanov.geekbrainsspring.persist.repo.ProductBrandRepository;
import com.skhanov.geekbrainsspring.persist.repo.ProductColorRepository;
import com.skhanov.geekbrainsspring.persist.repo.ProductRepository;
import com.skhanov.geekbrainsspring.persist.repo.ProductTypeRepository;
import com.skhanov.geekbrainsspring.persist.repo.RoleRepository;
import com.skhanov.geekbrainsspring.persist.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BootAdminController
 */
@Controller
@RequestMapping("admin")
public class BootAdminController {

    private static final String PAGE_HEADER = "pageHeader";

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    @Lazy
    private UserService userService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductBrandRepository productBrandRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private ProductColorRepository productColorRepository;

    @GetMapping
    public String showAdminMain(Model model) {
        model.addAttribute(PAGE_HEADER, "Main admin Page");
        return "admin/main";
    }

    @GetMapping("users")
    public String showUsers(Model model) {
        model.addAttribute(PAGE_HEADER, "All Users");
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

    @GetMapping("products")
    public String showProducts(Model model) {
        model.addAttribute(PAGE_HEADER, "All Products");
        model.addAttribute("products", productRepository.findAll());
        return "admin/products";
    }

    @GetMapping("product-types")
    public String showProductTypes(Model model) {
        model.addAttribute(PAGE_HEADER, "All product Types");
        model.addAttribute("productTypes", productTypeRepository.findAll());
        return "admin/product-types";
    }

    @GetMapping("products/create")
    public String createProduct(Model model) {
        model.addAttribute(PAGE_HEADER, "Create product");
        model.addAttribute("product", new Product());
        model.addAttribute("productTypes", productTypeRepository.findAll());
        model.addAttribute("productBrands", productBrandRepository.findAll());
        model.addAttribute("productColors", productColorRepository.findAll());
        return "/admin/product-form";
    }

    @GetMapping("product-types/create")
    public String createProductType(Model model) {
        model.addAttribute(PAGE_HEADER, "Create product-type");
        model.addAttribute("productType", new ProductType());
        return "admin/product-type-form";
    }

    @GetMapping("users/create")
    public String createUser(Model model) {
        model.addAttribute(PAGE_HEADER, "Create User");
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user-form";
    }

    @PostMapping("products")
    public String persistProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/product-form";
        }
        productRepository.save(product);
        return "redirect:/admin/products";
    }

    @PostMapping("product-types")
    public String persistProductType(@Valid ProductType productType, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/product-type-form";
        }
        productTypeRepository.save(productType);
        return "redirect:/admin/product-types";
    }

    @PostMapping("users")
    public String persistUser(@Valid User user, Model model, BindingResult bindingResult) {
        model.addAttribute(PAGE_HEADER, "All Users");
        if (bindingResult.hasErrors()) {
            return "admin/user-form";
        }
        userService.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("users/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute(PAGE_HEADER, "Edit User");
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user-form";
    }

    @GetMapping("products/edit/{id}")
    public String editProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute(PAGE_HEADER, "Edit product");
        model.addAttribute("product", productRepository.findById(id).get());
        model.addAttribute("productTypes", productTypeRepository.findAll());
        model.addAttribute("productBrands", productBrandRepository.findAll());
        model.addAttribute("productColor", productColorRepository.findAll());
        return "admin/product-form";
    }

    @GetMapping("product-types/edit/{id}")
    public String editProductType(Model model, @PathVariable("id") Long id) {
        model.addAttribute(PAGE_HEADER, "edit product type");
        model.addAttribute("productType", productTypeRepository.findById(id).get());
        return "admin/product-type-form";
    }

    @GetMapping("users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(userService.findById(id));
        return "redirect:/admin/users";
    }

    @GetMapping("product-types/delete/{id}")
    public String deleteProductType(@PathVariable("id") Long id) {
        productTypeRepository.delete(productTypeRepository.findById(id).get());
        return "redirect:/admin/product-types";
    }

    @GetMapping("products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productRepository.delete(productRepository.findById(id).get());
        return "redirect:/admin/products";
    }

}