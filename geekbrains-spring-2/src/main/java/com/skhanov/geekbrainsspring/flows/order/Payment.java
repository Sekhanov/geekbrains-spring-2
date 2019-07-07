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
        CASH
    }

    private PaymentType paymentType;


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

}