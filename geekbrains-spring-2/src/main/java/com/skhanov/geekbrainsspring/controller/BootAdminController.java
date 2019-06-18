package com.skhanov.geekbrainsspring.controller;

import javax.validation.Valid;

import com.skhanov.geekbrainsspring.persist.model.User;
import com.skhanov.geekbrainsspring.persist.repo.GoodRepository;
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
@RequestMapping("/admin")
public class BootAdminController {

    private static final String PAGE_HEADER = "pageHeader";

    private final RoleRepository roleRepository;
    private final UserService userService;
    private final GoodRepository goodRepository;

    @Autowired
    public BootAdminController(RoleRepository roleRepository, @Lazy UserService userService, GoodRepository goodRepository){
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.goodRepository = goodRepository;
    }



    @GetMapping 
    public String showAdminMain(Model model) {
        model.addAttribute(PAGE_HEADER, "Main admin Page");
        return "admin/main";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute(PAGE_HEADER, "All Users");
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }

    @GetMapping("/goods")
    public String showGoods(Model model) {
        model.addAttribute(PAGE_HEADER, "All Goods");
        model.addAttribute("goods", goodRepository.findAll());
        return "admin/goods";
    }

    @GetMapping("/users/create")
    public String createUser(Model model) {
        model.addAttribute(PAGE_HEADER, "Create User");
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user-form";
    }

    @PostMapping("users")
    public String createUser(@Valid User user, Model model, BindingResult bindingResult) {
        model.addAttribute(PAGE_HEADER, "All Users");
        if(bindingResult.hasErrors()) {
            return "admin/user-form";
        }
        userService.save(user);
        return "redirect:/admin/users";
    } 

    @GetMapping("/users/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute(PAGE_HEADER, "Edit User");
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user-form";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(Model model, @PathVariable("id") Long id) {
        userService.deleteUser(userService.findById(id));
        return "redirect:/admin/users";
    }

    
}