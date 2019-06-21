package com.skhanov.geekbrainsspring.controller;

import javax.validation.Valid;

import com.skhanov.geekbrainsspring.persist.model.Goods;
import com.skhanov.geekbrainsspring.persist.model.User;
import com.skhanov.geekbrainsspring.persist.repo.GoodsBrandRepository;
import com.skhanov.geekbrainsspring.persist.repo.GoodsColorRepository;
import com.skhanov.geekbrainsspring.persist.repo.GoodsRepository;
import com.skhanov.geekbrainsspring.persist.repo.GoodsTypeRepository;
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
    private GoodsRepository goodsRepository;
    @Autowired
    private GoodsBrandRepository goodsBrandRepository;
    @Autowired
    private GoodsTypeRepository goodsTypeRepository;
    @Autowired
    private GoodsColorRepository goodsColorRepository;



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

    @GetMapping("goods")
    public String showGoods(Model model) {
        model.addAttribute(PAGE_HEADER, "All Goods");
        model.addAttribute("goods", goodsRepository.findAll());       
        return "admin/goods";
    }

    @GetMapping("goods/create")
    public String createGoods(Model model) {
        model.addAttribute(PAGE_HEADER, "Create Goods");
        model.addAttribute("goods", new Goods());
        model.addAttribute("goodsType", goodsTypeRepository.findAll());
        model.addAttribute("goodsBrand", goodsBrandRepository.findAll());
        model.addAttribute("goodsColor", goodsColorRepository.findAll());
        return "/admin/goods-form";
    }

    @PostMapping("goods")
    public String createGoods(@Valid Goods goods, BindingResult bindingResult) {        
        if(bindingResult.hasErrors()) {
            return "admin/goods-form";
        }
       goodsRepository.save(goods);
       return "redirect:/admin/goods";
    }

    @GetMapping("users/create")
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

    @GetMapping("users/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute(PAGE_HEADER, "Edit User");
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "admin/user-form";
    } 
    
    @GetMapping("goods/edit/{id}")
    public String editGoods(Model model, @PathVariable("id") Long id) {
        model.addAttribute(PAGE_HEADER, "Edit Goods");
        model.addAttribute("goods", goodsRepository.findById(id).get());
        model.addAttribute("goodsType", goodsTypeRepository.findAll());
        model.addAttribute("goodsBrand", goodsBrandRepository.findAll());
        model.addAttribute("goodsColor", goodsColorRepository.findAll());
        return "admin/goods-form";
    }

    @GetMapping("users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(userService.findById(id));
        return "redirect:/admin/users";
    }

    @GetMapping("goods/delete/{id}")
    public String deleteGoods(@PathVariable("id") Long id) {
        goodsRepository.delete(goodsRepository.findById(id).get());
        return "redirect:/admin/goods";
    }

    
}