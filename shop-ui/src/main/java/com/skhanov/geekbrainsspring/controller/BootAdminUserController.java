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


@Controller
@RequestMapping("admin/users")
public class BootAdminUserController {

    private static final String PAGE_HEADER = "pageHeader";

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    @Lazy
    private UserService userService;

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute(PAGE_HEADER, "All Users");
        model.addAttribute("users", userService.findAll());
        return "admin/users";
    }  

    @GetMapping("create")
    public String createUser(Model model) {
        model.addAttribute(PAGE_HEADER, "Create User");
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user-form";
    }

    @GetMapping("edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute(PAGE_HEADER, "Edit User");
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user-form";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(userService.findById(id));
        return "redirect:/admin/users";
    }

    @PostMapping
    public String persistUser(@Valid User user, Model model, BindingResult bindingResult) {
        model.addAttribute(PAGE_HEADER, "All Users");
        if (bindingResult.hasErrors()) {
            return "admin/user-form";
        }
        userService.save(user);
        return "redirect:/admin/users";
    }

}