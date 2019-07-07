package com.skhanov.geekbrainsspring.flows.order;

import java.io.Serializable;

/**
 * DeliveryInfo
 */
public class DeliveryInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String city;

    private String street;

    private Integer house;
    

    /**
     * @return String return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return String return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return Integer return the house
     */
    public Integer getHouse() {
        return house;
    }

    /**
     * @param house the house to set
     */
    public void setHouse(Integer house) {
        this.house = house;
    }

}