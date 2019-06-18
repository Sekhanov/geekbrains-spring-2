package com.skhanov.geekbrainsspring.controller;

import javax.validation.Valid;

import com.skhanov.geekbrainsspring.persist.model.User;
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

    private final RoleRepository roleRepository;
    private final UserService userService;

    @Autowired
    public BootAdminController(RoleRepository roleRepository, @Lazy UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }



    @GetMapping 
    public String showAdminMain(Model model) {
        model.addAttribute("pageHeader", "Main admin Page");
        return "admin/main";
    }

    @GetMapping("/users")
    public String showAdminUsers(Model model) {
        model.addAttribute("pageHeader", "All Users");
        model.addAttribute("users", userService.findAll());
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
        userService.save(user);
        return "redirect:/admin/users";
    } 

    @GetMapping("/users/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("pageHeader", "Edit User");
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