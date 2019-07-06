package com.skhanov.geekbrainsspring.flows;

import java.util.HashSet;
import java.util.Set;

import com.skhanov.geekbrainsspring.persist.model.Role;
import com.skhanov.geekbrainsspring.persist.model.User;
import com.skhanov.geekbrainsspring.persist.repo.RoleRepository;
import com.skhanov.geekbrainsspring.persist.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

/**
 * RegisterFlowHandler
 */
@Component
public class RegisterFlowHandler {

    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";

    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRepository;

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
        if (!authenticationUserData.getPassword().equals(authenticationUserData.getConfirmPassword())) {
            messageContext.addMessage(
                    new MessageBuilder()
                    .error()
                    .source("confirmPassword")
                    .defaultText("passwords not match")
                    .build());
            return FAILURE;
        }
        if(userService.findByUserName(authenticationUserData.getUserName()) != null) {
            messageContext.addMessage(new MessageBuilder()
            .error()
            .source("userName")
            .defaultText(String.format("User with name: %s already exist", authenticationUserData.getUserName()))
            .build()
            );
            return FAILURE;
        }
        return SUCCESS;
    }

    public String validatePersonalUserInfo() {
        return SUCCESS;
    }

    public String saveNewUser(RegistrationModel registrationModel) {
        User user = new User();
        Role role = roleRepository.findByName("ROLE_USER");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRoles(userRoles);        
        user.setUserName(registrationModel.getAuthenticationUserData().getUserName());
        user.setPassword(registrationModel.getAuthenticationUserData().getPassword());
        user.setFirstName(registrationModel.getPersonalUserData().getFirstName());
        user.setLastName(registrationModel.getPersonalUserData().getLastName());
        user.setEmail(registrationModel.getPersonalUserData().getEmail());        
        userService.save(user);
        return SUCCESS;
    }

}