package com.skhanov.geekbrainsspring.flows;

import com.skhanov.geekbrainsspring.persist.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * RegisterFlowHandler
 */
public class RegisterFlowHandler {

    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    @Autowired
    private UserService userService;

    
}