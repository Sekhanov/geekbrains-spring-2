package com.skhanov.geekbrainsspring.flows;

import com.skhanov.geekbrainsspring.persist.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Service;

/**
 * RegisterFlowHandler
 */
@Service
public class RegisterFlowHandler {

    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    @Autowired
    private UserService userService;


    public RegistrationModel init() {
        return new RegistrationModel();
    }

    public void addAuthUserInfo(RegistrationModel registrationModel, AuthenticationUserData authenticationUserData) {
        registrationModel.setAuthenticationUserData(authenticationUserData);
    }

    public void addPersonalUserInfo(RegistrationModel registrationModel, PersonalUserData personalUserData) {
        registrationModel.setPersonalUserData(personalUserData);
    }

    public String validateAuthUserInfo(AuthenticationUserData authenticationUserData, MessageContext messageContext) {
        if(!authenticationUserData.getPassword().equals(authenticationUserData.getConfirmPassword())) {
            messageContext.addMessage(new MessageBuilder()
            .error()
            .source("passwordsMatch")
            .defaultText("passwords not match")
            .build()
            );
            return FAILURE;           
        }
        return SUCCESS;
    }


    
}