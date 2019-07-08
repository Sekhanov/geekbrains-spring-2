package com.skhanov.geekbrainsspring.flows.order;

import java.io.Serializable;

/**
 * Payment
 */
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum PaymentType {
        VISA, 
        MASTER_CARD, 
        MIR
    }

    private PaymentType paymentType;
    private String cartNumber;




    /**
     * @return PaymentType return the paymentType
     */
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     * @param paymentType the paymentType to set
     */
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }


    /**
     * @return String return the cartNumber
     */
    public String getCartNumber() {
        return cartNumber;
    }

    /**
     * @param cartNumber the cartNumber to set
     */
    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

}