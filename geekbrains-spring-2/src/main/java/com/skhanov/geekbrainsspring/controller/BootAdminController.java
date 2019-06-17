package com.skhanov.geekbrainsspring.controller;

import javax.validation.Valid;

import com.skhanov.geekbrainsspring.persist.model.User;
import com.skhanov.geekbrainsspring.persist.repo.RoleRepository;
import com.skhanov.geekbrainsspring.persist.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BootAdminController
 */
@Controller
@RequestMapping("/admin")
public class BootAdminController {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public BootAdminController(RoleRepository roleRepository, @Lazy UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }



    @GetMapping 
    public String showAdminMain() {
        return "admin/main";
    }

    @GetMapping("/users")
    public String showAdminUsers(Model model) {
        model.addAttribute("pageHeader", "All Users");
        model.addAttribute("users", userRepository.findAll());
        return "admin/users";
    }

    @GetMapping("/users/create")
    public String createUser(Model model) {
        model.addAttribute("pageHeader", "Create User");
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user-form";
    }

    @PostMapping("users")
    public String createUser(@Valid User user, Model model, BindingResult bindingResult) {
        model.addAttribute("pageHeader", "All Users");
        if(bindingResult.hasErrors()) {
            return "admin/user-form";
        }
        userRepository.save(user);
        return "redirect:/admin/users";
    } 

    
}