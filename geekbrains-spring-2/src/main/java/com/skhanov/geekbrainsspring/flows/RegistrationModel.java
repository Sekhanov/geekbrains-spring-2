package com.skhanov.geekbrainsspring.flows;

/**
 * RegistrationModel
 */
public class RegistrationModel {

    private AuthenticationUserData authenticationUserData;

    private PersonalUserData personalUserData;

    

    /**
     * @return AuthenticationUserData return the authenticationUserData
     */
    public AuthenticationUserData getAuthenticationUserData() {
        return authenticationUserData;
    }

    /**
     * @param authenticationUserData the authenticationUserData to set
     */
    public void setAuthenticationUserData(AuthenticationUserData authenticationUserData) {
        this.authenticationUserData = authenticationUserData;
    }

    /**
     * @return PersonalUserData return the personalUserData
     */
    public PersonalUserData getPersonalUserData() {
        return personalUserData;
    }

    /**
     * @param personalUserData the personalUserData to set
     */
    public void setPersonalUserData(PersonalUserData personalUserData) {
        this.personalUserData = personalUserData;
    }

}