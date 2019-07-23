package com.skhanov.geekbrainsspring.flows;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class AuthenticationUserData implements Serializable {

    private static final long serialVersionUID = -7522203740433195855L;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;
    
    @NotBlank
    private String confirmPassword;

    
    

    /**
     * @return String return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}