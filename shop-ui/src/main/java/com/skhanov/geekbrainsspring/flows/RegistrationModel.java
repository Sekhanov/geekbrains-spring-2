package com.skhanov.geekbrainsspring.flows;

import java.io.Serializable;

/**
 * RegistrationModel
 */
public class RegistrationModel implements Serializable {

    private static final long serialVersionUID = 5146550045474366706L;

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