package com.skhanov.geekbrainsspring.persist.service;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.skhanov.geekbrainsspring.persist.model.Order;
import com.skhanov.geekbrainsspring.persist.model.OrderItem;
import com.skhanov.geekbrainsspring.persist.model.User;
import com.skhanov.geekbrainsspring.persist.repo.OrderRepository;
import com.skhanov.geekbrainsspring.persist.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OrderServiceImpl
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private CartService cartService;

    public Order composeNewOrder() {
        Order order = new Order();
        Set<OrderItem> orderItems = cartService.getAllItems().stream().map(e -> new OrderItem(e)).collect(Collectors.toSet());
        order.setOrderItems(orderItems);
        return order;        
    }    

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void save(Order e, Principal principal) {
        String userName = principal.getName();      
        User user = UserRepository.findByUserName(userName);
        e.setOrderTime(new Date());
        e.setUser(user);
        save(e);

    }

    @Override
    public boolean save(Order e) {        
        orderRepository.save(e);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        orderRepository.deleteById(id);
        return true;
    }

    
}